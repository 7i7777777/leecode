package od;

import java.util.Scanner;

/**
 * @ClassName _048fentangguo
 * @Description TODO 分糖果
 * 题目描述
 * 小明从糖果盒中随意抓一把糖果
 * 每次小明会取出一半的糖果分给同学们
 * 当糖果不能平均分配时
 * 小明可以从糖果盒中(假设盒中糖果足够)取出一个或放回一个糖果
 * 小明至少需要多少次(取出放回和平均分配均记一次)能将手中糖果分至只剩一颗
 *
 * 输入描述
 * 抓取糖果数(小于1000000)，例如15
 *
 * 输出描述
 * 最少分至一颗糖果的次数，例如5
 *
 * 示例一
 * 输入
 * 15
 * 输出
 * 5
 * 说明
 * 解释：
 *
 * 15+1=16
 * 16/2=8
 * 8/2=4
 * 4/2=2
 * 2/2=1
 * @Author 2+7
 * @Date 2023/3/11 10:16
 */
public class _048fentangguo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int count = 0;
        for (int i = x; i != 1; i /= 2, count++) {
            if (i == 3) {
                count += 2;
                break;
            }
            if (i % 2 != 0) {
                if ((i + 1) / 2 % 2 == 0) i++;
                else i--;
                count++;
            }
        }

        System.out.print(count);
    }
}