package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName _001_qishuiping
 * @Description TODO 汽水瓶
 * 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
 * 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
 * 数据范围：输入的正整数满足
 * 1
 * ≤
 * �
 * ≤
 * 100
 * <p>
 * 1≤n≤100
 * <p>
 * 注意：本题存在多组输入。输入的 0 表示输入结束，并不用输出结果。
 * 时间限制：C/C++ 1秒，其他语言2秒
 * 空间限制：C/C++ 32M，其他语言64M
 * 输入描述：
 * 输入文件最多包含 10 组测试数据，每个数据占一行，仅包含一个正整数 n（ 1<=n<=100 ），表示小张手上的空汽水瓶数。n=0 表示输入结束，你的程序不应当处理这一行。
 * <p>
 * 输出描述：
 * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
 * <p>
 * 示例1
 * 输入例子：
 * 3
 * 10
 * 81
 * 0
 * 输出例子：
 * 1
 * 5
 * 40
 * 输入例子：
 * 59
 * 94
 * 0
 * 输出例子：
 * 30
 * 49
 * 例子说明：
 * 样例 1 解释：用三个空瓶换一瓶汽水，剩一个空瓶无法继续交换
 * 样例 2 解释：用九个空瓶换三瓶汽水，剩四个空瓶再用三个空瓶换一瓶汽水，剩两个空瓶，向老板借一个空瓶再用三个空瓶换一瓶汽水喝完得一个空瓶还给老板
 * @Author 2+7
 * @Date 2023/3/14 15:35
 */
public class _001_qishuiping {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List<Integer> list = new ArrayList<>();
//        int num;
//        while ((num = sc.nextInt()) != 0) {
//            list.add(num);
//        }
//        for (Integer num1 : list) {
//            // 3 10 81
//            int res = num1 / 3; // 汽水数 27
//            int n1 = num1 / 3 + num1 % 3;  // 空瓶数 27
//            while (n1 >= 3) {
//                n1 = n1 / 3; // 9
//                res += n1; //36
//                n1 += n1 % 3; //剩余空瓶数
//            }
//            if (n1 == 2) {
//                res++;
//            }
//            System.out.println(res);
//        }
//    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
        int n = sc.nextInt();
        if (n == 0) {
            break;
        }
        int count = 0;
        while (n >= 3) {
            count += n / 3;
            n = n / 3 + n % 3;
        }
        if (n == 2) {
            count++;
        }
        System.out.println(count);
    }
}
}