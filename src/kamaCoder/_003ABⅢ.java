package kamaCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhengjq3
 * @data 2024/8/1 16:22
 * <p>
 * <p>
 * 3. A+B问题III
 * 题目描述
 * 你的任务依然是计算a+b。
 * <p>
 * 输入描述
 * 输入中每行是一对a和b。其中会有一对是0和0标志着输入结束，且这一对不要计算。
 * <p>
 * 输出描述
 * 对于输入的每对a和b，你需要在相应的行输出a、b的和。
 * 如第二对a和b，他们的和也输出在第二行。
 * 输入示例
 * 2 4
 * 11 19
 * 0 0
 * 输出示例
 * 6
 * 30
 */
public class _003ABⅢ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            list.add(a+b);
        }
        sc.close();
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
