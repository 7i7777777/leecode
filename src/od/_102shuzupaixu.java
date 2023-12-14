package od;

import java.util.*;

/**
 * @ClassName _102shuzupaixu
 * @Description TODO 数组排序
 * 题目描述
 * 给定一个乱序的数组
 * 删除所有重复元素
 * 使得每个元素只出现一次
 * 并且按照出现的次数从高到低进行排序
 * 相同出现次数按照第一次出现顺序进行先后排序
 * 数组大小不超过100
 * 数组元素值不超过100
 *
 * 输入描述
 * 一个数组
 *
 * 输出描述
 * 去重排序后的数组
 *
 * 示例一
 * 输入
 * 1,3,3,3,2,4,4,4,5
 * 输出
 * 3,4,1,2,5
 * @Author 2+7
 * @Date 2023/3/30 14:53
 */
public class _102shuzupaixu {
    public static void main(String[] args) {
        //1,3,3,3,2,4,4,4,5
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(",");
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for (String s : arr) {
            map.put(Integer.parseInt(s),map.getOrDefault(Integer.parseInt(s),0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(((o1, o2) -> Integer.compare(o2.getValue(),o1.getValue()))); //箭头表达式 比较器
//        list.sort((o1, o2) -> {return o2.getValue()- o1.getValue();});

//        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o2.getValue()-o1.getValue();
//            }
//        });
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            res.add(entry.getKey());
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if(i!=res.size()-1){
                System.out.print(",");
            }
        }
    }
}