package Lab2.lab2_var1;

import java.util.Scanner;

public class Lab2_var1_1 {
    public static void main(String[] args) {
        DateHeader.datePrint();

        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        System.out.print("Введите n - ");

        int n = scanner.nextInt();

        String[] strings = new String[n];
        System.out.println("Введите строки");
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
            if (strings[i].length() > max) {
                max = strings[i].length();
                maxIndex = i;
            }
            if (strings[i].length() < min) {
                min = strings[i].length();
                minIndex = i;
            }
        }

        System.out.println("Самая большая строка - " + strings[maxIndex]);
        System.out.println("Самая маленькая строка - " + strings[minIndex]);
    }
}
