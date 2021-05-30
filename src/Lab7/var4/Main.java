package Lab7.var4;

public class Main {
    public static void main(String[] args) {
        String[] wordsInText = {"я","он","и","привет"};
        TextFile textFile = new TextFile();
        textFile.OpenFile(wordsInText);
    }
}
