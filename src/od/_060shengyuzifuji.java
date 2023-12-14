package od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @ClassName _060shengyuzifuji
 * @Description TODO 剩余可用字符集
 * 题目描述
 * 给定两个字符集合
 * 一个是全量字符集
 * 一个是已占用字符集
 * 已占用字符集中的字符不能再使用
 * 要求输出剩余可用字符集
 * <p>
 * 输入描述
 * 输入一个字符串 一定包含@
 * @前为全量字符集 @后的为已占用字符集
 * 已占用字符集中的字符
 * 一定是全量字符集中的字符
 * 字符集中的字符跟字符之间使用英文逗号隔开
 * 每个字符都表示为字符+数字的形式
 * 用英文冒号分隔
 * 比如a:1表示一个a字符
 * 字符只考虑英文字母，区分大小写
 * 数字只考虑正整型 不超过100
 * 如果一个字符都没被占用 @标识仍存在
 * 例如 a:3,b:5,c:2@
 * 输出描述
 * 输出可用字符集
 * 不同的输出字符集之间用回车换行
 * 注意 输出的字符顺序要跟输入的一致
 * 不能输出b:3,a:2,c:2
 * 如果某个字符已全部占用 则不需要再输出
 * <p>
 * 示例一
 * 输入
 * a:3,b:5,c:2@a:1,b:2
 * 输出
 * a:2,b:3,c:2
 * 说明
 * 全量字符集为3个a，5个b，2个c
 * 已占用字符集为1个a，2个b
 * 由于已占用字符不能再使用
 * 因此剩余可用字符为2个a，3个b，2个c
 * 因此输出a:2,b:3,c:2
 * @Author 2+7
 * @Date 2023/3/20 15:47
 */
public class _060shengyuzifuji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split("@");
        if (split.length == 1) {
            System.out.println(split[0]);
            return;
        }
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        String p = split[0];
        String q = split[1];
        String[] split1 = p.split(",");
        String[] split2 = q.split(",");
        for (String s : split1) {
            String[] split3 = s.split(":");
            map.put(split3[0], Integer.parseInt(split3[1]));
        }
        for (String s : split2) {
            String[] split3 = s.split(":");
            map1.put(split3[0],Integer.parseInt(split3[1]));
        }
        for (String s : map1.keySet()) {
            map.put(s,map.get(s)-map1.get(s));
        }
        String res = map.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue()).collect(Collectors.joining(","));
        System.out.println(res);
    }
}