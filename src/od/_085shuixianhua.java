package od;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName _085shuixianhua
 * @Description TODO 水仙花数2 !!!
 * 题目描述
 * 给定非空字符串s，将该字符串分割成一些子串
 * 使每个子串的ASCII码值的和均为水仙花数
 *
 * 若分割不成功则返回0
 * 若分割成功且分割结果不唯一 则返回-1
 * 若分割成功且分割结果唯一 则返回分割后子串的数目
 * 输入描述
 * 输入字符串的最大长度为200
 *
 * 输出描述
 * 根据题目描述中的情况返回响应结果
 *
 * 示例一
 * 输入
 * abc
 * 输出
 * 0
 * 说明
 * 分割不成功
 *
 * 示例二
 * 输入
 * f3@d5a8
 * 输出
 * -1
 * 说明
 * 分割成功但分割结果不唯一
 * 可以分割为两组
 * 一组 f3和@d5a8
 * 另一组 f3@d5和a8
 *
 * 说明
 * 分割不成功
 *
 * 示例三
 * 输入
 * AXdddF
 * 输出
 * 2
 * 说明
 * 成功分割且分割结果唯一
 * 可以分割为AX(153)、dddF(370)两个子串
 * @Author 2+7
 * @Date 2023/3/22 14:19
 */
public class _085shuixianhua {
    private static final LinkedList<Integer> resList = new LinkedList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        int count = 2;
        find(line, count);

        int res = 0;
        if (resList.size() > 1) {
            res = -1;
        } else if (resList.size() == 1) {
            res = resList.get(0);
        }

        System.out.println(res);
    }

    private static void find(String line, int count) {
        for (int i = 1; i < line.length(); i++) {
            String sub1 = line.substring(0, i);
            String sub2 = line.substring(i);
            if (isNarcissistic(asciiSum(sub1))) {
                if (isNarcissistic(asciiSum(sub2))) {
                    resList.add(count);
                } else {
                    find(sub2, count++);
                }
            }
        }
    }

    private static int asciiSum(String str) {
        int sum = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            sum += chars[i];
        }
        return sum;
    }
    private static boolean isNarcissistic(int n){
        if(n>100&&n<1000){
            int m = (int) (Math.pow(n % 10, 3) + Math.pow(n / 10 % 10, 3) + Math.pow(n / 100 % 10, 3));
            if(n==m){
                return true;
            }
        }
        return false;
    }
}