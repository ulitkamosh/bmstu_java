package Lab3.Lab3_var1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFile {
    Path directory = Paths.get("/Users/artemzidkov/Desktop/Lab3/");
    Path directoryFile = Paths.get(directory + "/" + "file1.txt");

    public static void createFile(String stringPath) throws IOException {
        if (Files.notExists(Paths.get(stringPath))) {
            Files.createFile(Paths.get(stringPath));
            System.out.println("File Created");
        } else {
            System.out.println("File already exists");
        }
    }

    public void deleteFile() throws IOException {
        if (Files.exists(directoryFile)) {
            Files.delete(directoryFile);
            System.out.println("File deleted");
        } else {
            System.out.println("File does not exist");
        }
    }

    public void printToFile(String string) throws IOException {
        if (Files.exists(directoryFile)) {
            //OutputStream outputStream = Files.newOutputStream(directory);
            //PrintStream printStream = new PrintStream(outputStream);
            //printStream.print(string);
            System.out.println(directoryFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(directoryFile.toString(), true));
            writer.write(' ');
            writer.write(string);
            writer.close();
            System.out.println(string + " - Printed to file");
        }
    }

    public void renameFile(String newName) {
        Path filePath = directoryFile;
        Path fileNewPath = Paths.get(directory + "/" + newName);
        try {
             if (!Files.exists(fileNewPath)) {
                Files.move(filePath, fileNewPath);
                directoryFile = fileNewPath;
                System.out.println("File moved");
            } else {
                 System.out.println("File is missing or already created!");
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
