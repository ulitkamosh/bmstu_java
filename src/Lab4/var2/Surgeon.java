package Lab4.var2;

public class Surgeon implements Doctor {

    public String name;

    public Surgeon(String name) {
        this.name = name;
    }

    @Override
    public void makeAction() {
        System.out.println("Доктор - " + name + " делает операцию");
    }
}
