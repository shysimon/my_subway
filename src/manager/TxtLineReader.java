package manager;

import model.Line;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class TxtLineReader {
    public static ArrayList<Line> read(String path) throws FileNotFoundException {
        ArrayList<Line> r = new ArrayList<>();
        Scanner input = null;
        try {
            input = new Scanner(new InputStreamReader(new FileInputStream(path), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        while (input.hasNextLine()) {
            String it = input.nextLine();
            if (it.length() == 0) continue;
            Line b = new Line(it);
            r.add(b);
        }
        return r;
    }
}
