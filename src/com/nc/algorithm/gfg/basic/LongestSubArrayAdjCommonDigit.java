package com.nc.algorithm.gfg.basic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Longest subarray such that adjacent elements have at least one common digit
 *
 * Given an array of N integers, write a program that prints the length of the longest
 * subarray such that adjacent elements of the subarray have at least one digit in common.
 *
 * Input : 12 23 45 43 36 97
 * Output : 3
 * Explanation: The subarray is 45 43 36 which has 4 common in 45, 43 and 3 common in 43, 36.
 *
 * Input : 11 22 33 44 54 56 63
 * Output : 4
 * Explanation: Subarray is 44, 54, 56, 63

 */
public class LongestSubArrayAdjCommonDigit {

    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 54, 56, 63};
        find(arr, arr.length);
    }

    private static void find(int[] arr, int length) {
        int longest = Integer.MIN_VALUE;
        ArrayList<Integer> subArry = new ArrayList<>();
        int[] longestSubArry = null;
        int[][] digits = new int[length][10];
        for (int i = 0; i < length; i++) {
            int num = arr[i];
            while(num != 0){
                digits[i][num%10] = 1;
                num /= 10;
            }
        }


        int count = 1;
        for (int i = 0; i < length -1; i++) {
            if(count == 1){
                subArry.add(arr[i]);
            }
            int j;
            for ( j = 0; j < 10; j++) {
                if((digits[i][j] & digits[i+1][j]) == 1){
                    count++;
                    subArry.add(arr[i+1]);
                    break;
                }
            }

            if(j == 10){
                longest = Math.max(count, longest);
                longestSubArry = subArry.stream().mapToInt(Integer::intValue).toArray();
                count = 1;
                subArry.clear();
            }
        }
        if(!subArry.isEmpty()){
            longestSubArry = subArry.stream().mapToInt(Integer::intValue).toArray();
        }
        System.out.println("SubArry -> " + Arrays.toString(longestSubArry));
        longest = Math.max(longest, count);
        System.out.println("Length -> "+ longest);
    }
}
