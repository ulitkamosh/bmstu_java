package Lab2.lab2_var1;

import java.time.LocalDate;

public class DateHeader {
    static final LocalDate DATE_OF_RECEIVING = LocalDate.of(2021, 2, 12);
    static final String DEV_NAME = "Жидков А.А.";

    public static void datePrint() {
        System.out.println("Имя разработчика - " + DEV_NAME);
        System.out.println("Дата получения задания - " + DATE_OF_RECEIVING);
        System.out.println("Дата сдачи задания - " + LocalDate.now());
        System.out.println();
    }
}
