package od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName _035liushuixian
 * @Description TODO 流水线
 * 题目描述
 * 一个工厂有m条流水线
 * 来并行完成n个独立的作业
 * 该工厂设置了一个调度系统
 * 在安排作业时，总是优先执行处理时间最短的作业
 * 现给定流水线个数m
 * 需要完成的作业数n
 * 每个作业的处理时间分别为 t1,t2...tn
 * 请你编程计算处理完所有作业的耗时为多少
 * 当n > m时 首先处理时间短的m个作业进入流水线
 * 其他的等待
 * 当某个作业完成时，
 * 依次从剩余作业中取处理时间最短的
 * 进入处理
 *
 * 输入描述
 * 第一行为两个整数(采取空格分隔)
 * 分别表示流水线个数m和作业数n
 * 第二行输入n个整数(采取空格分隔)
 * 表示每个作业的处理时长 t1,t2...tn
 * 0 < m, n< 100
 * 0 < t1,t2...tn < 100
 *
 * 输出描述
 * 输出处理完所有作业的总时长
 *
 * 示例一
 * 输入
 * 3 5
 * 8 4 3 2 10
 * 输出
 * 13
 * ¶说明
 * 先安排时间为2,3,4的三个作业
 * 第一条流水线先完成作业
 * 调度剩余时间最短的作业8
 * 第二条流水线完成作业
 * 调度剩余时间最短的作业10
 * 总共耗时 就是二条流水线完成作业时间13(3+10)
 * @Author 2+7
 * @Date 2023/3/8 13:55
 */
public class _035liushuixian {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            if(i+m<n){
                res[i] = arr[i] + arr[i+m];
            }else{
                res[i] = arr[i];
            }
        }
        Arrays.sort(res);
        System.out.println(res[res.length-1]);
    }
}