package od;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @ClassName _071zuishaotingche
 * @Description TODO 最少停车数
 * 题目描述
 * 特定大小的停车场 数组cars表示
 * 其中1表示有车0表示没车
 * 车辆大小不一，小车占一个车位(长度1)
 * 货车占两个车位(长度2)
 * 卡车占三个车位(长度3)
 * 统计停车场最少可以停多少辆车
 * 返回具体的数目
 * <p>
 * 输入描述
 * 整型字符串数组cars
 * 其中1表示有车0表示没车
 * 数组长度 < 1000
 * <p>
 * 输出描述
 * 整型数字字符串
 * 表示最少停车数
 * <p>
 * 示例一
 * 输入
 * 1,0,1
 * 输出
 * 2
 * 说明
 * 一个小车占第一个车位
 * 第二个车位空，一个小车占第三个车位
 * 最少有两辆车
 * <p>
 * 示例二
 * 输入
 * 1,1,0,0,1,1,1,0,1
 * 输出
 * 3
 * 说明
 * 一个货车占第1,2个车位
 * 第3,4个车位空
 * 一个卡车占第5,6,7个车位
 * 第8个车位空
 * 一个小车占第9个车位
 * 最少3俩个车
 * @Author 2+7
 * @Date 2023/3/21 15:20
 */
public class _071zuishaotingche {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int num = 0;
        // 1,1,0,0,1,1,1,0,1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                num++;
                int j = i + 1;
                while (j - i < 3 && j < arr.length) {
                    if (arr[j] == 1 && j - i < 3) {
                        j++;
                    }else {
                        break;
                    }
                }
                i = j;
            }
        }
        System.out.println(num);
    }
}