import javafx.util.Pair;
import manager.ArgsReader;
import manager.FindWay;
import model.Line;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, ArrayList<Object>> in = ArgsReader.argsReader(args);
        int type = in.getKey();
        if (type == -1) return;
        FindWay map = (FindWay) in.getValue().get(0);
        String[] names = (String[]) in.getValue().get(1);
        OutputStreamWriter output = (OutputStreamWriter) in.getValue().get(2);
        switch (type) {
            case 0:
                for (Line it : map.getLines()) {
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