package Lab7.var2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TextFile {
    private static final Path FILE = Paths.get("src/source/Lab7_var1.txt");

    private void WordCount(StringBuilder stringBuilder) {
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

        //for (Map.Entry<String, Integer> item: wordCountMap.entrySet()) {
        //    System.out.printf("Key: %s  Value: %d \n", item.getKey(), item.getValue());
        //}

        wordCountMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        Map<Character, Integer> charCountMap = new HashMap<>();
        int charCount = 0;
        for (String word: words) {
            for (char ch: word.toCharArray()) {
                if (charCountMap.containsKey(ch)) {
                    charCountMap.replace(ch,charCountMap.get(ch)+1);
                } else {
                    charCountMap.put(ch, 1);
                }
                charCount+=1;
            }
        }

        System.out.println(charCount + " - количество символов");

        charCountMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

    }

    public void OpenFile() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Files.readAllLines(FILE));
            WordCount(stringBuilder);
        } catch (Exception e) {
            System.out.println("Exception - " + e);
        }
    }
}
