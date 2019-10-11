package cn.edu.zucc.shy.model;

public class Edge {
    private int to, atLine;

    public Edge() {
    }

    public Edge(int to, int atLine) {
        this.to = to;
        this.atLine = atLine;
    }

    public int getTo() {
        return to;
    }

    public int getAtLine() {
        return atLine;
    }
}
