package kamaCoder;

import java.util.Scanner;

/**
 * @author zhengjq3
 * @data 2024/8/6 17:24
 *
 *
 * 15. 神秘字符
 * 题目描述
 * 考古学家发现墓碑上有神秘的字符。经过仔细研究，发现原来这是开启古墓入口的方法。
 * 墓碑上有2行字符串，其中第一个串的长度为偶数，现在要求把第2个串插入到第一个串的正中央，如此便能开启墓碑进入墓中。
 * 输入描述
 * 输入数据首先给出一个整数n，表示测试数据的组数。（整个输入中，只有一个n）
 * 然后是n组数据，每组数据2行，每行一个字符串，长度大于0，小于50，并且第一个串的长度必为偶数。
 * 输出描述
 * 请为每组数据输出一个能开启古墓的字符串，每组输出占一行。
 * 输入示例
 * 2
 * asdf
 * yu
 * rtyu
 * HJK
 * 输出示例
 * asyudf
 * rtHJKyu
 */
public class _015CrypticChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine().trim();
            String s2 = sc.nextLine().trim();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s1.length()/2; j++) {
                sb.append(s1.charAt(j));
            }
            sb.append(s2);
            for (int j = s1.length()/2; j < s1.length(); j++) {
                sb.append(s1.charAt(j));
            }
            System.out.println(sb);
        }
    }
}
