package od;

import java.util.Scanner;

/**
 * @ClassName _093ludengzhaoming
 * @Description TODO 路灯照明
 * 题目描述
 * 在一条笔直的公路上安装了N个路灯，
 * 从位置0开始安装，路灯之间间距固定为100米
 * 每个路灯都有自己的照明半径
 * 请计算第一个路灯和最后一个路灯之间，
 * 无法照明的区间的长度和。
 * <p>
 * 输入描述
 * 第一行为一个数N，表示路灯个数，1 <= N <= 100000
 * 第二行为N个空格分割的数，表示路灯的照明半径，1 <= 照明半径
 * <p>
 * 输出描述
 * 无法照明的区间的长度和。
 * <p>
 * 示例一
 * 输入
 * 2
 * 50 50
 * 输出
 * 0
 * 说明
 * 路灯1覆盖0-50 路灯二覆盖50-100
 * 路灯1和路灯2 之间(0-100米)无未覆盖的区间
 * @Author 2+7
 * @Date 2023/3/28 16:52
 */
public class _093ludengzhaoming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = 0;
        int i = 0, j = 1;
        while (j < n) {
            if (arr[i] + arr[j] < 100) {
                res = 100 - arr[i] - arr[j];
            }
            i++;
            j++;
        }
        System.out.println(res);
    }
}