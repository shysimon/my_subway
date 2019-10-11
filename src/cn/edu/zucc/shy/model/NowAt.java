package cn.edu.zucc.shy.model;

public class NowAt {
    public int from, atStation, atLine, length, changeLine;

    public NowAt() {
    }

    public NowAt(int from, int atStation, int atLine, int length, int changeLine) {
        this.from = from;
        this.atStation = atStation;
        this.atLine = atLine;
        this.length = length;
        this.changeLine = changeLine;
    }
}