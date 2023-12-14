package od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @ClassName _051tingchechang
 * @Description TODO 停车场最大距离
 * 题目描述
 * 停车场有一横排车位0代表没有停车,1代表有车.
 * 至少停了一辆车在车位上,也至少有一个空位没有停车.
 * 为防止刮蹭,需为停车人找到一个车位
 * 使得停车人的车最近的车辆的距离是最大的
 * 返回此时的最大距离
 *
 * 输入描述
 * 一个用半角逗号分割的停车标识字符串,停车标识为0或1,
 * 0为空位,1为已停车
 * 停车位最多有100个
 * 输出描述
 * 输出一个整数记录最大距离
 * 示例一
 * 输入
 * 1,0,0,0,0,1,0,0,1,0,1
 * 输出
 * 2
 * 说明
 * 当车停在第三个位置上时,离其最近的车距离为2(1~3)
 * 当车停在第四个位置上时,离其最近的车距离为2(4~6)
 * 其他位置距离为1
 * 因此最大距离为2
 * @Author 2+7
 * @Date 2023/3/13 09:47
 */
public class _051tingchechang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        List<Integer> list = Arrays.stream(s).map(x -> Integer.parseInt(x)).collect(Collectors.toList());
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)==1) {
                list1.add(i);
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(j) == 1) {
                        list1.add(j);
                        i=j+1;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < list1.size()-1; i++) {
            int temp = list1.get(i+1)-list1.get(i);
            if(temp>max){
                max = temp;
            }
        }
        int res = max/2;
        System.out.println(res);
    }
}