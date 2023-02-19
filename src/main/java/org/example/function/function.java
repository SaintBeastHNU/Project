package org.example.function;

import java.util.Arrays;

public class function {
    double arr[][] = {  {1 , 4 , 5, 33},
            {8 , 1 , 9, 666},
            {12 , 3 , 5, 912}};
    public void func() {
        double tmp = arr[0][0];
        for (int j = 0; j < 4; j++) {
            arr[0][j] = arr[0][j] / tmp;
            System.out.println(arr[0][j]);
        }

        tmp = arr[1][0];
        for (int j = 0; j < 4; j++) {
            arr[1][j] -= (arr[0][j] * tmp);
            System.out.println(arr[1][j]);
        }

        tmp = arr[2][0];
        for (int j = 0; j < 4; j++) {
            arr[2][j] -= (arr[0][j] * tmp);
            System.out.println(arr[2][j]);
        }
        //================================
        tmp = arr[1][1];
        for (int j = 0; j < 4; j++) {
            arr[1][j] = arr[1][j] / tmp;
            System.out.println(arr[1][j]);
        }

        tmp = arr[0][1];
        for (int j = 0; j < 4; j++) {
                arr[0][j] -= (arr[1][j] * Math.abs(tmp) );
            System.out.println(arr[0][j]);
        }

        tmp = arr[2][1];
        for (int j = 0; j < 4; j++) {
            arr[2][j] += (arr[1][j] * Math.abs(tmp));
            System.out.println(arr[2][j]);
        }
        // ============================

        tmp = arr[2][2];
        for (int j = 0; j < 4; j++) {
            arr[2][j] = arr[2][j] / Math.abs(tmp);
            System.out.println(arr[2][j]);
        }

        tmp = arr[0][2];
        for (int j = 0; j < 4; j++) {
            arr[0][j] -= (arr[2][j] * Math.abs(tmp));
            System.out.println(arr[0][j]);
        }

        tmp = arr[1][2];
        for (int j = 0; j < 4; j++) {
            arr[1][j] += (arr[2][j] * Math.abs(tmp));
            System.out.println(arr[1][j]);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + "\t \t");
            }
            System.out.println();
        }
    }
}
