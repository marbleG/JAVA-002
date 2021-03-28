package com.example.demo;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        System.out.println(Arrays.toString(ints));
        for (int anInt : ints) {
            anInt = anInt + 1;
        }
        System.out.println(Arrays.toString(ints));
        for (int i = 0; i < ints.length; i++) {
            ints[i] = ints[i] + 1;
        }
        System.out.println(Arrays.toString(ints));

        Arrays.stream(ints).forEach(i -> i = i + 1);
        System.out.println(Arrays.toString(ints));
    }
}
