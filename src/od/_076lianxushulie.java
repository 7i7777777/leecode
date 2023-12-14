package od;

import java.util.Scanner;

/**
 * @ClassName _076lianxushulie
 * @Description TODO 求解连续数列
 * 题目描述
 * 已知连续正整数数列{K}=K1,K2,K3… Ki的各个数相加之和为S,
 * i = N (0 < S < 100000, 0 < N < 100000), 求此数列K。
 * <p>
 * 输入描述
 * 输入包含两个参数
 * <p>
 * 连续正整数数列和S
 * 数列里数的个数N
 * 输出描述
 * 如果有解输出数列K，如果无解输出-1
 * <p>
 * 示例一
 * 输入
 * 525 6
 * 输出
 * 85 86 87 88 89 90
 * @Author 2+7
 * @Date 2023/3/21 16:25
 */
public class _076lianxushulie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int mid = s / n;
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(mid+i-n/2);
                if(i!=n-1){
                    System.out.print(" ");
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print(mid+i-n/2+1);
                if(i!=n-1){
                    System.out.print(" ");
                }
            }
        }
    }
}