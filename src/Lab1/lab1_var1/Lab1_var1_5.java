package Lab1.lab1_var1;

import java.util.Scanner;

public class Lab1_var1_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        while (true) {
            System.out.print("Введите число - ");
            if (scanner.hasNextInt()) {
                result = result + scanner.nextInt();
            } else
                break;
        }
        System.out.println("Сумма = " + result);
    }
}
