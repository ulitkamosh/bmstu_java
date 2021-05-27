package Lab4.var2;

public class Neurosurgeon extends Surgeon {
    public Neurosurgeon(String name) {
        super(name);
    }

    @Override
    public void makeAction() {
        System.out.println("Нейрохирург - " + name + " делает операцию");
    }

    public static void main(String[] args) {
        Surgeon surgeon = new Surgeon("Живаго");
        Neurosurgeon neurosurgeon = new Neurosurgeon("Хаус");
        surgeon.makeAction();
        neurosurgeon.makeAction();
    }
}


