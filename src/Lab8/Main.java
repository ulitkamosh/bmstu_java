package Lab8;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount(10);
        BankAccount bankAccount2 = new BankAccount(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {

            Transaction transaction1 = new Transaction(bankAccount1, random.nextLong(), random.nextBoolean());
            Transaction transaction2 = new Transaction(bankAccount2, random.nextLong(), random.nextBoolean());

            transaction1.start();
            transaction2.start();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("...");
        }
    }
}
