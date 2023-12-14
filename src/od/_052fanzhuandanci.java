package od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName _052fanzhuandanci
 * @Description TODO 翻转单词顺序
 * 题目描述
 * 输入一个英文文章片段
 * 翻转指定区间的单词顺序，标点符号和普通字母一样处理
 * 例如输入字符串 I am a developer.
 * 区间[0,3]则输出 developer. a am I
 * <p>
 * 输入描述
 * 使用换行隔开三个参数
 * 第一个参数为英文文章内容即英文字符串
 * 第二个参数为反转起始单词下标，下标从0开始
 * 第三个参数为结束单词下标，
 * <p>
 * 输出描述
 * 反转后的英文文章片段，所有单词之间以一个半角空格分割进行输出
 * @Author 2+7
 * @Date 2023/3/14 14:32
 */
public class _052fanzhuandanci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int m = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        int i=m,j=n;
        while(i<j){
            String temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        for (int k = 0; k < s.length; k++) {
            System.out.print(s[k]);
            if(k!=s.length-1){
                System.out.print(" ");
            }
        }
    }
}