package od;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName _030huadongchuangkou
 * @Description TODO 滑动窗口
 * 题目描述
 * 有一个N个整数的数组，和一个长度为M的窗口。
 * 窗口从数组内的第一个数开始滑动，直到窗口不能滑动为止。
 * 每次滑动产生一个窗口，和窗口内所有数的和，
 * 求窗口滑动产生的所有窗口和的最大值
 *
 * 输入描述
 * 第一行输入一个正整数N，表示整数个数0 < N < 100000
 *
 * 第二行输入N个整数，整数取值范围[-100,100]
 *
 * 第三行输入正整数M，M代表窗口的大小，M <= N <= 100000
 *
 * 输出描述
 * 窗口滑动产生所有窗口和的最大值
 *
 * 示例一
 * 输入
 * 6
 * 12 10 20 30 15 23
 * 3
 * 输出
 * 68
 * @Author 2+7
 * @Date 2023/3/7 16:30
 */
public class _030huadongchuangkou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        int m = Integer.parseInt(sc.nextLine());
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0,j=m-1;j<n;i++,j++){
            int sum = 0;
            for(int k=i;k<=j;k++){
                sum += arr[k];
            }
            if(sum>max){
                max = sum;
            }
        }
        System.out.println(max);
    }

    //专业
    private static int solution(int n, String[] numsStr, int m) {
        List<Integer> integers = new LinkedList<>();
        Arrays.stream(numsStr)
                .forEach(str -> integers.add(Integer.parseInt(str)));

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n - m + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += integers.get(j);
            }
            if (sum > res) res = sum;
        }

        return res;
    }
}