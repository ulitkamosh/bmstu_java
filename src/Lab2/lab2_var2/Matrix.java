package Lab2.lab2_var2;

import java.util.Random;

public class Matrix {
    int n;
    int[][] matrix;
    int[][] transposedMatrix;
    int[][] turnedLeftMatrix;

    public Matrix(int n) {
        this.n = n;
        matrix = new int[n][n];
        Random random = new Random();
        System.out.println("Матрица " + n + " x " + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(100);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void matrixTranspose() {
        transposedMatrix = new int[n][n];
        System.out.println("Транспонированная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposedMatrix[i][j] = matrix[j][i];
                System.out.print(transposedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void matrixTurnLeft() {
        turnedLeftMatrix = new int[n][n];
        System.out.println("Матрица на 90 градусов влево: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                turnedLeftMatrix[i][j] = matrix[j][n-1-i];
                System.out.print(turnedLeftMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
