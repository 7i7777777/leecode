package od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @ClassName _056yuangongchuqin
 * @Description TODO 员工出勤
 * 题目描述
 * 公司用一个字符串来标识员工的出勤信息
 * absent: 缺勤
 * late: 迟到
 * leaveearly:早退
 * present: 正常上班
 * 现需根据员工出勤信息,判断本次是否能获得出勤奖,
 * 能获得出勤奖的条件如下：
 *
 * 缺勤不超过1次
 * 没有连续的迟到/早退
 * 任意连续7次考勤，缺勤/迟到/早退，不超过3次
 * 输入描述
 * 用户的考勤数据字符串记录条数 >= 1
 * 输入字符串长度 < 10000 ;
 * 不存在非法输入
 * 如：
 * 2
 * present
 * present absent present present leaveearly present absent
 *
 * 输出描述
 * 根据考勤数据字符串
 * 如果能得到考勤奖输出true否则输出false
 * 对于输出示例的结果应为
 * true false
 *
 * 示例一
 * 输入
 * 2
 * present
 * present present
 * 输出
 * true true
 * 示例二
 * 输入
 * 2
 * present
 * present absent present present leaveearly present absent
 * 输出
 * true false
 * @Author 2+7
 * @Date 2023/3/15 17:01
 */
public class _056yuangongchuqin {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = Integer.parseInt(scanner.nextLine());
            List<List<String>> days = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] split = scanner.nextLine().split(" ");
                List<String> list = Arrays.stream(split)
                        .collect(Collectors.toList());
                days.add(list);
            }
            solution(days);
        }


    }

    private static void solution(List<List<String>> days) {


        StringBuilder builder = new StringBuilder();

        for (List<String> day : days) {

            //1.缺勤超过1次
            long absent = day.stream()
                    .filter(x -> x.equals("absent"))
                    .count();
            if (absent > 1) {
                builder.append("false").append(" ");
                continue;
            }


            //2.没有连续的迟到/早退
            boolean flag = true;
            for (int i = 0; i < day.size() - 1; i++) {
                String cur = day.get(i);
                String next = day.get(i + 1);
                if (("late".equals(cur) ||
                        "leaveearly".equals(cur)) &&
                        ("late".equals(next) ||
                                "leaveearly".equals(next))) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                builder.append(flag).append(" ");
                continue;
            }


            //3.任意连续7次考勤 缺勤/迟到/早退 不超过3次
            int[] ints = new int[day.size()];
            for (int i = 0; i < day.size(); i++) {
                ints[i] = "present".equals(day.get(i)) ? 0 : 1;
            }
            if (ints.length <= 7 && Arrays.stream(ints).sum() >= 3) {
                builder.append("false").append(" ");
            } else {
                flag = true;
                for (int i = 0; i < ints.length - 7; i++) {
                    int[] subArr = Arrays.copyOfRange(ints, i, i + 7);
                    if (Arrays.stream(subArr).sum() >= 3) {
                        flag = false;
                        break;
                    }
                }
                builder.append(flag).append(" ");
            }
        }

        System.out.print(builder.substring(0, builder.length() - 1));
    }

}