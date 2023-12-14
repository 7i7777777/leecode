package od;

import java.util.Scanner;

/**
 * @ClassName _066jiaohuanzifu
 * @Description TODO 交换字符
 * 题目描述
 * 给定一个字符串S
 * 变化规则:
 * 交换字符串中任意两个不同位置的字符M
 * S都是小写字符组成
 * 1 <= S.length <= 1000
 *
 * 输入描述
 * 一串小写字母组成的字符串
 *
 * 输出描述
 * 按照要求变换得到最小字符串
 *
 * 示例一
 * 输入
 * abcdef
 * 输出
 * abcdef
 * 示例二
 * 输入
 * bcdefa
 * 输出
 * acdefb
 * @Author 2+7
 * @Date 2023/3/21 11:10
 */
public class _066jiaohuanzifu {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        char[] chars = line.toCharArray();
        char tmp = chars[0];
        int pos = 0;
        for (int i = 1; i < chars.length; i++) {
            char cur = chars[i];
            if (cur <= tmp) {
                tmp = cur;
                pos = i;
            }
        }

        if (pos != 0) {
            chars[pos] = chars[0];
            chars[0] = tmp;
        }

        System.out.print(new String(chars));

    }
}