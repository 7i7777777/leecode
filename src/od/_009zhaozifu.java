package od;

import java.util.*;

/**
 * @ClassName _009zhaozifu
 * @Description TODO 题目描述
 * 给定两个字符串，
 * 从字符串2中找出字符串1中的所有字符，
 * 去重并按照ASCII码值从小到大排列。
 *
 * 输入描述
 * 字符范围满足ASCII编码要求，
 * 输入字符串1长度不超过1024，
 * 字符串2长度不超过100。
 *
 * 输出描述
 * 按照ASCII由小到大排序
 *
 * 示例一
 * 输入
 * bach
 * bbaaccddfg
 * 输出
 * abc
 * 示例一
 * 输入
 * fach
 * bbaaccedfg
 * 输出
 * acf
 * @Author 2+7
 * @Date 2023/3/2 21:11
 */
public class _009zhaozifu {

    private static void solution2(String s1,String s2){
        List<Character> list = new ArrayList<>();
        for (char c1 : s1.toCharArray()) {
            for (char c2 : s2.toCharArray()) {
                if (c1 == c2) {
                    list.add(c1);
                    break;
                }
            }
        }
        // 先通过 list.stream() 方法将 List 转换成 Stream，然后调用 distinct() 方法，返回一个去重后的 Stream，接着调用 sorted() 方法，返回一个排序后的 Stream。
//        list.stream().distinct().sorted().forEach(System.out::print);

        //第二种方法就是构造一个TreeSet集合（TreeSet是有序、无重复元素的集合） 将TreeSet转换为ArrayList类型
        ArrayList<Character> arr = new ArrayList<>(new TreeSet<>(list));
        arr.forEach(System.out::print);
    }

    private static void solution1(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = str2.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars2) {
            set.add(c);
        }

        Set<Character> res = new TreeSet<>();
        for (char c : chars1) {
            if (set.contains(c)) {
                res.add(c);
            }
        }

        for (Character c : res) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        solution2(a,b);
    }
}