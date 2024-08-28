package kamaCoder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhengjq3
 * @data 2024/8/7 10:57
 * <p>
 * <p>
 * 17. 出栈合法性
 * 题目描述
 * 已知自然数1，2，...，N（1<=N<=100）依次入栈，请问序列C1，C2，...，CN是否为合法的出栈序列。
 * 输入描述
 * 输入包含多组测试数据。
 * 每组测试数据的第一行为整数N（1<=N<=100），当N=0时，输入结束。
 * 第二行为N个正整数，以空格隔开，为出栈序列。
 * 输出描述
 * 对于每组输入，输出结果为一行字符串。
 * 如给出的序列是合法的出栈序列，则输出Yes，否则输出No。
 * 输入示例
 * 5
 * 3 4 2 1 5
 * 5
 * 3 5 1 4 2
 * 0
 * 输出示例
 * Yes
 * No
 */
public class _017StackLegal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break; // 输入0表示结束

            int[] sequence = new int[n];
            for (int i = 0; i < n; i++) {
                sequence[i] = sc.nextInt();
            }

            if (isLegalSequence(n, sequence)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean isLegalSequence(int n, int[] sequence) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for (int i = 1; i <= n; i++) {
            stack.push(i);

            while (!stack.isEmpty() && stack.peek() == sequence[index]) {
                stack.pop();
                index++;
            }
        }

        return stack.isEmpty();
    }
}
