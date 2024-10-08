package kamaCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhengjq3
 * @data 2024/8/1 16:24
 * <p>
 * <p>
 * 4. A+B问题IV
 * 题目描述
 * 你的任务是计算若干整数的和。
 * <p>
 * 输入描述
 * 每行的第一个数N，表示本行后面有N个数。
 * <p>
 * 如果N=0时，表示输入结束，且这一行不要计算。
 * <p>
 * 输出描述
 * 对于每一行数据需要在相应的行输出和。
 * <p>
 * 输入示例
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 0
 * 输出示例
 * 10
 * 15
 */
public class _004ABⅣ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int sum = 0;
            while (n > 0) {
                sum += sc.nextInt();
                n--;
            }
            list.add(sum);
        }
        sc.close();
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
