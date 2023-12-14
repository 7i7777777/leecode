package od;

import java.util.Scanner;

/**
 * @ClassName _072xiangtongzifuchuancishu
 * @Description TODO 相同字符连续出现的最大次数
 * 题目描述
 * 输入一串字符串
 * 字符串长度不超过100
 * 查找字符串中相同字符连续出现的最大次数
 * <p>
 * 输入描述
 * 输入只有一行，包含一个长度不超过100的字符串
 * <p>
 * 输出描述
 * 输出只有一行，输出相同字符串连续出现的最大次数
 * <p>
 * 示例一
 * 输入
 * hello
 * 输出
 * 2
 * 示例二
 * 输入
 * word
 * 输出
 * 1
 * 示例三
 * 输入
 * aaabbc
 * 输出
 * 3
 * @Author 2+7
 * @Date 2023/3/21 15:35
 */
public class _072xiangtongzifuchuancishu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int temp = 1;
            while (j < arr.length && arr[j] == arr[i]) {
                temp++;
                j++;
            }
            if (res < temp) {
                res = temp;
            }
        }
        System.out.println(res);
    }
}