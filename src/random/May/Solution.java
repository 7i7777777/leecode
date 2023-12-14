package random.May;

import java.math.BigInteger;

/**
 * @ClassName Solution
 * @Description TODO 从n个不同元素中，任选m个元素作为一个组合，从n个不同元素中取出m个元素的所有组合，叫做组合数，记为c(n,m)，m≤n。程序给定n，求c(2n,1)，c(2n,3)，...,c(2n, 2n-1)的最大公约数
 * @Author 2+7
 * @Date 2023/5/24 10:03
 */
public class Solution {

    public static void main(String[] args) {
        int n = 2;
        int k = (2 * n) & -(2 * n);
        System.out.println(k);
        BigInteger result = BigInteger.valueOf(0);
        for (int m = 1; m <= n * 2; m += 2) {
            BigInteger Cnm = combination(2 * n, m);
            result = result.gcd(Cnm);
        }
        System.out.println("最大公约数：" + result);
    }

    // c(n, m) = n!/m!(n-m)!
    private static BigInteger combination(int n, int m) {
        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(m).multiply(factorial(n - m));
        return numerator.divide(denominator);
    }

    // n!
    private static BigInteger factorial(int n) {
        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

}