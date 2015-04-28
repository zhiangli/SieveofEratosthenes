package com.example.lenovo.sieveoferatosthenes;

import java.util.Arrays;

/**
 * Created by lenovo on 2015/4/28.
 */
public class Calculate {

    public static String getPrime(int num) {
        boolean[] arr = new boolean[num];
        StringBuilder res = new StringBuilder();
        Arrays.fill(arr, Boolean.TRUE);
        for (int i = 1; i < num; i++) {
            if (arr[i]) {
                int mul = 2;
                int temp;
                while ((temp = mul * (i + 1)) <= num) {
                    arr[temp - 1] = false;
                    mul++;
                }
            }
        }

        res.append("All the prime number less than ");
        res.append(num);
        res.append(": ");

        for (int i = 1; i < num; i++) {
            if (arr[i]) {
                res.append(i + 1);
                res.append(", ");
            }
        }

        return res.toString();
    }
}
