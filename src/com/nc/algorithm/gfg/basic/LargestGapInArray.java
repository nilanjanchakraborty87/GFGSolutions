package com.nc.algorithm.gfg.basic;

/**
 * Given an unsorted array of length N and we have to find largest gap between any two elements of array.
 * In simple words, find max(|Ai-Aj|) where 1 ≤ i ≤ N and 1 ≤ j ≤ N.
 *
 * Input : arr = {3, 10, 6, 7}
 * Output : 7
 * Explanation :
 * Here, we can see largest gap can be
 * found between 3 and 10 which is 7

 * Input : arr = {-3, -1, 6, 7, 0}
 * Output : 10
 * Explanation :
 * Here, we can see largest gap can be
 * found between -3 and 7 which is 10
 *
 */
public class LargestGapInArray {

    public static void main(String[] args) {
        int[] arr = {-3, -1, 6, 7, 0};
        System.out.println(findMaximumGap(arr));
        System.out.println(findMaxGap(arr));
    }

    private static int findMaxGap(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        return (max-min);
    }

    public static int findMaximumGap(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            int num = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                max = Math.max(max, Math.abs(num - arr[j]));
            }
        }
        return max;
    }


}
