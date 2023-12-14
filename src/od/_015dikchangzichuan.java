package od;

import java.util.*;

/**
 * @ClassName _015dikchangzichuan
 * @Description TODO 第k长子串
 * 题目描述
 * 给定一个字符串
 * 只包含大写字母
 * 求在包含同一字母的子串中
 * 长度第K长的子串
 * 相同字母只取最长的子串
 * <p>
 * 输入描述
 * 第一行 一个子串 1 < len <= 100
 * 只包含大写字母
 * 第二行为k的值
 * <p>
 * 输出描述
 * 输出连续出现次数第k多的字母的次数
 * 如果子串中只包含同一字母的子串数小于k
 * 则输出-1
 * <p>
 * 示例一
 * 输入
 * AABAAA
 * 2
 * 输出
 * 1
 * 说明
 * 同一字母连续出现最多的A，3次
 * 第二多2次，但A出现连续3次
 * <p>
 * 示例二
 * 输入
 * AAAAHHHBBCDHHHH
 * 3
 * 输出
 * 2
 * @Author 2+7
 * @Date 2023/3/3 17:24
 */
public class _015dikchangzichuan {

    private static void solution(String s, int k) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int sum = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                sum++;
                if(i==s.length()-2){
                    if(map.containsKey(s.charAt(i))){
                        if(sum>map.get(s.charAt(i))){
                            map.put(s.charAt(i),sum);
                        }
                    }else{
                        map.put(s.charAt(i),sum);
                    }
                }
            }else {
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),sum>map.get(s.charAt(i))? sum:map.get(s.charAt(i)));
                }else{
                    map.put(s.charAt(i),sum);
                }
                sum = 1;
            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        Collections.sort(list,(e1,e2)->{
            if(e2.getValue() != e1.getValue()) {
                return e2.getValue()-e1.getValue();
            } else {
                return e2.getKey().compareTo(e1.getKey());
            }
        });
        System.out.println(list.get(k - 1).getValue());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = Integer.parseInt(sc.nextLine());
        solution(s, k);
    }
}