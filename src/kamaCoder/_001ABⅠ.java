package kamaCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhengjq3
 * @data 2024/8/1 16:00
 * <p>
 * 1. A+B问题I
 * 题目描述
 * 你的任务是计算a+b。
 * <p>
 * 输入描述
 * 输入包含一系列的a和b对，通过空格隔开。一对a和b占一行。
 * <p>
 * 输出描述
 * 对于输入的每对a和b，你需要依次输出a、b的和。
 * <p>
 * 如对于输入中的第二对a和b，在输出中它们的和应该也在第二行。
 * <p>
 * 输入示例
 * 3 4
 * 11 40
 * 输出示例
 * 7
 * 51
 */
public class _001ABⅠ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> results = new ArrayList<>();

        // 读取所有输入行
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {  // 跳过空行
                break;
            }
            String[] tokens = line.split("\\s+");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            results.add(a + b);
        }

        scanner.close();

        // 输出所有结果
        for (int result : results) {
            System.out.println(result);
        }
    }
}
