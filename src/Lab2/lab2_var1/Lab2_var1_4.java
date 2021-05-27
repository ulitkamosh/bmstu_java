package Lab2.lab2_var1;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab2_var1_4 {
    public static void main(String[] args) {
        DateHeader.datePrint();
        Set<Character> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int indexMin = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите n - ");

        int n = scanner.nextInt();

        String[] strings = new String[n];
        System.out.println("Введите слова");

        for (int i = 0; i < n; i++) {
            while (true) {
                String word = scanner.next();
                if (!word.isEmpty() && !word.contains(" ")) {
                    strings[i] = word.toLowerCase();
                    break;
                } else {
                    System.out.println("Не корректный ввод");
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (char character: strings[i].toCharArray()) {
                set.add(character);
            }
            if (set.size() < min) {
                min = set.size();
                indexMin = i;
            }
            set.clear();
        }
        for (String s: strings) {
            System.out.println(s);
        }
        System.out.println("Слово, в котором число различных символов минимально - " + strings[indexMin]);
    }
}
