package kamaCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhengjq3
 * @data 2024/8/1 16:50
 * <p>
 * <p>
 * 6. A+B问题VIII
 * 题目描述
 * 你的任务是计算若干整数的和。
 * 输入描述
 * 输入的第一行为一个整数N，接下来N行每行先输入一个整数M，然后在同一行内输入M个整数。
 * <p>
 * 输出描述
 * 对于每组输入，输出M个数的和，每组输出之间输出一个空行。
 * 输入示例
 * 3
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 3 1 2 3
 * 输出示例
 * 10
 * <p>
 * 15
 * <p>
 * 6
 * 提示信息
 * 注意以上样例为一组测试数据，后端判题会有很多组测试数据，也就是会有多个N的输入
 * 例如输入可以是：
 * 3
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 3 1 2 3
 * 3
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 3 1 2 3
 * 输出则是
 * 10
 * <p>
 * 15
 * <p>
 * 6
 * 10
 * <p>
 * 15
 * <p>
 * 6
 * 只保证每组数据间是有空行的。但两组数据并没有空行
 */
public class _006ABⅥ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> results = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                break; // 终止输入
            }

            int N = Integer.parseInt(line);
            List<Integer> groupResult = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                line = sc.nextLine().trim();
                String[] tokens = line.split(" ");
                int M = Integer.parseInt(tokens[0]);
                int sum = 0;

                for (int j = 1; j <= M; j++) {
                    sum += Integer.parseInt(tokens[j]);
                }

                groupResult.add(sum);
            }

            results.add(groupResult);
        }

        sc.close();

        for (List<Integer> result : results) {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
                if(i!=result.size()-1){
                    System.out.println("<p>");
                }
            }
        }
//        for (int i = 0; i < results.size(); i++) {
//            List<Integer> groupResult = results.get(i);
//            for (int j = 0; j < groupResult.size(); j++) {
//                System.out.println(groupResult.get(j));
//            }
//            if (i < results.size() - 1) {
//                System.out.println("*"); // 每组之间输出一个空行
//            }
//        }
    }
}
