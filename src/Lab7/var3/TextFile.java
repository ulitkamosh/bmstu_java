package Lab7.var3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextFile {
    private static final Path FILE = Paths.get("src/source/Lab7_var1.txt");

    public void OpenFile() {
        try {
            EncodeText(Files.readAllLines(FILE));
        } catch (Exception e) {
            System.out.println("Exception - " + e);
        }
    }

    private void EncodeText (List<String> strings) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder encodedText = new StringBuilder();
        for (String string: strings) {
            stringBuilder.append(string);
        }
        char[] symbols = stringBuilder.toString().toCharArray();
        int index = 0;
        for (Character symbol: symbols) {
            if ((index + 3) % 3 == 0) {
                System.out.print(symbol);
                encodedText.append(symbol);
            }
            index += 1;
        }
        for (Character symbol: symbols) {
            if ((index + 2) % 3 == 0) {
                System.out.print(symbol);
                encodedText.append(symbol);
            }
            index += 1;
        }
        for (Character symbol: symbols) {
            if ((index + 1) % 3 == 0) {
                System.out.print(symbol);
                encodedText.append(symbol);
            }
            index += 1;
        }
        System.out.println();
        System.out.println("-----------------------------");
        DecodeText(encodedText);
    }

    private void DecodeText(StringBuilder encodedText) {
        StringBuilder decodedText = new StringBuilder();
        int length = encodedText.toString().toCharArray().length;
        for (int i = 0; i < length/3; i++) {
            decodedText.append(encodedText.charAt(i));
            decodedText.append(encodedText.charAt(i + length/3));
            decodedText.append(encodedText.charAt(i + 2*(length/3)));
        }
        System.out.println(decodedText);
    }
}
