package com.nc.algorithm.gfg.basic;

/**
 * Given an array of N integers. The bitwise OR of all the elements of the array has to be maximized by performing
 * one task. The task is to multiply any element of the array at-most k times with a given integer x.
 *
 * Input: a = {1, 1, 1}, k = 1, x = 2
 * Output: 3
 *
 * Explanation: Any possible choice of doing one element
 * of the array will result the same three numbers 1, 1, 2.
 * So, the result is 1 | 1 | 2 = 3.

 * Input: a = {1, 2, 4, 8}, k = 2, x = 3
 * Output: 79
 *
 *
 */
public class MaxBitwiseOR {

    public static void main(String[] args) {
        int[] arr = {1,2,4,8};
        int k = 2;
        int x = 3;
        int n = arr.length;

        int pow = 1;

        int count = k;
        while(count > 0){
            pow = pow*x;
            count--;
        }

        int[] frontOR = new int[n+1];
        for (int i = 0; i < n; i++) {
            frontOR[i+1] = frontOR[i] | arr[i];
        }

        int[] rearOR = new int[n+1];
        for (int i = n-1; i >= 0; i--) {
            rearOR[i] = rearOR[i+1] | arr[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,(frontOR[i] | arr[i]*pow | rearOR[i+1]));
        }

        System.out.println(max);
    }
}
