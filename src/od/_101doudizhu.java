package od;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName _101doudizhu
 * @Description TODO 斗地主
 * 题目描述
 * 斗地主起源于湖北十堰房县，
 * 据传是一位叫吴修全的年轻人根据当地流行的扑克玩法“跑得快”改编的，
 * 如今已风靡整个中国，并流行于互联网上
 * 牌型：
 * 单顺，又称顺子，最少5张牌，最多12张牌(3...A),不能有2，
 * 也不能有大小王，不计花色
 * 例如：3-4-5-7-8，7-8-9-10-J-Q，3-4-5-6-7-8-9-10-J-Q-K-A
 * 可用的牌3<4<5<6<7<8<9<10<J<Q<K<A<2<B(小王)<C(大王)，
 * 每种牌除大小王外有4种花色(共有13X4+2张牌)
 * 输入
 * <p>
 * 手上已有的牌
 * 已经出过的牌(包括对手出的和自己出的牌)
 * 输出：对手可能构成的最长的顺子(如果有相同长度的顺子，输出牌面最大的那一个)，
 * 如果无法构成顺子，则输出NO-CHAIN
 * 输入描述
 * 输入的第一行为当前手中的牌
 * 输入的第一行为已经出过的牌
 * <p>
 * 输出描述
 * 最长的顺子
 * <p>
 * 示例一
 * 输入
 * 3-3-3-3-4-4-5-5-6-7-8-9-10-J-Q-K-A
 * 4-5-6-7-8-8-8
 * 输出
 * 9-10-J-Q-K-A
 * 示例二
 * 输入
 * 3-3-3-3-8-8-8-8
 * K-K-K-K
 * 输出
 * NO-CHAIN
 * @Author 2+7
 * @Date 2023/3/30 10:46
 */
public class _101doudizhu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split("-");
        String[] s2 = sc.nextLine().split("-");
        String[] graph = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        Map<String, Integer> map = new HashMap<>();
        for (String s : graph) {
            map.put(s, 4);
        }
        for (String s : s1) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) - 1);
            }
        }
        for (String s : s2) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) - 1);
            }
        }
        int max = Integer.MIN_VALUE;
        int i = 0, j = i + 1;
        int start = 0, end = 0;
        while (j < graph.length) {
            if (map.get(graph[i]) != 0 && map.get(graph[j]) != 0) {
                if (max < j - i) {
                    start = i;
                    end = j;
                    max = j - i;
                }
            } else {
                i = j;
            }
            j++;
        }
        if (max < 5) {
            System.out.println("NO-CHAIN");
            return;
        }
        StringBuffer sb = new StringBuffer();
        for (int k = start; k <= end; k++) {
            sb.append(graph[k]);
            if (k != end) {
                sb.append("-");
            }
        }
        System.out.println(sb);
    }
}