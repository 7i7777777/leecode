package od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName _086fenpingguo
 * @Description TODO 分苹果
 * 题目描述
 * AB两个人把苹果分为两堆
 * A希望按照他的计算规则等分苹果
 * 他的计算规则是按照二级制加法计算
 * 并且不计算进位12+5=9(1100+0101=9),
 * B的计算规则是十进制加法,
 * 包括正常进位,B希望在满足A的情况下获取苹果重量最多
 * 输入苹果的数量和每个苹果重量
 * 输出满足A的情况下B获取的苹果总重量
 * 如果无法满足A的要求 输出-1
 * 数据范围：
 * 1 <= 苹果数量 <= 20000
 * 1 <= 每个苹果重量 <= 10000
 *
 * 输入描述
 * 输入第一行是苹果数量:3
 * 输入第二行是每个苹果重量:3 5 6
 *
 * 输出描述
 * 输出第一行是B获取的苹果总重量:11
 *
 * 示例一
 * 输入
 * 3
 * 3 5 6
 * 输出
 * 11
 * 示例二
 * 输入
 * 8
 * 7258 6579 2602 6716 3050 3564 5396 1773
 * 输出
 * 35165
 * 说明
 * 按照A的计算方法5+6=3(101+110不算进位的话，值为3)
 * @Author 2+7
 * @Date 2023/3/22 14:50
 */
public class _086fenpingguo {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int N = Integer.parseInt(scanner.nextLine());
            String line = scanner.nextLine();

            solution(line);

        }
    }

    private static void solution(String line) {
        String[] strs = line.split(" ");
        int[] ints = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }

        Arrays.sort(ints);


        int max = -1;

        for (int i = 1; i < ints.length - 1; i++) {
            int sumBin1 = 0;
            int sumBin2 = 0;
            int sum1 = 0;
            int sum2 = 0;
            //left
            for (int j = 0; j < i; j++) {
                sumBin1 = sumBin1 ^ ints[j];
                sum1 += ints[j];
            }
            //right
            for (int j = i; j < ints.length; j++) {
                sumBin2 = sumBin2 ^ ints[j];
                sum2 += ints[j];
            }

            if (sumBin1 == sumBin2) {
                max = Math.max(Math.max(sum1, sum2), max);
            }
        }

        System.out.println(max);
    }
//public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    int n = sc.nextInt();
//    int[] nums = new int[n];
//    int sum = 0;
//    for (int i = 0; i < n; i++) {
//        nums[i] = sc.nextInt();
//        sum += nums[i];
//    }
//    if (sum % 2 != 0) {
//        System.out.println(-1);
//        return;
//    }
//    int target = sum / 2;
//    int[][] dp = new int[n + 1][target + 1];
//    for (int i = 1; i <= n; i++) {
//        for (int j = 1; j <= target; j++) {
//            if (nums[i - 1] > j) {
//                dp[i][j] = dp[i - 1][j];
//            } else {
//                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
//            }
//        }
//    }
//    int res = dp[n][target];
//    if (res * 2 != sum) {
//        System.out.println(-1);
//        return;
//    }
//    System.out.println(sum - res);
//}
}