package Lab6.var1;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class FileText {
    private final Path file;
    private static final String ENTER = "\n";

    FileText() {
        this.file = Paths.get("/Users/artemzidkov/Desktop/Lab6/ProgramText.txt");
    }

    FileText(Path file) {
        this.file = file;
    }

    //убрать все не буквенные символы чтобы остались только слова
    public void SortArray(boolean printWordList) {
        ArrayList<String> lineList = OpenFile();
        HashSet<String> wordSet = new HashSet<>();
        Collections.sort(lineList);
        for (String line: lineList) {
            System.out.println(line);
            wordSet.addAll(Arrays.asList(line.replaceAll("\\n", " ")
                    .replaceAll("[^A-Za-z ]", " ").replaceAll("[\\s]{2,}", " ")
                    .split("\\s")));
        }
        if (printWordList) {
            for (String word: wordSet) {
                System.out.println(word);
            }
        }
    }

    private ArrayList<String>  OpenFile() {
        try(FileInputStream fileInputStream = new FileInputStream(file.toFile())) {
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            ArrayList<String> lineList = new ArrayList<>();
            while (bufferedReader.ready()) {
                lineList.add(bufferedReader.readLine());
            }
            return lineList;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<String>();
        }
    }

}

