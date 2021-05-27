package Lab5.var3;

public class Main {
    public static void main(String[] args) {
        String[] wordList = {"я","он","и","привет"};
        TextFile textFile = new TextFile();
        //textFile.ReadFile(true);
        textFile.ReadFile(true, wordList);
    }
}
