package od;

import java.util.*;

/**
 * @ClassName _063shejibisai
 * @Description TODO 射击比赛
 * 题目描述
 * 给定一个射击比赛成绩单
 * 包含多个选手若干次射击的成绩分数
 * 请对每个选手按其最高三个分数之和进行降序排名
 * 输出降序排名后的选手ID序列
 * 条件如下:
 * <p>
 * 一个选手可以有多个射击成绩的分数 且次序不固定
 * 如果一个选手成绩小于三个 则认为选手的所有成绩无效 排名忽略该选手
 * 如果选手的成绩之和相等,则成绩相等的选手按照其ID降序排列
 * 输入描述
 * 输入第一行:一个整数 N
 * 表示该场比赛总共进行了N次射击
 * 产生N个成绩分数 2 <= N <= 100
 * 输入第二行 一个长度为N的整数序列
 * 表示参与本次射击的选手Id
 * 0 <= ID <= 99
 * 输入第三行是长度为N的整数序列
 * 表示参与每次射击的选手对应的成绩
 * 0 <= 成绩 <= 100
 * <p>
 * 输出描述
 * 符合题设条件的降序排名后的选手ID序列
 * <p>
 * 示例一
 * 输入
 * 13
 * 3,3,7,4,4,4,4,7,7,3,5,5,5
 * 53,80,68,24,39,76,66,16,100,55,53,80,55
 * 输出
 * 5,3,7,4
 * 说明
 * 该场射击比赛进行了13次,参赛选手为3 4 5 7
 * 3号选手的成绩为53 80 55最高三个成绩的和为 188
 * 4号选手的成绩为24 39 76 66最高三个和为181
 * 5号选手的成绩为53 80 55 最高三个和为188
 * 7号选手成绩为68 16 100 最高三个和184
 * 比较各个选手最高三个成绩的和
 * 3 = 5 > 7 > 4
 * 由于3和5成绩相等 且5 > 3 所以输出为5,3,7,4
 * @Author 2+7
 * @Date 2023/3/20 17:19
 */
public class _063shejibisai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(",");
        String[] m = sc.nextLine().split(",");
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (String s1 : s) {
            set.add(Integer.parseInt(s1));
        }
        // 3 7 4 5
        for (Integer s1 : set) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                if (Integer.parseInt(s[i]) == s1) {
                    list.add(Integer.parseInt(m[i]));
                }
            }
            map.put(s1,list);
        }
        Map<Integer,Integer> map1 = new HashMap<>();
        for (Integer s1 : map.keySet()) {
            List<Integer> list = map.get(s1);
            if(list.size()<3){
                continue;
            }
            list.sort((o1,o2)-> o2-o1);
            int temp = list.get(0)+list.get(1)+list.get(2);
            map1.put(s1,temp);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map1.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return Objects.equals(o2.getValue(), o1.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.print(entry.getKey());
            if(list.get(list.size()-1)!=entry){
                System.out.print(",");
            }
        }
    }
}