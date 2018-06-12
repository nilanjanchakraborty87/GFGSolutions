package com.nc.algorithm.gfg.basic;

import java.util.Arrays;

/**
 * XOR of Sum of every possible pair of an array
 *
 * Given an array A of size n. the task is to generate a new sequence B with size N^2 having elements sum of every
 * pair of array A and find the xor value of sum of all the pairs formed.
 * Note: Here (A[i], A[i]), (A[i], A[j]), (A[j], A[i]) all are considered as different pairs.
 *
 * Input: arr = {1, 5, 6}
 * Output: 4
 */
public class XORPair {

    public static void main(String[] args) {
        int[] arr = {1,5,6};
        System.out.println(sumOfXORUsingLoop(arr));
        System.out.println(sumOfXOR(arr));
    }

    private static int sumOfXOR(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        return xor*2;
    }

    private static int sumOfXORUsingLoop(int[] arr) {
        int xorOfSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                xorOfSum = xorOfSum ^ (arr[i] + arr[j]);
            }
        }
        return (xorOfSum);
    }
}
