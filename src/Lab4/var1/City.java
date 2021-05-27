package Lab4.var1;

import java.util.ArrayList;

public class City {
    public static void main(String[] args) {
        ArrayList<CityObject> City = new ArrayList<>();
        City.add(new Street("Синичка"));
        City.add(new Street("Первая парковая"));
        City.add(new Square("Красная площадь", "это главная площадь в городе"));
        City.add(new Prospect("Ленина", "самый длинный проспект"));
        City.add(new Prospect("Перовский"));
        print(City);
    }

    public static void print(ArrayList<CityObject> city) {
        System.out.println("В городе:");
        for (CityObject object: city) {
            System.out.println(object.toString());
        }
    }
}

class CityObject {
    String name;
    String info = "";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "CityObject{" +
                "name='" + name + '\'' +
                '}';
    }

    public void printInfo() {
        System.out.println(info);
    }

    public CityObject(String name) {
        this.name = name;
    }
}

class Street extends CityObject {

    public Street(String name) {
        super(name);
    }

    public Street(String name, String info) {
        super(name);
        this.info = info;
    }

    @Override
    public String toString() {
        if (info.isEmpty()) {
            return "Улица - " + name;
        } else {
            return "Улица - " + name + " - " + info;
        }
    }
}
class Prospect extends CityObject {

    public Prospect(String name) {
        super(name);
    }

    public Prospect(String name, String info) {
        super(name);
        this.info = info;
    }

    @Override
    public String toString() {
        if (info.isEmpty()) {
            return "Проспект - " + name;
        } else {
            return "Проспект - " + name + " - " + info;
        }
    }
}
class Square extends CityObject {

    public Square(String name) {
        super(name);
    }

    public Square(String name, String info) {
        super(name);
        this.info = info;
    }

    @Override
    public String toString() {
        if (info.isEmpty()) {
            return "Площадь - " + name;
        } else {
            return "Площадь - " + name + " - " + info;
        }
    }
}