package od;

import java.util.Scanner;

/**
 * @ClassName _064huitujiqi
 * @Description TODO 绘图机器
 * 题目描述
 * 绘图机器的绘图笔初始位置在原点(0,0)
 * 机器启动后按照以下规则来进行绘制直线
 * <p>
 * 尝试沿着横线坐标正向绘制直线
 * 直到给定的终点E
 * 期间可以通过指令在纵坐标轴方向进行偏移
 * offsetY为正数表示正向偏移,为负数表示负向偏移
 * 给定的横坐标终点值E 以及若干条绘制指令
 * 请计算绘制的直线和横坐标轴以及x = E的直线组成的图形面积
 * 输入描述
 * 首行为两个整数N 和 E
 * 表示有N条指令,机器运行的横坐标终点值E
 * 接下来N行 每行两个整数表示一条绘制指令x offsetY
 * 用例保证横坐标x以递增排序的方式出现
 * 且不会出现相同横坐标x
 * 取值范围:
 * 0 < N <= 10000
 * 0 <= x <= E <= 20000
 * -10000 <= offsetY <= 10000
 * <p>
 * 输出描述
 * 一个整数表示计算得到的面积 用例保证结果范围在0到4294967295之内
 * <p>
 * 示例一
 * 输入
 * 4 10
 * 1 1
 * 2 1
 * 3 1
 * 4 -2
 * 输出
 * 12
 * 示例二
 * 输入
 * 2 4
 * 0 1
 * 2 -2
 * 输出
 * 4
 * @Author 2+7
 * @Date 2023/3/21 10:20
 */
public class _064huitujiqi {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int e = scanner.nextInt();
            int[][] ints = new int[n][2];
            for (int i = 0; i < n; i++) {
                ints[i][0] = scanner.nextInt();
                ints[i][1] = scanner.nextInt();
            }
            solution(n, e, ints);
        }


    }

    private static void solution(int n, int e, int[][] ints) {
        int curX = 0;
        int curY = 0;

        int area = 0;

        for (int i = 0; i < n; i++) {
            int x = ints[i][0];
            int y = ints[i][1];

            area += (x - curX) * Math.abs(curY);

            curX = x;
            curY += y;
        }
        if (curX < e) {
            area += (e - curX) * Math.abs(curY);
        }

        System.out.print(area);

    }
}