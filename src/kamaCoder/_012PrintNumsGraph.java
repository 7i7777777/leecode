package kamaCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhengjq3
 * @data 2024/8/2 14:40
 *
 *
 * 12. 打印数字图形???
 * 题目描述
 * 先要求你从键盘输入一个整数n（1<=n<=9），打印出指定的数字图形。
 * 输入描述
 * 输入包含多组测试数据。每组输入一个整数n（1<=n<=9）。
 * 输出描述
 * 对于每组输入，输出指定的数字图形。
 * 注意：每行最后一个数字后没有任何字符。
 * 输入示例
 * 5
 * 输出示例
 *     1
 *    121
 *   12321
 *  1234321
 * 123454321
 *  1234321
 *   12321
 *    121
 *     1
 */
public class _012PrintNumsGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> inputs = new ArrayList<>();

        // Read inputs until the end of input
        while (true) {
            String s = sc.nextLine().trim();
            if(s.isEmpty()){
                break;
            }
            int n = Integer.parseInt(s);
            if (n >= 1 && n <= 9) {
                inputs.add(n);
            }
        }
        sc.close();

        // Process each input
        for (int n : inputs) {
            printPattern(n);
            System.out.println(); // Separate different patterns with a blank line
        }
    }

    private static void printPattern(int n) {
        // Print upper part
        for (int i = 1; i <= n; i++) {
            printLine(i, n);
        }
        // Print lower part
        for (int i = n - 1; i >= 1; i--) {
            printLine(i, n);
        }
    }

    private static void printLine(int lineNumber, int totalLines) {
        int spaces = totalLines - lineNumber;
        // Print leading spaces
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        // Print ascending part
        for (int i = 1; i <= lineNumber; i++) {
            System.out.print(i);
        }
        // Print descending part
        for (int i = lineNumber - 1; i >= 1; i--) {
            System.out.print(i);
        }
        System.out.println();
    }
}
