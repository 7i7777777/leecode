package od;

import java.util.*;

/**
 * @ClassName _070zimujishu
 * @Description TODO 字母计数
 * 题目描述
 * 给出一个只包含字母的字符串,
 * 不包含空格,统计字符串中各个子字母(区分大小写)出现的次数,
 * 并按照字母出现次数从大到小的顺序输出各个字母及其出现次数
 * 如果次数相同,按照自然顺序排序,且小写字母在大写字母之前
 *
 * 输入描述
 * 输入一行仅包含字母的字符串
 *
 * 输出描述
 * 按照字母出现次数从大到小的顺序输出各个字母和字母次数,
 * 用英文分号分割,
 * 注意末尾的分号
 * 字母和次数中间用英文冒号分隔
 *
 * 示例一
 * 输入
 * xyxyXX
 * 输出
 * x:2;y:2;X:2;
 * 说明
 * 每个字符出现的次数为2 故x排在y之前
 * 而小写字母x在大写X之前
 *
 * 示例二
 * 输入
 * abababb
 * 输出
 * b:4;a:3;
 * 说明
 * b的出现个数比a多 故排在a前
 * @Author 2+7
 * @Date 2023/3/21 14:43
 */
public class _070zimujishu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c : arr) {
            if(map.containsKey(c)){
                Integer val = map.get(c);
                map.put(c,++val);
            }else{
                map.put(c,1);
            }
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if((o1.getKey()<97&&o2.getKey()<97)||(o1.getKey()>97&&o2.getKey()>97)){
                    return o2.getValue()==o1.getValue()? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue());
                }else{
                    return o2.getValue()==o1.getValue()? o2.getKey().compareTo(o1.getKey()) : o2.getValue().compareTo(o1.getValue());
                }
            }
        });
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Character, Integer> entry : list) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append(";");
        }
        System.out.println(sb);
    }
}