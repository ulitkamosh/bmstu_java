package Lab9.var2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<People> peopleList = Arrays.asList( new People("Ivan", 16),
                new People("Petr", 23),
                new People("Maria", 42),
                new People("Alex", 25));

        System.out.println("Сортировка по имени");
        peopleList.stream().sorted(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o2.name.toLowerCase().compareTo(o1.name.toLowerCase());
            }
        }).forEach(x -> System.out.println(x.name));

        System.out.println("Сортировка по возрасту");
        peopleList.stream().sorted(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return Integer.compare(o1.age, o2.age);
            }
        }).forEach(x -> System.out.println(x.name + " Возраст: " + x.age));
    }

    public static class People {
        String name;
        int age;

        public People(String name, int rating) {
            this.name = name;
            this.age = rating;
        }
    }
}