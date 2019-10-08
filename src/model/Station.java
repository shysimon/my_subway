package model;

public class Station {
    private String name;

    public Station() {
        name = "";
    }

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return getName();
    }
}
