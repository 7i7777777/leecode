package od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName _089baoshu
 * @Description TODO 报数
 * 题目描述
 * 一百个人围成一圈，每个人有一个编码编号从一开始到一百。
 * 他们从一开始依次报数，报道M的人自动退出圈圈，
 * 然后下一个人接着从1开始报数一直到剩余人数小于M。
 * 请问最后剩余人在原先的编码为多少？
 *
 * 输入描述
 * 输入一个整数参数M
 *
 * 输出描述
 * 如果输入参数M小于等于1或者大于等于100,输出ERROR!;
 * 否则按原先的编号从小到大的顺序，以英文逗号分割输出编号字符串
 *
 * 示例一
 * 输入
 * 3
 * 输出
 * 58,91
 * 示例二
 * 输入
 * 4
 * 输出
 * 34,45,97
 * @Author 2+7
 * @Date 2023/3/24 15:49
 */
public class _089baoshu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        if (m <= 1 || m >= 100) {
            System.out.println("ERROR!");
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > m - 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
}
// 1 2 3 4 5
// 1245
// 24