package model;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Line {
    private String name;
    private ArrayList<Station> stations;

    public Line() {
        this.name = "";
        this.stations = new ArrayList<Station>();
    }

    public Line(String aline) {
        this();
        String[] s = aline.split(" +");
        this.name = s[0];
        for (int i = 1; i < s.length; i++) {
            this.stations.add(new Station(s[i]));
        }
    }

    public void print(OutputStreamWriter output) throws IOException {
        output.write(name + " :");
        for (Station it : stations) {
            output.write(" " + it.toString());
        }
        output.write("\n");
    }

    public String getName() {
        return name;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }
}
