package Lab7.var1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RegExp {
    static Path FILE = Paths.get("source/Lab7_var1.txt");

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
            line.replaceAll("[\\s]{2,}", " ");
            System.out.println(line);
        }
    }
}
