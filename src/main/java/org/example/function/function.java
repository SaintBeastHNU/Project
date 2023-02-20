package org.example.function;

import java.util.Arrays;

public class function {
    double matrix[][] = {  {1 , 4 , 5, 33},
            {8 , 1 , 9, 666},
            {12 , 3 , 5, 912}};
    public void func() {

        int n = matrix.length;
        System.out.println(n);
        for (int k = 0; k < n; k++) {
            int max = k;
            for (int i = k + 1; i < n; i++) {
                if (Math.abs(matrix[i][k]) > Math.abs(matrix[max][k])) {
                    max = i;
                }
            }
            double[] temp = matrix[k];
            matrix[k] = matrix[max];
            matrix[max] = temp;

            for (int i = k + 1; i < n; i++) {
                double factor = matrix[i][k] / matrix[k][k];
                for (int j = k + 1; j < n + 1; j++) {
                    matrix[i][j] -= factor * matrix[k][j];
                }
            }
        }

        // Обратный ход метода Гаусса
        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += matrix[i][j] * solution[j];
            }
            solution[i] = (matrix[i][n] - sum) / matrix[i][i];
        }

        // Вывод решения
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i+1) + " = " + solution[i]);
        }
//        double tmp = arr[0][0];
//        for (int j = 0; j < 4; j++) {
//            arr[0][j] = arr[0][j] / tmp;
//            System.out.println(arr[0][j]);
//        }
//
//        tmp = arr[1][0];
//        for (int j = 0; j < 4; j++) {
//            arr[1][j] -= (arr[0][j] * tmp);
//            System.out.println(arr[1][j]);
//        }
//
//        tmp = arr[2][0];
//        for (int j = 0; j < 4; j++) {
//            arr[2][j] -= (arr[0][j] * tmp);
//            System.out.println(arr[2][j]);
//        }
//        //================================
//        tmp = arr[1][1];
//        for (int j = 0; j < 4; j++) {
//            arr[1][j] = arr[1][j] / tmp;
//            System.out.println(arr[1][j]);
//        }
//
//        tmp = arr[0][1];
//        for (int j = 0; j < 4; j++) {
//                arr[0][j] -= (arr[1][j] * Math.abs(tmp) );
//            System.out.println(arr[0][j]);
//        }
//
//        tmp = arr[2][1];
//        for (int j = 0; j < 4; j++) {
//            arr[2][j] += (arr[1][j] * Math.abs(tmp));
//            System.out.println(arr[2][j]);
//        }
//        // ============================
//
//        tmp = arr[2][2];
//        for (int j = 0; j < 4; j++) {
//            arr[2][j] = arr[2][j] / Math.abs(tmp);
//            System.out.println(arr[2][j]);
//        }
//
//        tmp = arr[0][2];
//        for (int j = 0; j < 4; j++) {
//            arr[0][j] -= (arr[2][j] * Math.abs(tmp));
//            System.out.println(arr[0][j]);
//        }
//
//        tmp = arr[1][2];
//        for (int j = 0; j < 4; j++) {
//            arr[1][j] += (arr[2][j] * Math.abs(tmp));
//            System.out.println(arr[1][j]);
//        }

    }
}
