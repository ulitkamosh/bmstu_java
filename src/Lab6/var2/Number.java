package Lab6.var2;

import java.util.HashSet;

public class Number {
    public static HashSet<Integer> numberSet = new HashSet<Integer>();

    public static void AddNumber(int number) {
        numberSet.add(number);
    }

    public static void DeleteNumber(int number) {
        numberSet.remove(number);
    }

    public static void PrintNumbers() {
        for (int num: numberSet) {
            System.out.println(num);
        }
        System.out.println("--------------------------------");
    }

    public static void SearchNumber(int number) {
        int mod = Integer.MAX_VALUE;
        int i = 0;
        for (int num: numberSet) {
            if (Math.abs(num - number) < mod) {
                mod = Math.abs(num - number);
                i = num;
            }
        }
        System.out.println("Минимальный модуль разницы - " + mod + ", число - " + i);
        System.out.println("--------------------------------");
    }
}
