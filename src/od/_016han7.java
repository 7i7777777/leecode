package od;

import java.util.Scanner;

/**
 * @ClassName _016han7
 * @Description TODO 喊7，是一个传统的聚会游戏，
 * N个人围成一圈，按顺时针从1 - 7编号，
 * 编号为1的人从1开始喊数，
 * 下一个人喊得数字是上一个人喊得数字+1，
 * 但是当将要喊出数字7的倍数或者含有7的话，
 * 不能喊出，而是要喊过。
 *
 * 假定N个人都没有失误。
 * 当喊道数字k时，
 * 可以统计每个人喊“过"的次数。
 *
 * 现给定一个长度N的数组，
 * 存储打乱的每个人喊”过"的次数，
 * 请把它还原成正确顺序。
 *
 * 即数组的第i个元素存储编号i的人喊“过“的次数
 *
 * 输入描述
 * 输入为1行
 * 空格分割的喊过的次数，
 * 注意k并不提供，
 * k不超过200
 * 数字个数为N
 *
 * 输出描述
 * 输出为1行
 * 顺序正确的喊过的次数，空格分割
 *
 * 示例一
 * 输入
 * 0 1 0
 * 输出
 * 1 0 0
 * 说明
 * 只有1次过，发生在7，
 * 按顺序编号1的人遇到7，所以1 0 0，
 * 结束时的k不一定是7，也可以是 8 9，
 * 喊过都是1 0 0
 *
 * 示例二
 * 输入
 * 0 0 0 2 1
 * 输出
 * 0 2 0 1 0
 * @Author 2+7
 * @Date 2023/3/6 11:00
 */
public class _016han7 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] split = line.split(" ");
        int sum = 0;
        for (String s : split) {
            sum += Integer.parseInt(s);
        }

        int[] res = new int[split.length];

        int j = 0;
        for (int i = 1; i < 300; i++, j++) {
            if (j == split.length) j = 0;
            if (i % 7 == 0 || (i + "").contains("7")) {
                res[j] += 1;
            }
            int sum1 = 0;
            for (int re : res) sum1 += re;
            if (sum == sum1) break;
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if (i != res.length - 1) {
                System.out.print(" ");
            }
        }
    }
}