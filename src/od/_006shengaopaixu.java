package od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName _006shengaopaixu
 * @Description TODO 题目描述
 * 小明今年升学到了小学一年级，
 * 来到新班级后，发现其他小朋友身高参差不齐，
 * 然后就想基于各小朋友和自己的身高差，对他们进行排序，
 * 请帮他实现排序
 *
 * 输入描述
 * 第一行为正整数H和N
 * 0 < H < 200 为小明的身高
 * 0 < N < 50 为新班级其他小朋友个数
 * 第二行为N个正整数
 * H1 ~ Hn分别是其他小朋友的身高
 * 取值范围0 < Hi < 200
 * 且N个正整数各不相同
 *
 * 输出描述
 * 输出排序结果，各正整数以空格分割
 * 和小明身高差绝对值最小的小朋友排在前面
 * 和小明身高差绝对值最大的小朋友排在后面
 * 如果两个小朋友和小明身高差一样
 * 则个子较小的小朋友排在前面
 *
 * 示例一
 * 输入
 * 100 10
 * 95 96 97 98 99 101 102 103 104 105 5432112345
 * 输出
 * 99 101 98 102 97 103 96 104 95 105
 * @Author 2+7
 * @Date 2023/3/2 14:33
 */
public class _006shengaopaixu {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int h = scanner.nextInt();
            int n = scanner.nextInt();
            List<Integer> highs = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                highs.add(scanner.nextInt());
            }
            solution(h, highs);
        }
    }

    private static void solution(int h, List<Integer> highs) {
        highs.sort((h1, h2) -> {
            int diff1 = Math.abs(h1 - h);
            int diff2 = Math.abs(h2 - h);
            return diff1 == diff2 ? h1 - h2 : diff1 - diff2;
        });

        for (int i = 0; i < highs.size(); i++) {
            System.out.print(highs.get(i));
            if (i != highs.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}