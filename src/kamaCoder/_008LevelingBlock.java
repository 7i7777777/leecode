package kamaCoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhengjq3
 * @data 2024/8/2 10:26
 * <p>
 * <p>
 * 8. 摆平积木
 * 题目描述
 * 小明很喜欢玩积木。一天，他把许多积木块组成了好多高度不同的堆，每一堆都是一个摞一个的形式。然而此时，他又想把这些积木堆变成高度相同的。但是他很懒，他想移动最少的积木块来实现这一目标，你能帮助他吗？
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 输入包含多组测试样例。每组测试样例包含一个正整数n，表示小明已经堆好的积木堆的个数。
 * 接着下一行是n个正整数，表示每一个积木堆的高度h，每块积木高度为1。其中1<=n<=50,1<=h<=100。
 * 测试数据保证积木总数能被积木堆数整除。
 * 当n=0时，输入结束。
 * 输出描述
 * 对于每一组数据，输出将积木堆变成相同高度需要移动的最少积木块的数量。
 * 在每组输出结果的下面都输出一个空行。
 * 输入示例
 * 6
 * 5 2 4 1 7 5
 * 0
 * 输出示例
 * 5
 */
public class _008LevelingBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> results = new ArrayList<>();

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            int[] heights = new int[n];
            int totalHeight = 0;

            for (int i = 0; i < n; i++) {
                heights[i] = sc.nextInt();
                totalHeight += heights[i];
            }

            int avgHeight = totalHeight / n;
            int moves = 0;

            for (int height : heights) {
                if (height > avgHeight) {
                    moves += height - avgHeight;
                }
            }

            results.add(moves);
        }

        sc.close();

        for (int result : results) {
            System.out.println(result);
            System.out.println(); // Add a blank line after each result
        }
    }
}
