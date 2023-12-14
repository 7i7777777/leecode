package random.Feb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName test03122
 * @Description TODO 最多组合直角三角形个数
 * 题目描述
 *
 * 有N条线段，长度分别为a[1]-a[n]。现要求计算这N条线段最多可以组合成几个直角三角形，每条线段只能使用一次，每个三角形包含三条线段。
 *
 * 输入描述
 *
 * 第一行为整数N，表示线段的个数，1 <= N <= 10^5。
 * 第2至N+1行为N条线段的长度，a[i]（1 <= a[i] <= 10^9）
 *
 * 输出描述
 *
 * 输出最多可以组合成的直角三角形的数量。
 *
 * 示例
 *
 * 输入
 *
 * 1
 * 7 3 4 5 6 5 12 13
 *
 * 输出
 *
 * 2
 *
 * 输入
 *
 * 2
 * 7 3 4 5 6 5 12 13
 * 7 3 4 5 6 6 12 13
 *
 * 输出
 *
 * 2
 * 1
 * 7 3 4 5 6 5 12 13
 * 7 3 4 5 6 6 12 13
 * @Author 2+7
 * @Date 2023/3/12 17:13
 */
public class test03122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int t = 0; t < m; t++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    for (int k = j + 1; k < arr.length; k++) {
                        int a = arr[i];
                        int b = arr[j];
                        int c = arr[k];
                        if (a + b > c && a != b && a != c && b != c) {
                            if (a * a + b * b == c * c) {
                                count++;
                                arr[i] = 0;
                                arr[j] = 0;
                                arr[k] = 0;
                                i += 3;
                                Arrays.sort(arr);
                                // 3 4 5 5 6 12 13   5 6 10 12 13
                            } else if (a * a + b * b < c * c) {
                                j++;
                                k++;
                            } else {
                                k++;
                            }
                        }
                    }
                }
            }
            list.add(count);
        }
        list.forEach(x -> System.out.println(x));
        sc.close();
    }
}