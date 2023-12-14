package od;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @ClassName _104zuidapailie
 * @Description TODO 最大排列
 * 题目描述
 * 给定一组整数，重排序后输出一个最大的整数
 *
 * 输入描述
 * 数字组合
 *
 * 输出描述
 * 最大的整数
 *
 * 示例一
 * 输入
 * 10 9
 * 输出
 * 910
 * @Author 2+7
 * @Date 2023/3/30 15:30
 */
public class _104zuidapailie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
//        Arrays.stream(s.split(" ")).sorted((s1, s2) -> {
//            char[] c1 = s1.toCharArray();
//            char[] c2 = s2.toCharArray();
//            int len1 = c1.length;
//            int len2 = c2.length;
//            if (len1 == len2) {
//                return s2.compareTo(s1);
//            }
//            int min = Math.min(len1,len2);
//            for (int i = 0; i < min; i++) {
//                if(c1[i]!=c2[i]){
//                    return c2[i] - c1[i];
//                }
//            }
//            if(len1>len2){
//                return c1[0] - c1[min];
//            } else {
//                return c2[min] - c2[0];
//            }
//        }).forEach(sb::append);
//        System.out.println(sb);
        Arrays.stream(s.split(" ")).sorted((s1,s2) -> {
            String leftAndRight = s1+s2;
            String rightAndLeft = s2+s1;
            return rightAndLeft.compareTo(leftAndRight);
//            return leftAndRight.compareTo(rightAndLeft);
        }).forEach(sb::append);
        System.out.println(sb);
    }
}