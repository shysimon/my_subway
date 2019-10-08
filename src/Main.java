import manager.FindWay;
import manager.TxtLineReader;
import model.Line;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Line> lines = new ArrayList<>();
        OutputStreamWriter output = new OutputStreamWriter(System.out);
        FindWay map = new FindWay();
        int type = 0, hasMap = 0;
        String[] names = new String[2];
        // write your code here
        for (int i = 0; i < args.length; i++) {
            String tmp = args[i];
            if (tmp.charAt(0) == '-') {
                try {
                    if (tmp.compareTo("-map") == 0) {
                        String filepath;
                        i++;
                        filepath = args[i];
                        if (filepath.charAt(0) == '-')
                            throw new Exception("缺少-map后的一个参数");
                        lines = TxtLineReader.read(filepath);
                        map = new FindWay(lines);
                        hasMap = 1;
                    } else if (tmp.compareTo("-o") == 0) {
                        String filepath;
                        i++;
                        filepath = args[i];
                        if (filepath.charAt(0) == '-')
                            throw new Exception("缺少-o后的一个参数");
                        output = new OutputStreamWriter(new FileOutputStream(filepath), StandardCharsets.UTF_8);
                    } else if (tmp.compareTo("-a") == 0) {
                        if (type != 0) {
                            System.out.println("-a,-b都只能出现一次，使用-help参数查看帮助");
                            return;
                        }
                        type = 1;
                        i++;
                        String lineName = args[i];
                        if (lineName.charAt(0) == '-')
                            throw new Exception("缺少-a后的一个参数");
                        names[0] = lineName;
                    } else if (tmp.compareTo("-b") == 0) {
                        if (type != 0) {
                            System.out.println("-a,-b都只能出现一次，使用-help参数查看帮助");
                            return;
                        }
                        type = 2;
                        for (int j = 0; j < 2; j++) {
                            i++;
                            String stationName = args[i];
                            if (stationName.charAt(0) == '-')
                                throw new Exception("缺少-b后的参数");
                            names[j] = stationName;
                        }
                    } else if (tmp.compareTo("-help") == 0) {
                        System.out.println(tmp + "参数请单独使用");
                        return;
                    } else {
                        System.out.println("无效参数" + tmp + "，使用-help参数查看帮助");
                        return;
                    }
                } catch (FileNotFoundException e) {
                    System.out.println(tmp + "后参数错误，文件不存在，使用-help参数查看帮助");
                    return;
                } catch (Exception e) {
                    System.out.println(tmp + "后参数错误，使用-help参数查看帮助");
                    return;
                }
            }
        }
        if (hasMap == 0) {
            System.out.println("请使用-map参数传入地铁数据，使用-help参数查看帮助");
            return;
        }
        switch (type) {
            case 0:
                for (Line it : lines) {
                    try {
                        it.print(output);
                    } catch (IOException e) {
                        System.out.println("(文件)输出错误");
                        return;
                    }
                }
                break;
            case 1:
                try {
                    map.outLineInf(names[0], output);
                } catch (IOException e) {
                    System.out.println("(文件)输出错误");
                    return;
                } catch (NullPointerException e) {
                    System.out.println("该线路不存在");
                    return;
                }
                break;
            case 2:
                try {
                    map.outWay(names[0], names[1], output);
                } catch (IOException e) {
                    System.out.println("(文件)输出错误");
                    return;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return;
                }
                break;
        }

        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("(文件)输出错误");
        }
    }
}
