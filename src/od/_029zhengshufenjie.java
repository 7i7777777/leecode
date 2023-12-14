package od;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName _029zhengshufenjie
 * @Description TODO 整数分解
 * 题目描述
 * 一个整数可以由连续的自然数之和来表示。
 * 给定一个整数，计算该整数有几种连续自然数之和的表达式，
 * 并打印出每一种表达式。
 * <p>
 * 输入描述
 * 一个目标整数t，1 <= t <= 1000
 * <p>
 * 输出描述
 * 该整数的所有表达式和表达式的个数
 * 如果有多种表达式，自然数个数最少的表达式优先输出
 * 每个表达式中按自然数递增输出
 * 具体的格式参见样例
 * 在每个测试数据结束时，输出一行Result:X
 * 其中X是最终的表达式个数
 * 示例一
 * 输入
 * 9
 * 输出
 * 9=9
 * 9=4+5
 * 9=2+3+4
 * Result:3
 * 说明
 * 整数9有三种表达方法
 * <p>
 * 示例二
 * 输入
 * 10
 * 输出
 * 10=10
 * 10=1+2+3+4
 * Result:2
 * @Author 2+7
 * @Date 2023/3/7 16:06
 */
public class _029zhengshufenjie {
    //滑动窗口 动态窗口
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cnt = 0;
        List<String> res = new ArrayList<>();
        for (int i = 1, j = 1, sum = 0; i <= t; i++) {
            while (sum < t && j <= t) {
                sum += j++;
            }
            if(sum==t){
                StringBuilder sb = new StringBuilder();
                for (int k = i; k < j; k++) {
                    sb.append(k).append("+");
                }
                sb.deleteCharAt(sb.length()-1);
                res.add(t+"="+sb);
                cnt++;
            }
            sum -= i;
        }
        res.sort((o1,o2)->{
            int len1 = o1.length();
            int len2 = o2.length();
            return len1 - len2;
        });
        for (String s : res) {
            System.out.println(s);
        }
        System.out.println("Result:"+cnt);
    }
}