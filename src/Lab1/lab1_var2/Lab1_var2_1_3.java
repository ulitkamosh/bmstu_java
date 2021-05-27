package Lab1.lab1_var2;

import java.util.Scanner;

public class Lab1_var2_1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Длинна массива n - ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("n[" + i + "] - ");
            array[i] = scanner.nextInt();
            System.out.println();
        }
        System.out.println("четные");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.println(array[i]);
            }
        }
        System.out.println("нечетные");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                System.out.println(array[i]);
            }
        }
        System.out.println("Числа которые делятся на 3 или на 9");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0 || array[i] % 9 ==0) {
                System.out.println(array[i]);
            }
        }
    }
}
