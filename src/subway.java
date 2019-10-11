public class subway {
    public static void main(String[] args) {
        Main.main(args);
    }
}
/*
cd src
javac -encoding UTF-8 subway.java Main.java model/NowAt.java model/Edge.java model/Line.java model/Station.java manager/ArgsReader.java manager/FindWay.java manager/TxtLineReader.java
java subway -map ../subway.txt  -o 1.txt
 */