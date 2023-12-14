package od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName _088xunzaolianxuqujian
 * @Description TODO 寻找连续区间
 * 题目描述
 * 给定一个含有N个正整数的数组，
 * 求出有多少个连续区间（包括单个正整数），
 * 它们的和大于等于x。
 *
 * 输入描述
 * 第一行两个整数N x (0 < N <= 100000 ,0 <= x <= 10000000)
 * 第二行有N个正整数（每个正整数小于等于100）。
 *
 * 输出描述
 * 输出一个整数，表示所求的个数。
 *
 * 示例一
 * 输入
 * 3 7
 * 3 4 7
 * 输出
 * 4
 * 说明
 * 3+4 4+7 3+4+7 7这四组数据都是大于等于7的，所以答案为4
 *
 * 示例二
 * 输入
 * 10 10000000
 * 1 2 3 4 5 6 7 8 9 10
 * 输出
 * 0
 * @Author 2+7
 * @Date 2023/3/24 15:41
 */
public class _088xunzaolianxuqujian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i]>=x){
                res++;
            }
            int j = i+1;
            while(j<N){
                if(arr[i]+arr[j]>=x){
                    res += N-j;
                    break;
                }else{
                    j++;
                }
            }
        }
        System.out.println(res);
    }
}