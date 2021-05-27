package Lab6.var2;

public class Main {
    public static void main(String[] args) {
        Number.PrintNumbers();

        Number.AddNumber(4);
        Number.AddNumber(555);
        Number.AddNumber(666);
        Number.AddNumber(-420);
        Number.AddNumber(228);

        Number.PrintNumbers();

        Number.DeleteNumber(666);
        Number.DeleteNumber(666);

        Number.PrintNumbers();

        Number.SearchNumber(432);
        Number.SearchNumber(-432);

    }
}
