package kamaCoder;

import java.util.Scanner;

/**
 * @author zhengjq3
 * @data 2024/8/6 17:09
 *
 *
 * 14. 句子缩写
 * 题目描述
 * 输出一个词组中每个单词的首字母的大写组合。
 * 输入描述
 * 输入的第一行是一个整数n，表示一共有n组测试数据。（输入只有一个n，没有多组n的输入）
 * 接下来有n行，每组测试数据占一行，每行有一个词组，每个词组由一个或多个单词组成；每组的单词个数不超过10个，每个单词有一个或多个大写或小写字母组成；
 * 单词长度不超过10，由一个或多个空格分隔这些单词。
 * 输出描述
 * 请为每组测试数据输出规定的缩写，每组输出占一行。
 * 输入示例
 * 1
 * ad dfa     fgs
 * 输出示例
 * ADF
 * 提示信息
 * 注意：单词之间可能有多个空格
 */
public class _014SentenceAbbr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入的行数
        int n = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < n; i++) {
            // 读取每组输入的词组
            String line = scanner.nextLine().trim();

            // 分割词组成单词
            String[] words = line.split("\\s+");

            StringBuilder abbreviation = new StringBuilder();
            for (String word : words) {
                if (!word.isEmpty()) {
                    abbreviation.append(Character.toUpperCase(word.charAt(0)));
                }
            }

            // 输出结果
            System.out.println(abbreviation.toString());
        }

        scanner.close();
    }
}
