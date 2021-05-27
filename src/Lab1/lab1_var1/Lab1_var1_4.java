package Lab1.lab1_var1;

import java.util.Scanner;

public class Lab1_var1_4 {
    public static void main(String[] args) {
        final String PASSWORD = new String("pa22word");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.nextLine().equals(PASSWORD)) {
                System.out.println("Пароль верный");
                break;
            }
            else
                System.out.println("Пароль не верный");
        }
    }
}
