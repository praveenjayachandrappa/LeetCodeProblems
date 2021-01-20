package math;

public class UglyNumber {

    /**
     * Write a program to check whether a given number is an ugly number.
     *
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
     *
     * Example 1:
     *
     * Input: 6
     * Output: true
     * Explanation: 6 = 2 × 3
     * Example 2:
     *
     * Input: 8
     * Output: true
     * Explanation: 8 = 2 × 2 × 2
     * Example 3:
     *
     * Input: 14
     * Output: false
     * Explanation: 14 is not ugly since it includes another prime factor 7.
     *
     *
     */

    public boolean isUgly(int num) {

        if(num<=0)
            return false;

        while(num%5==0)
            num/=5;

        while(num%3==0)
            num/=3;
        while(num%2==0)
            num/=2;

        return num==1;
    }


    /**
     *  logic for this problem 
     * We simply divide by 5 until we can't, then divide by 3 until we can't, then divide by 2 until we can't.
     *
     * If, at the end of this, we are left with num == 1, that means that num was originally only made up of multiples of 2, 3 and 5.
     *
     *
     *
     */
}
