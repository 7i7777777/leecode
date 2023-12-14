package od;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @ClassName _044huoxingwenjisuan
 * @Description TODO 火星文计算
 * 题目描述
 * 已经火星人使用的运算符号为# $
 * 其与地球人的等价公式如下
 * x#y=2*x+3*y+4
 * x$y=3*x+y+2
 * x y是无符号整数
 * 地球人公式按照c语言规则进行计算
 * 火星人公式中$符优先级高于#相同的运算符按从左到右的顺序运算
 * <p>
 * 输入描述
 * 火星人字符串表达式结尾不带回车换行
 * 输入的字符串说明是 字符串为仅有无符号整数和操作符组成的计算表达式
 * <p>
 * 用例保证字符串中操作数与操作符之间没有任何分隔符
 * 用例保证操作数取值范围为32位无符号整数，
 * 保证输入以及计算结果不会出现整型溢出
 * 保证输入的字符串为合法的求值报文
 * 例如: 123#4$5#76$78
 * 保证不会出现非法的求值报文
 * 例如:
 * #4$5 这种缺少操作数
 * 4$5# 这种缺少操作数
 * 4#$5 这种缺少操作数
 * 4 $5 有空格
 * 3+4-5*6/7 有其他操作符
 * 12345678987654321$54321 32位整数溢出
 * 输出描述
 * 根据火星人字符串输出计算结果
 * 结尾不带回车换行
 * <p>
 * 示例一
 * 输入
 * 7#6$5#12
 * 输出
 * 226
 * 说明
 * 示例
 * <p>
 * 7#6$5#12=7#(3*6+5+2)#12
 * =7#25#12
 * =(2*7+3*25+4)#12
 * =93#12
 * =2*93+3*12+4
 * =226
 * @Author 2+7
 * @Date 2023/3/10 14:33
 */
public class _044huoxingwenjisuan {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        List<String> operators = Arrays.stream(line.split("\\w+")).filter(x -> !x.isEmpty()).collect(Collectors.toList());
        List<Integer> nums = Arrays.stream(line.split("\\W+")).map(x -> Integer.parseInt(x)).collect(Collectors.toList());
        int pos$ = operators.indexOf("$");
        while (pos$ != -1) {
            int x = nums.get(pos$);
            int y = nums.get(pos$+1);
            int dollar = dollar(x, y);
            nums.set(pos$,dollar);
            nums.remove(pos$+1);
            operators.remove(pos$);
            pos$ = operators.indexOf("$");
        }
        int res = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            res = sharp(res, nums.get(i));
        }
        System.out.print(res);
    }

    public static int dollar(int x, int y) {
        return 3 * x + y + 2;
    }

    public static int sharp(int x, int y) {
        return 2 * x + 3 * y + 4;
    }
}