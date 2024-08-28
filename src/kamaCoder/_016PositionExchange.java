package kamaCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhengjq3
 * @data 2024/8/7 10:29
 * <p>
 * <p>
 * 16. 位置互换
 * 题目描述
 * 给定一个长度为偶数位的字符串，请编程实现字符串的奇偶位互换。
 * 输入描述
 * 输入包含多组测试数据。
 * 输入的第一行是一个整数n，表示有测试数据。（整个输入中，只有一个n）
 * 接下来是n组测试数据，保证串长为偶数位(串长<=50)。
 * 输出描述
 * 请为每组测试数据输出奇偶位互换后的结果，每组输出占一行。
 * 输入示例
 * 2
 * 0aa0
 * bb00
 * 输出示例
 * a00a
 * bb00
 */
public class _016PositionExchange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (j % 2 == 1) {
                    continue;
                }
                int k = j + 1;
                sb.append(s.charAt(k));
                sb.append(s.charAt(j));
            }
            list.add(sb.toString());
        }
        sc.close();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
