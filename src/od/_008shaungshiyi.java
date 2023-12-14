package od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName _008shaungshiyi
 * @Description TODO 题目描述
 * 双十一众多商品进行打折销售，小明想购买一些自己心仪的商品，
 * 但由于受购买资金限制，所以他决定从众多心意商品中购买3件，
 * 而且想尽可能的花完资金，
 * 现在请你设计一个程序帮助小明计算尽可能花费的最大资金额。
 * <p>
 * 输入描述
 * 第一行为整型数组M，数组长度小于100，数组元素记录单个商品的价格；
 * 单个商品价格小于1000；
 * 第二行输入为购买资金的额度R；
 * R < 100000。
 * <p>
 * 输出描述
 * 输出为满足上述条件的最大花费额度
 * 如果不存在满足上述条件的商品请返回-1
 * <p>
 * 示例一
 * 输入
 * 23,26,36,27
 * 78
 * 输出
 * 76
 * 示例二
 * 输入
 * 23,30,40
 * 26
 * 输出
 * -1
 * @Author 2+7
 * @Date 2023/3/2 16:44
 */
public class _008shaungshiyi {

    private static void solution1(int x, int[] arr) {
        int sum = -1;
        Arrays.sort(arr);
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (flag) {
                break;
            }
            int j = i + 1;
            int k = arr.length - 1;
            int temp = -1;
            while (j < k) {
                temp = arr[i] + arr[j] + arr[k];
                if (temp < x && temp > sum) {
                    sum = temp;
                    j++;
                }
                if (temp > x) {
                    k--;
                }
                if (temp == x) {
                    System.out.println(x);
                    flag = true;
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    private static void solution(int x, int[] arr) {
        int sum = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = arr.length - 1; k > j; k--) {
                    int temp = arr[i] + arr[j] + arr[k];
                    if (temp < x && temp > sum) {
                        sum = temp;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int x = sc.nextInt();
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        solution1(x, arr);
    }
}