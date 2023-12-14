package od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName _043heguishuzu
 * @Description TODO 题目描述
 * 给定一个正整数数组
 * 检查数组中是否存在满足规则的数组组合
 * 规则：
 * A = B + 2C
 * <p>
 * 输入描述
 * 第一行输出数组的元素个数
 * 接下来一行输出所有数组元素，用空格隔开
 * <p>
 * 输出描述
 * 如果存在满足要求的数
 * 在同一行里依次输出规则里A B C的取值，用空格隔开
 * 如果不存在输出0
 * <p>
 * 示例一
 * 输入
 * 4
 * 2 7 3 0
 * 输出
 * 7 3 2
 * 说明
 * 7 = 3 + 2 * 2
 * <p>
 * 示例一
 * 输入
 * 3
 * 1 1 1
 * 输出
 * 0
 * 说明
 * 说明找不到满足条件的组合
 * <p>
 * 备注
 * 数组长度在3 ~ 100之间
 * 数组成员为0 ~ 65535
 * 数组成员可以重复
 * 但每个成员只能在结果算式中使用一次
 * 如 数组成员为 [0,0,1,5]
 * 0出现两次允许，但结果0=0+2*0不允许 因为算式中使用了3个0
 * 用例保证每组数字里最多只有一组符合要求的解
 * @Author 2+7
 * @Date 2023/3/9 14:49
 */
public class _043heguishuzu {

    //while循环
    private static void solution1(Integer[] arr) {
        int i = 0, j = 1, k = arr.length - 1;
        while (i < j && j < k) {
            int a = arr[i];
            int b = arr[j];
            int c = arr[k];
            if (a == b + 2 * c) {
                System.out.println(a + " " + b + " " + c);
                return;
            }else if(a<b+2*c){
                j++;
            }else{
                k--;
            }
        }
    }

    // for循环
    private static void solution(Integer[] arr) {
        boolean flag = true;
        boolean res = true;
        for (int i = 0; i < arr.length; i++) {
            if (!res) {
                break;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (!flag) {
                    break;
                }
                for (int k = arr.length - 1; k > j; k--) {
                    int a = arr[i];
                    int b2c = arr[j] + arr[k] * 2;
                    if (a == b2c) {
                        flag = false;
                        res = false;
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                        break;
                    } else if (a < b2c) {
                        break;
                    } else {
                        flag = false;
                    }
                }
            }
        }
        if (res) {
            System.out.println(0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        Integer[] arr = new Integer[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, (o1, o2) -> o2 - o1);
        solution1(arr);


    }
}