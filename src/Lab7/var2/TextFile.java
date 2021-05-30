package Lab7.var2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TextFile {
    private static final Path FILE = Paths.get("src/source/Lab7_var1.txt");

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
}
