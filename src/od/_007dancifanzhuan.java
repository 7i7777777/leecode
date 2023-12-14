package od;

import java.util.Scanner;

/**
 * @ClassName _007dancifanzhuan
 * @Description TODO 题目描述
 * 输入一个英文文章片段，
 * 翻转指定区域的单词顺序，
 * 标点符号和普通字母一样处理，
 * 例如输入字符串
 * I am a developer.
 * [0,3]
 * 则输出
 * developer. a am I
 * <p>
 * 输入描述
 * 使用换行隔开3个参数
 * 第一个参数为文章内容 即英文字符串
 * 第二个参数为翻转起始单词下标，下标从0开始
 * 第三个参数为结束单词下标
 * <p>
 * 输出描述
 * 翻转后英文文章片段每个单词之间以一个半角空格分割输出
 * <p>
 * 示例一
 * 输入
 * I am a developer.
 * 0
 * 3
 * 输出
 * developer. a am I
 * 示例二
 * 输入
 * hello world!
 * 0
 * 3
 * 输出
 * world! hello
 * @Author 2+7
 * @Date 2023/3/2 16:18
 */
public class _007dancifanzhuan {

    private static void solution(int i, int j, String[] s1) {
        if (j >= s1.length) {
            int l = i, r = s1.length-1;
            wordReverse(s1, l, r);
        }else{
            int l = i, r = j;
            wordReverse(s1, l, r);
        }
    }

    private static void wordReverse(String[] s1, int l, int r) {
        while (l < r) {
            String temp = s1[l];
            s1[l++] = s1[r];
            s1[r--] = temp;
        }
        for (String s : s1) {
            System.out.print(s + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i = sc.nextInt();
        int j = sc.nextInt();
        String[] s1 = s.split(" ");
        solution(i, j, s1);
    }

}