package od;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @ClassName _079kapianzushu
 * @Description TODO 卡片组成的最大数字 !!!!!!!!!!!!! 字符串排序
 * 题目描述
 * 小组中每位都有一张卡片
 * 卡片是6位以内的正整数
 * 将卡片连起来可以组成多种数字
 * 计算组成的最大数字
 * <p>
 * 输入描述
 * ,分割的多个正整数字符串
 * 不需要考虑非数字异常情况
 * 小组种最多25个人
 * <p>
 * 输出描述
 * 最大数字字符串
 * <p>
 * 示例一
 * 输入
 * 22,221
 * 输出
 * 22221
 * 示例二
 * 输入
 * 4589,101,41425,9999
 * 输出
 * 9999458941425101
 * @Author 2+7
 * @Date 2023/3/21 17:12
 */
public class _079kapianzushu {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String nums = scanner.nextLine();
            solution1(nums);
        }
    }

    private static void solution1(String nums) {
        String[] s = nums.split(",");
        Comparator<String> myComparator = (left, right) -> {
            String leftAndRight = left + right;
            String rightAdLeft = right + left;
            return rightAdLeft.compareTo(leftAndRight);
        };
        String res = Arrays.stream(s).sorted(myComparator).collect(Collectors.joining(""));
        System.out.println(res);
    }

    private static void solution(String nums) {
        StringBuilder builder = new StringBuilder();

        Arrays.stream(nums.split(","))
                .sorted((s1, s2) -> {
                    char[] v1 = s1.toCharArray();
                    char[] v2 = s2.toCharArray();
                    int len1 = v1.length;
                    int len2 = v2.length;

                    if (len1 == len2) {
                        return s2.compareTo(s1);
                    }

                    int min = Math.min(len1, len2);
                    for (int i = 0; i < min; i++) {
                        char c1 = v1[i];
                        char c2 = v2[i];
                        if (c1 != c2) {
                            return c2 - c1;
                        }
                    }

                    if (len1 > len2) {
                        return v1[0] - v1[min];
                    } else {
                        return v2[min] - v2[0];
                    }
                })
                .forEach(builder::append);

        System.out.print(builder);
    }
}