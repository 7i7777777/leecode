package od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName _034nenglizudui
 * @Description TODO 能力组队
 * 题目描述
 * 用数组代表每个人的能力，
 * 一个比赛活动要求，参赛团队的最低能力值为N
 * 每个团队可以由一人或者两人组成，
 * 且一个人只能参加一个团队，
 * 计算出最多可以派出多少只符合要求的队伍。
 *
 * 输入描述
 * 第一行代表总人数，范围1 ~ 500000
 * 第二行数组代表每个人的能力
 * 数组大小范围1 ~ 500000
 * 元素取值范围1 ~ 500000
 * 第三行数值为团队要求的最低能力值1 ~ 500000
 *
 * 输出描述
 * 最多可以派出的团队数量
 *
 * 示例一
 * 输入
 * 5
 * 3 1 5 7 9
 * 8
 * 输出
 * 3
 * 说明
 * 3、5组成一队
 * 1、7一队
 * 9自己一队
 * 输出3
 *
 * 示例二
 * 输入
 * 7
 * 3 1 5 7 9 2 6
 * 8
 * 输出
 * 4
 * @Author 2+7
 * @Date 2023/3/7 17:27
 */
public class _034nenglizudui {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();

        int[] res = Arrays.stream(arr).filter(x->x<n).sorted().toArray();
        int count = arr.length-res.length;
        int i=0;
        int j=res.length-1;
        while (i<j){
            if(res[i]+res[j]>=n){
                count++;
                i++;
                j--;
            }else{
                i++;
            }
        }
        System.out.println(count);
    }
}