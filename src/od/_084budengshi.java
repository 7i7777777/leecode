package od;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName _084budengshi
 * @Description TODO 不等式 ???
 * 题目描述
 * 给定一组不等式，判断是否成立并输出不等式的最大差（输出浮点数的整数部分）
 * 要求：
 *
 * 不等式系数为double类型，是一个二维数组
 * 不等式的变量为int类型，是一维数组
 * 不等式的目标值为double类型，是一维数组
 * 不等式约束为字符串数组，只能是大于，大于等于，小于，小于等于，等于
 * 例如：不等式组：
 * a11*x1+a12*x2+a13*x3+a14*x4+a15*x5<=b1;
 * a21*x1+a22*x2+a23*x3+a24*x4+a25*x5<=b2;
 * a31*x1+a32*x2+a33*x3+a34*x4+a35*x5<=b3;
 *
 * 最大差 = max{
 *         (a11*x1+a12*x2+a13*x3+a14*x4+a15*x5-b1),
 *         (a21*x1+a22*x2+a23*x3+a24*x4+a25*x5-b2),
 *         (a31*x1+a32*x2+a33*x3+a34*x4+a35*x5-b3)
 *     },
 * 类型为整数(输出浮点数的整数部分)
 *
 * 输入描述
 * 不等式组系数（double类型）
 * a11,a12,a13,a14,a15
 * a21,a22,a23,a24,a25
 * a31,a32,a33,a34,a35
 * 不等式变量（int类型）
 * x1,x2,x3,x4,x5
 * 不等式目标值（double类型）
 * b1,b2,b3
 * 不等式约束（字符串类型）
 * <=,<=,<=
 * 输入:
 * a11,a12,a13,a14,a15;a21,a22,a23,a24,a25;a31,a32,a33,a34,a35;x1,x2,x3,x4,x5;b1,b2,b3;<=,<=,<=
 * 输出描述
 * true或者false,最大差
 *
 * 示例一
 * 输入
 * 2.3,3,5.6,7.6;11,3,8.6,25,1;0.3,9,5.3,66,7.8;1,3,2,7,5;340,670,80.6;<=,<=,<=
 * 输出
 * false 458
 * 示例二
 * 输入
 * 2.36,3,6,7.1,6;1,30,8.6,2.5,21;0.3,69,5.3,6.6,7.8;1,13,2,17,5;340,67,300.6;<=,>=,<=
 * 输出
 * false 758
 * @Author 2+7
 * @Date 2023/3/22 14:09
 */
public class _084budengshi {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] split1 = line.split(";");

        boolean right = true;
        List<Integer> list = new LinkedList<>();

        // 不等式约束（字符串类型）
        String[] limits = split1[split1.length - 1].split(",");
        // 不等式目标值（double类型）
        String[] aims = split1[split1.length - 2].split(",");
        // 不等式变量（int类型）
        String[] vars = split1[split1.length - 3].split(",");
        // 不等式组系数（double类型）
        for (int i = 0; i < limits.length; i++) {
            double value = 0;
            double aim = Double.parseDouble(aims[i]);
            // 系数
            String[] split = split1[i].split(",");
            for (int j = 0; j < split.length; j++) {
                value += Double.parseDouble(split[j]) * Integer.parseInt(vars[j]);
            }
            String limit = limits[i];
            int e = new Double(Math.abs(value - aim)).intValue();
            switch (limit) {
                case ">":
                    right = (value > aim) && right;
                    list.add(e);
                    break;
                case "<":
                    right = (value < aim) && right;
                    list.add(e);
                    break;
                case ">=":
                    right = (value >= aim) && right;
                    list.add(e);
                    break;
                case "<=":
                    right = (value <= aim) && right;
                    list.add(e);
                    break;
                default:
                    right = false;
            }
        }

        System.out.print(right + " ");
        System.out.println(list.stream().max(Integer::compareTo).get());
    }
}