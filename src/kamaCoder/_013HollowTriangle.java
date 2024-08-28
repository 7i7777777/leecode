package kamaCoder;

import java.util.*;

/**
 * @author zhengjq3
 * @data 2024/8/3 18:00
 *
 *
 * 13. 镂空三角形???
 * 题目描述
 * 把一个字符三角形掏空，就能节省材料成本，减轻重量，但关键是为了追求另一种视觉效果。在设计的过程中，需要给出各种花纹的材料和大小尺寸的三角形样板，通过电脑临时做出来，以便看看效果。
 * 输入描述
 * 每行包含一个字符和一个整数n(0<n<41)，不同的字符表示不同的花纹，整数n表示等腰三角形的高。显然其底边长为2n-1。如果遇到@字符，则表示所做出来的样板三角形已经够了。
 * 输出描述
 * 每个样板三角形之间应空上一行，三角形的中间为空。行末没有多余的空格。每条结果后需要再多输出一个空行。
 * 输入示例
 * X 2
 * A 7
 * @
 * 输出示例
 *  X
 * XXX
 *
 *       A
 *      A A
 *     A   A
 *    A     A
 *   A       A
 *  A         A
 * AAAAAAAAAAAAA
 */
public class _013HollowTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while (true) {
            String s = sc.nextLine().trim();
            if (s.equals("@")) {
                break;
            }
            inputs.add(s);
        }
        sc.close();

        for (String input : inputs) {
            String[] parts = input.split(" ");
            char pattern = parts[0].charAt(0);
            int n = Integer.parseInt(parts[1]);
            printHollowTriangle(pattern, n);
            System.out.println(); // Print a blank line after each triangle
        }
    }

    private static void printHollowTriangle(char pattern, int n) {
        if (n == 1) {
            System.out.println(pattern);
            return;
        }

        // Print top part
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            System.out.print(pattern);
            if (i > 1) {
                for (int j = 0; j < 2 * i - 3; j++) {
                    System.out.print(" ");
                }
                System.out.print(pattern);
            }
            System.out.println();
        }

        // Print bottom part
        for (int i = 0; i < 2 * n - 1; i++) {
            System.out.print(pattern);
        }
        System.out.println();
    }
}