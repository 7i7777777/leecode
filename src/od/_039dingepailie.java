package od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @ClassName _039dingepailie
 * @Description TODO 第N个排列
 * 题目描述
 * 给定参数n
 * 从1到n会有n个整数 1，2，3，...n
 * 这n个数字共有n!种排列 按大小顺序升序列出所有排列情况
 * 并一一标记
 * 当n = 3 时，所有排列如下
 * "123","132","213","231","312","321"
 * 给定n和k返回第n个排列
 *
 * 输入描述
 * 第一行为n
 * 第二行为k
 * n的范围是 1 ~ 9
 * k的范围是 1 ~ n!
 *
 * 输出描述
 * 输出排列第k位置的数字
 *
 * 示例一
 * 输入
 * 3
 * 3
 * 输出
 * 213
 * 示例二
 * 输入
 * 2
 * 2
 * 输出
 * 21
 * @Author 2+7
 * @Date 2023/3/9 09:56
 */
public class _039dingepailie {

    static TreeSet<String> set = new TreeSet<>();

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            solution(n, k);
        }

    }

    private static void solution(int n, int k) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        perm(arr, 0, n - 1);
        String res = new ArrayList<>(set).get(k - 1);
        System.out.println(res);
    }

    public static void perm(Integer[] array, int start, int end) {

        if (start == end) {
            String num = Arrays.toString(array).replaceAll("\\W+", "");
            set.add(num);
        } else {
            for (int i = start; i <= end; i++) { //0,2
                swap(array, start, i);//{1,2} 0,0
                perm(array, start + 1, end);
                swap(array, start, i);
            }
        }
    }

    public static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}