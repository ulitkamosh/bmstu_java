package Lab5.var3;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TextFile {
    Path file;

    TextFile() {
        this.file = Paths.get("src/source/Lab7_var1.txt");
    }

    TextFile(Path file) {
        this.file = file;
    }

    private void InputStreamReader(boolean useOneWordReader, String[] words) {
        if (useOneWordReader) {
            try(FileInputStream fileInputStream = new FileInputStream(file.toFile())){
                Reader reader = new InputStreamReader(fileInputStream);
                OneWordReader(new BufferedReader(reader), words);
            } catch (IOException e) {
                System.out.println("Exception - " + e);
            }
        } else {
            try (FileInputStream fileInputStream = new FileInputStream(file.toFile())) {
                Reader reader = new InputStreamReader(fileInputStream);
                OneLineReader(new BufferedReader(reader), words);
            } catch (IOException e) {
                System.out.println("Exception - " + e);
            }
        }
    }

    private Map<String, Double> WordCount(StringBuilder stringBuilder) {
        String[] words = stringBuilder.toString().toLowerCase().replaceAll("\\n", " ")
                .replaceAll("[^А-яа-я ]", "").replaceAll("[\\s]{2,}", " ")
                .split("\\s");
        System.out.println(Arrays.toString(words));

        Map<String, Double> wordCountMap = new HashMap<>();
        int wordCount = 0;
        for (String word: words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.replace(word,wordCountMap.get(word)+1);
            } else {
                wordCountMap.put(word, 1.0);
            }
            wordCount+=1;
        }

        for (Map.Entry<String, Double> item: wordCountMap.entrySet()) {
            item.setValue((double) Math.round((item.getValue()/wordCount)*10000)/10000);
        }
        System.out.println(wordCount + " - количество слов");

        //for (Map.Entry<String, Integer> item: wordCountMap.entrySet()) {
        //    System.out.printf("Key: %s  Value: %d \n", item.getKey(), item.getValue());
        //}

        wordCountMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        Map<Character, Double> charCountMap = new HashMap<>();
        int charCount = 0;
        for (String word: words) {
            for (char ch: word.toCharArray()) {
                if (charCountMap.containsKey(ch)) {
                    charCountMap.replace(ch,charCountMap.get(ch)+1);
                } else {
                    charCountMap.put(ch, 1.0);
                }
                charCount+=1;
            }
        }

        for (Map.Entry<Character, Double> item: charCountMap.entrySet()) {
            item.setValue((double) Math.round((item.getValue()/charCount)*10000)/10000);
        }
        System.out.println(charCount + " - количество символов");

        charCountMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        return wordCountMap;
    }

    private void OneWordReader(BufferedReader bufferedReader, String[] words) {
        try {
            int c;
            StringBuilder stringBuilder = new StringBuilder();
            while ((c = bufferedReader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            Map<String, Double> wordCount = WordCount(stringBuilder);
            WordListSearch(wordCount, words);
        } catch (IOException e) {
            System.out.println("Exception - " + e);
        }
    }

    private void OneLineReader(BufferedReader bufferedReader, String[] words) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine());
                stringBuilder.append(' ');
            }
            Map<String, Double> wordCount = WordCount(stringBuilder);
            WordListSearch(wordCount, words);
        } catch (IOException e) {
            System.out.println("Exception - " + e);
        }
    }

    private void WordListSearch(Map<String, Double> wordCount, String[] words) {
        if (words.length!=0){
            Map<String, Double> wordList = new HashMap<>();
            for (String word: words) {
                if (wordCount.get(word) != null) {
                    wordList.put(word, wordCount.get(word));
                } else {
                    wordList.put(word, 0.0);
                }
            }
            System.out.println("Слова из заданного списка");
            wordList.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        }
    }

    public void ReadFile(boolean useOneWordReader, String[] words) {
        InputStreamReader(useOneWordReader, words);
    }

    public void ReadFile(boolean useOneWordReader) {
        String[] words = new String[0];
        InputStreamReader(useOneWordReader, words);
    }
}
