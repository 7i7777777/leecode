package kamaCoder;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author zhengjq3
 * @data 2024/8/1 17:36
 *
 *
 * 7. 平均绩点
 * 题目描述
 * 每门课的成绩分为A、B、C、D、F五个等级，为了计算平均绩点，规定A、B、C、D、F分别代表4分、3分、2分、1分、0分。
 * 输入描述
 * 有多组测试样例。每组输入数据占一行，由一个或多个大写字母组成，字母之间由空格分隔。
 * 输出描述
 * 每组输出结果占一行。如果输入的大写字母都在集合｛A,B,C,D,F｝中，则输出对应的平均绩点，结果保留两位小数。否则，输出“Unknown”。
 * 输入示例
 * A B C D F
 * B F F C C A
 * D C E F
 * 输出示例
 * 2.00
 * 1.83
 * Unknown
 */
public class _007AvgMatchPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
        map.put("A", 4);
        map.put("B", 3);
        map.put("C", 2);
        map.put("D", 1);
        map.put("F", 0);
        List<String> list = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine().trim();
            if(line.isEmpty()){
                break;
            }
            String[] split = line.split("\\s+");
            int sum = 0;
            for (String s : split) {
                if(map.containsKey(s)){
                    sum += map.get(s);
                }else{
                    sum = -1;
                    break;
                }
            }
            if(sum == -1){
                list.add("Unknown");
            }else {
                BigDecimal avg = BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(split.length),2,BigDecimal.ROUND_HALF_UP);
                list.add(""+avg);
            }
        }
        sc.close();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
