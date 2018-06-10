package com.nc.algorithm.gfg.basic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Check whether a given number is Polydivisible or Not
 *
 * Given an integer n, find whether n is a Polydivisible or not.
 *
 * In mathematics, a number is called Polydivisible if it follows some unique properties.
 *
 * i) The number should not have any leading zeroes.
 * ii) The number formed by first i digits of the input number should be divisible by i, where i > 1 ~and ~i <= number ~of ~digits ~in ~the ~input ~number.
 *
 * If any number follow above properties then it is called Polydivisible number.
 *
 * Input: 345654
 * Output: 345654 is Polydivisible number.
 *
 * Explanation:
 * The first digit of the number is non-zero.
 * The number formed by the first 2 digits(34)
 * is divisible by 2. The number formed by the
 * first 3 digits(345) is divisible by 3.
 * The number formed by the first 4 digits(3456)
 * is divisible by 4. The number formed by the
 * first 5 digits(34565) is divisible by 5.
 * The number formed by the first 6 digits(345654)
 * is divisible by 6.

 * Input: 130
 * Output: 130 is Not Polydivisible number.

 * Input: 129
 * Output: 129 is Polydivisible number.
 *
 */
public class PolyDivisible {

    public static void main(String[] args) {
        int n  = 130;
        System.out.format("%d is polydivisible %b", n, checkPolydivisible(n));
    }

    private static boolean checkPolydivisible(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while(n != 0){
            list.add(n%10);
            n /= 10;
        }
        Collections.reverse(list);
        if(list.get(0) == 0)
            return false;

        for (int i = 2; i < list.size(); i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                temp = temp*10 + list.get(j);
            }
            if(temp % i != 0)
                return false;
        }
        return true;
    }

}
