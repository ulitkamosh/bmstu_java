package Lab5.var4;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProgramTextFile {
    Path file;
    private static final String PUBLIC = "public";
    private final int wordLength = PUBLIC.length();
    private static final String PRIVATE = "private";
    private static final String ENTER = "\n";


    ProgramTextFile() {
        this.file = Paths.get("/Users/artemzidkov/Desktop/Lab5/ProgramText.txt");
    }

    ProgramTextFile(Path file) {
        this.file = file;
    }

    //Только при объялении атрибутов или всегда?
    public void ChangePublicToPrivate() {
        StringBuilder stringBuilder = OpenFile(false);
        int lastIndex = stringBuilder.lastIndexOf(PUBLIC);
        while (lastIndex != -1){
            stringBuilder.replace(lastIndex, lastIndex + wordLength, PRIVATE);
            lastIndex = stringBuilder.lastIndexOf(PUBLIC);
        }
        System.out.println(stringBuilder);
    }

    public void ReverseInput() {
        StringBuilder stringBuilder = OpenFile(true);
        System.out.println(stringBuilder);
    }

    private StringBuilder OpenFile(boolean forReverseInput) {
        try(FileInputStream fileInputStream = new FileInputStream(file.toFile())) {
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            if (!forReverseInput) {
                while (bufferedReader.ready()) {
                    stringBuilder.append(bufferedReader.readLine());
                    stringBuilder.append(ENTER);
                }
            } else {
                StringBuilder oneLine = new StringBuilder();
                while (bufferedReader.ready()) {
                    oneLine.append(bufferedReader.readLine());
                    stringBuilder.append(oneLine.reverse());
                    oneLine.delete(0, oneLine.length());
                    stringBuilder.append(ENTER);
                }
            }
            return stringBuilder;
        } catch (IOException e) {
            e.printStackTrace();
            return new StringBuilder();
        }
    }

}
