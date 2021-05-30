package Lab7.var4;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TextFile {
    private static final Path FILE = Paths.get("src/source/Lab7_var1.txt");

    private void WordCount(StringBuilder stringBuilder, String[] wordsInText) {
        String[] words = stringBuilder.toString().toLowerCase().replaceAll("\\n", " ")
                .replaceAll("[^А-яа-я ]", "").replaceAll("[\\s]{2,}", " ")
                .split("\\s");
        System.out.println(Arrays.toString(words));

        Map<String, Integer> wordCountMap = new HashMap<>();
        int wordCount = 0;
        for (String word: words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.replace(word,wordCountMap.get(word)+1);
            } else {
                wordCountMap.put(word, 1);
            }
            wordCount+=1;
        }

        System.out.println(wordCount + " - количество слов");

        wordCountMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(System.out::println);

        WordListSearch(wordCountMap, wordsInText);
    }

    public void OpenFile(String[] wordsInText) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Files.readAllLines(FILE));
            WordCount(stringBuilder, wordsInText);
        } catch (Exception e) {
            System.out.println("Exception - " + e);
        }
    }

    private void WordListSearch(Map<String, Integer> wordCount, String[] words) {
        if (words.length!=0){
            Map<String, Integer> wordList = new HashMap<>();
            for (String word: words) {
                if (wordCount.get(word) != null) {
                    wordList.put(word, wordCount.get(word));
                } else {
                    wordList.put(word, 0);
                }
            }
            System.out.println("Слова из заданного списка");
            wordList.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(System.out::println);
        }
    }
}
