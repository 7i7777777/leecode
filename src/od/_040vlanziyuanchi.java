package od;

import java.util.*;

/**
 * @ClassName _040vlanziyuanchi
 * @Description TODO VLAN资源池
 * 题目描述
 * Vlan是一种为局域网设备进行逻辑划分的技术
 * 为了标识不同的vlan 引入了vlan id： 1 ~ 4094之间的整数
 * 定义一个vlan id 的资源池
 * 资源池中连续的vlan用开始vlan-结束vlan表示，
 * 不连续的用单个整数表示
 * 所有的vlan用英文逗号连接起来
 * 现有一个vlan资源池，业务需要从资源池中申请一个vlan
 * 需要你输出从vlan资源池中移除申请的vlan后的资源池
 * <p>
 * 输入描述
 * 第一行为字符串格式的vlan资源池
 * 第二行为业务要申请的vlan
 * vlan的取值范围1 ~ 4094
 * <p>
 * 输出描述
 * 从输入vlan资源池中移除申请的vlan后
 * 字符串格式的vlan资源池
 * 输出要求满足题目中要求的格式，
 * 并且要求从小到大升序输出
 * 如果申请的vlan不在原资源池，输出升序排序的原资源池的字符串即可
 * <p>
 * 示例一
 * 输入
 * 1-5
 * 2
 * 输出
 * 1,3-5
 * 说明
 * 原vlan资源池中有1 2 3 4 5 移除2后
 * 剩下的1 3 4 5按照升序排列的方式为 1 3-5
 * <p>
 * 示例二
 * 输入
 * 20-21,15,18,30,5-10
 * 15
 * 输出
 * 5-10,18,20-21,30
 * 说明
 * 原vlan资源池中有5 6 7 8 9 10 15 18 20 21 30
 * 移除15后 剩下的为 5 6 7 8 9 10 18 20 21 30
 * 按照题目描述格式并升序后的结果为5-10,18,20-21,30
 * <p>
 * 示例三
 * 输入
 * 5,1-3
 * 10
 * 输出
 * 1-3,5
 * 说明
 * 资源池中有1 2 3 5
 * 申请的资源不在资源池中
 * 将原池升序输出为1-3,5
 * <p>
 * 备注
 * 输入池中vlan数量范围为2 ~ 2094的整数
 * 资源池中vlan不重复且合法1 ~ 2094的整数
 * 输入是乱序的
 * @Author 2+7
 * @Date 2023/3/9 10:32
 */
public class _040vlanziyuanchi {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            int request = scanner.nextInt();
            solution(input,request);
        }
    }

    private static void solution(String input, int request) {
        Set<Integer> set = new TreeSet<>();
        for (String str : input.split(",")) {
            if (str.contains("-")) {
                String[] split = str.split("-");
                int start = Integer.parseInt(split[0]);
                int end = Integer.parseInt(split[1]);
                for (int i = start; i <= end; i++) {
                    set.add(i);
                }
            } else {
                set.add(Integer.parseInt(str));
            }
        }

        set.remove(request);

        ArrayList<Integer> list = new ArrayList<>(set);
        StringBuilder sb = new StringBuilder();


        Integer start = list.get(0);
        Integer last = start;

        for (int i = 1; i < list.size(); i++) {
            Integer cur = list.get(i);
            if (cur == last + 1) {
                last = cur;
            } else {
                append(sb, start, last);
                start = last = cur;
            }
        }
        append(sb, start, last);

        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static void append(StringBuilder sb, Integer start, Integer last) {
        if (start.equals(last)) {
            sb.append(last).append(",");
        } else {
            sb.append(start).append("-")
                    .append(last).append(",");
        }
    }

}