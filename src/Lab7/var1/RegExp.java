package Lab7.var1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class RegExp {
    private static final Path FILE = Paths.get("src/source/Lab7_var1.txt");
    private static final String FORMAT = "%3s";

    private int k = 3;
    private char symbol = '?';

    private List<String> OpenFile() {
        try {
            return Files.readAllLines(FILE);
        } catch (Exception e) {
            System.out.println("Exception - " + e);
            return new ArrayList<>();
        }
    }

    public void ChangeSymbol() {
        List<String> list = OpenFile();
        for (String line:list) {
            System.out.println(line.replaceAll(String.format("(\\b\\p{L}{%d})\\p{L}", k),"$1" + symbol));
        }
    }

    private static void printSymbols(final String line) {
        for (char symbol : line.toCharArray()) {
            System.out.printf(FORMAT, symbol);
        }
        System.out.println();
    }

    private static void printSymbolNumbers(final String lines) {
        for (char symbol : lines.toLowerCase().toCharArray()) {
            if (Character.isLetter(symbol)) {
                System.out.printf(FORMAT, (int)symbol - 1071);
            } else {
                System.out.printf(FORMAT, " ");
            }
        }
        System.out.println();
    }

    public void PrintCharNumber() {
        List<String> lines = OpenFile();
        for (final String line : lines) {
            printSymbols(line);
            printSymbolNumbers(line);
        }
    }
}
