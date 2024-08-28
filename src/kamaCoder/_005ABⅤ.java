package kamaCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhengjq3
 * @data 2024/8/1 16:28
 * <p>
 * <p>
 * 5. A+B问题VII
 * 题目描述
 * 你的任务是计算两个整数的和。
 * 输入描述
 * 输入包含若干行，每行输入两个整数a和b，由空格分隔。
 * 输出描述
 * 对于每组输入，输出a和b的和，每行输出后接一个空行。
 * 输入示例
 * 2 4
 * 11 19
 * 输出示例
 * 6
 * <p>
 * 30
 */
public class _005ABⅤ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.trim().isEmpty()) {
                break;
            }
            int a = Integer.parseInt(s.split("\\s+")[0]);
            int b = Integer.parseInt(s.split("\\s+")[1]);
            list.add(a + b);
        }
        sc.close();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if (i != list.size() - 1) {
                System.out.println("*");
            }
        }

    }
}
