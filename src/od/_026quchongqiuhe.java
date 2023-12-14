package od;

import java.util.*;

/**
 * @ClassName _026quchongqiuhe
 * @Description TODO 题目名称
 * 题目描述
 * 给定一个数组，编写一个函数，
 * 计算他的最大N个数和最小N个数的和，
 * 需要对数组进行去重。
 * <p>
 * 输入描述
 * 第一行输入M，M表示数组大小
 * 第二行输入M个数，表示数组内容
 * 第三行输入N表示需要计算的最大最小N的个数
 * <p>
 * 输出描述
 * 输出最大N个数和最小N个数的和
 * <p>
 * 示例一
 * 输入
 * 5
 * 95 88 83 64 100
 * 2
 * 输出
 * 342
 * 说明
 * 最大2个数[100 95]最小2个数[83 64]
 * 输出342
 * <p>
 * 示例一
 * 输入
 * 5
 * 3 2 3 4 2
 * 2
 * 输出
 * -1
 * 说明
 * 最大2个数是[4 3]最小2个数是[3 2]
 * 有重叠输出为-1
 * @Author 2+7
 * @Date 2023/3/7 14:07
 */
public class _026quchongqiuhe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(sc.nextLine());
        Set<Integer> set = new TreeSet<>();
//        for (int i = 0; i < m; i++) {
//            set.add(Integer.valueOf(s[i]));
//        }
        // 将数组传值给set集合  stream方法
        Arrays.stream(s)
                .forEach(x -> set.add(Integer.parseInt(x)));

        List<Integer> list = new ArrayList<>(set);
        if (list.size() / 2 >= n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += list.get(i)+list.get(list.size()-1-i);
            }
            System.out.println(sum);
        } else {
            System.out.println(-1);
        }
    }
}