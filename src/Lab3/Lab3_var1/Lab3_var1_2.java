package Lab3.Lab3_var1;

public class Lab3_var1_2 {
    public static void main(String[] args) {
        int n = 3;
        int c = 2;
        Vector a = new Vector(n);
        a.printVector();
        Vector b = new Vector(n);
        b.printVector();
        System.out.println("Сложение векторов");
        addVectors(a, b);
        System.out.println("Вычитание векторов");
        subtractVectors(a, b);
        System.out.println("Скалярное произведение векторов");
        System.out.println(multiplyVectors(a, b));
        System.out.println("Умножение вектора на константу c = " + c);
        multiplyVectorOnConst(a, c).printVector();
        System.out.println("Модуль вектора");
        System.out.println(vectorModule(a));
        orthogonalityCheck(a, b);
        collinearityCheck(a, b);
        //System.out.println(multiplyVectors(a, b)*2);
        //System.out.println(multiplyVectors(multiplyVectorOnConst(a, 2.0), b));
        int i = 0;
        do {
            a = new Vector(n);
            i++;
        } while (!collinearityCheck(a, b));
        a.printVector();
        b.printVector();
        //System.out.println(i);
    }


    public static Vector addVectors(Vector a, Vector b) {
        Vector result = new Vector(a);
        if(a.n == b.n) {
            for (int i = 0; i < a.n; i++) {
                result.coordinates[i] = a.coordinates[i] + b.coordinates[i];
            }
            result.printVector();
        } else {
            System.out.println("Разные размерности");
        }
        return result;
    }

    public static Vector subtractVectors(Vector a, Vector b) {
        Vector result = new Vector(a);
        if(a.n == b.n) {
            for (int i = 0; i < a.n; i++) {
                result.coordinates[i] = a.coordinates[i] - b.coordinates[i];
            }
            result.printVector();
        } else {
            System.out.println("Разные размерности");
        }
        return result;
    }

    public static Vector multiplyVectorOnConst(Vector a, double c) {
        Vector result = new Vector(a);
        for (int i = 0; i < a.n; i++) {
            result.coordinates[i] = a.coordinates[i] * c;
        }
        return result;
    }

    public static Double multiplyVectors(Vector a, Vector b) {
        Double result = 0.0;
        if(a.n == b.n) {
            for (int i = 0; i < a.n; i++) {
                result = result + (a.coordinates[i] * b.coordinates[i]);
            }
        } else {
            System.out.println("Разные размерности");
        }
        return result;
    }

    public static Double vectorModule(Vector a) {
        Double result = 0.0;
        for (int i = 0; i < a.n; i++) {
            result = result + (a.coordinates[i]*a.coordinates[i]);
        }
        return Math.sqrt(result);
    }

    public static boolean orthogonalityCheck(Vector a, Vector b){
        if (multiplyVectors(a, b) == 0) {
            System.out.println("Векторы ортогональны");
            return true;
        } else {
            //System.out.println("Векторы не ортогональны");
            return false;
        }
    }

    public static boolean collinearityCheck(Vector a, Vector b){
        if (a.n == b.n) {
            double n;
            n = a.coordinates[0] / b.coordinates[0];
            if (equalsVectors(multiplyVectorOnConst(b, n), a)) {
                System.out.println("Векторы коллинеарны");
                return true;
            } else {
                //System.out.println("Векторы не коллинеарны");
                return false;
            }
        } return false;
    }

    public static boolean equalsVectors(Vector a, Vector b) {
        for (int i = 0; i < a.n; i++) {
            if (a.coordinates[i] != b.coordinates[i])
                return false;
        }
        return true;
    }
}
