package Lab4.var2;

public class Carrier extends Warship{
    @Override
    public void makeAction() {
        System.out.println("Авианосец запускает истребители");
    }

    public static void main(String[] args) {
        Warship warship = new Warship() {
            @Override
            public void makeAction() {
                super.makeAction();
            }
        };
        Carrier carrier = new Carrier();

        warship.makeAction();
        carrier.makeAction();
    }
}
