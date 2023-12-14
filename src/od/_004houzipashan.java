package od;

import java.util.Scanner;

/**
 * @ClassName _004houzipashan
 * @Description TODO 题目描述
 * 一天一只顽猴想要从山脚爬到山顶，
 * 途中经过一个有n个台阶的阶梯，
 * 但是这个猴子有个习惯，每一次只跳1步或3步
 * 试问？猴子通过这个阶梯有多少种不同的跳跃方式
 *
 * 输入描述
 * 输入只有一个数n， 0 < n < 50
 * 代表此阶梯有多个台阶
 *
 * 输出描述
 * 有多少种跳跃方式
 *
 * 示例一
 * 输入
 * 50
 * 输出
 * 122106097
 * @Author 2+7
 * @Date 2023/3/1 14:18
 */
public class _004houzipashan {
// 时间复杂度O n
    private static int solution(int n) {
        int step1 = 1, step2 = 1, step3 = 2;
        int step4 = n == 1 || n == 2 ? 1 : 2;
        for (int i = 4; i <= n; i++) {
            step4 = step3 + step1;
            step1 = step2;
            step2 = step3;
            step3 = step4;
        }
        return step4;
    }
    //时间复杂度 O 2^n
//    private static int solution(int n){
//        if(n<3){
//            return 1;
//        }
//        return solution(n-1)+solution(n-3);
//    }

    private static long solution1(int n){
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int step = sc.nextInt();
        System.out.println(solution1(step));
    }
}