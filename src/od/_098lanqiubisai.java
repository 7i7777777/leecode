package od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName _098lanqiubisai
 * @Description TODO 篮球比赛 ???
 * 题目描述
 * 篮球（5v5）比赛中每个球员拥有一个战斗力，
 * 每个队伍的所有球员战斗力之和为该队伍的总体战斗力。
 * 现有十个球员准备分为两队进行训练赛，
 * 教练希望两个队伍的战斗力差能够尽可能的小，以达到最佳训练效果。
 * 给出十个球员的战斗力，如果你是教练，你该如何分队，才能达到最佳训练效果？
 * 请输出该分队方案下的最小战斗力差值。
 *
 * 输入描述
 * 十个篮球队员的战斗力（整数，范围[1，10000]），战斗力之间用空格分隔，
 * 如：10 9 8 7 6 5 4 3 2 1
 * 不需要考虑异常输入的场景
 *
 * 输出描述
 * 最小战斗力差值，
 * 如：1
 *
 * 示例一
 * 输入
 * 10 9 8 7 6 5 4 3 2 1
 * 输出
 * 1
 * 说明
 * 1 2 5 9 10 分为一队，3 4 6 7 8 分为一队，两队战斗力之差最小，输出差值1。
 *
 * 备注
 * 球员分队方案不唯一，但最小战斗力差值固定是1
 * @Author 2+7
 * @Date 2023/3/29 14:40
 */
public class _098lanqiubisai {
    public static void main(String[] args) {
        int[] players = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << 10); i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < 10; j++) {
                if ((i & (1 << j)) != 0) {
                    sum1 += players[j];
                } else {
                    sum2 += players[j];
                }
            }
            minDiff = Math.min(minDiff, Math.abs(sum1 - sum2));
        }
        System.out.println(minDiff);
    }
}