package kamaCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhengjq3
 * @data 2024/8/2 11:14
 *
 *
 * 9. 奇怪的信
 * 题目描述
 * 有一天, 小明收到一张奇怪的信, 信上要小明计算出给定数各个位上数字为偶数的和。
 * 例如：5548，结果为12，等于 4 + 8 。
 * 小明很苦恼，想请你帮忙解决这个问题。
 * 输入描述
 * 输入数据有多组。每组占一行，只有一个整整数，保证数字在32位整型范围内。
 * 输出描述
 * 对于每组输入数据，输出一行，每组数据下方有一个空行。
 * 输入示例
 * 415326
 * 3262
 * 输出示例
 * 12
 *
 * 10
 */
public class _009StrangeLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextLine()){
            String line = sc.nextLine().trim();
            if(line.isEmpty()){
                break;
            }
            String[] nums = line.split("");
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if(Integer.parseInt(nums[i])%2==0){
                    sum += Integer.parseInt(nums[i]);
                }
            }
            list.add(sum);
        }
        sc.close();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if(i!=list.size()-1){
                System.out.println("*");
            }
        }
    }
}
