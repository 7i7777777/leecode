package od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName _012kuaidihuoche
 * @Description TODO 快递货车
 * 题目描述
 * 一辆运送快递的货车，
 * 运送的快递放在大小不等的长方体快递盒中，
 * 为了能够装载更多的快递同时不能让货车超载，
 * 需要计算最多能装多少个快递。
 * 注：快递的体积不受限制。
 * 快递数最多1000个，货车载重最大50000。
 *
 * 输入描述
 * 第一行输入每个快递的重量
 * 用英文逗号隔开
 * 如 5,10,2,11
 * 第二行输入货车的载重量
 * 如 20
 *
 * 输出描述
 * 输出最多能装多少个快递
 * 如 3
 *
 * 示例一
 * 输入
 * 5,10,2,11
 * 20
 * 输出
 * 3
 * @Author 2+7
 * @Date 2023/3/3 14:08
 */
public class _012kuaidihuoche {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int x = sc.nextInt();
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);
        solution(x,arr);
    }

    private static void solution(int x,int[] arr){
        int sum = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if(sum+arr[i]<=x){
                sum += arr[i];
                result++;
            }else{
                break;
            }
        }
        System.out.println(result);

    }
}