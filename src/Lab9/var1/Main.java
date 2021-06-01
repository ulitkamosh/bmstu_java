package Lab9.var1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList( new Student("Ivan", 40),
                new Student("Petr", 60),
                new Student("Olga", 70),
                new Student("Petr2", 56));
        studentList.stream().filter(x -> x.name.startsWith("P") && x.rating >= 40 && x.rating <= 60).forEach(x -> System.out.println("Студент - " + x.name));

        System.out.println("Средний балл по всем студентам - " + studentList.stream().mapToInt(x -> x.rating).sum() / studentList.size());
    }

    public static class Student {
        String name;
        int rating;

        public Student(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }
}
