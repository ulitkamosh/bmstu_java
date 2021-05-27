package Lab7.var1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RegExp {
    static Path FILE = Paths.get("src/source/Lab7_var1.txt");
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
}
