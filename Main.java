import manager.FindWay;
import manager.TxtLineReader;
import model.Line;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<Line> lines = new ArrayList<Line>();
        OutputStreamWriter output = new OutputStreamWriter(System.out);
        FindWay map=new FindWay();
        int type=0;
        String[] names=new String[2];
        // write your code here
        for (int i = 0; i < args.length; i++) {
            String tmp = args[i];
            if (tmp.charAt(0) == '-') {
                String parameter = tmp;
                try {
                    if (tmp.compareTo("-map") == 0) {
                        String filepath;
                        i++;
                        filepath = args[i];
                        if (filepath.charAt(0) == '-')
                            throw new Exception("缺少-map后的一个参数");
                        lines = TxtLineReader.read(filepath);
                        map=new FindWay(lines);
                    } else if (tmp.compareTo("-o") == 0) {
                        String filepath;
                        i++;
                        filepath = args[i];
                        if (filepath.charAt(0) == '-')
                            throw new Exception("缺少-o后的一个参数");
                        output = new OutputStreamWriter(new FileOutputStream(filepath),"utf-8");
                    }
                    else if(tmp.compareTo("-a")==0){
                        if(type!=0){
                            System.out.println("-a,-b都只能出现一次");
                            return;
                        }
                        type=1;
                        String linename;
                        i++;
                        linename = args[i];
                        if (linename.charAt(0) == '-')
                            throw new Exception("缺少-a后的一个参数");
                        names[0]=linename;
                    }
                    else if(tmp.compareTo("-b")==0){
                        if(type!=0){
                            System.out.println("-a,-b都只能出现一次");
                            return;
                        }
                        type=2;
                        for(int j=0;j<2;j++){
                            String stationname;
                            i++;
                            stationname = args[i];
                            if (stationname.charAt(0) == '-')
                                throw new Exception("缺少-b后的参数");
                            names[j]=stationname;
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println(parameter + "后参数错误，文件不存在");
                    return;
                } catch (Exception e) {
                    System.out.println(parameter + "后参数错误");
                    return;
                }
            }
        }
        switch(type){
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
                    map.outLineInf(names[0],output);
                } catch (IOException e) {
                    System.out.println("(文件)输出错误");
                    return;
                } catch (NullPointerException e){
                    System.out.println("该线路不存在");
                    return;
                }
                break;
            case 2:
                try {
                    map.outWay(names[0],names[1],output);
                } catch (IOException e) {
                    System.out.println("(文件)输出错误");
                    return;
                } catch (Exception e){
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