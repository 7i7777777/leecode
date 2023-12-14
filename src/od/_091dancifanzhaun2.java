package od;

import java.util.Scanner;

/**
 * @ClassName _091dancifanzhaun2
 * @Description TODO 单词反转2
 * 题目描述
 * 给定一段英文文章片段，由若干单词组成，单词间以空格间隔，单词下标从0开始。
 * 请翻转片段中指定区域的单词顺序并返回翻转后的内容。
 * 例如给定的英文文章片段为I am a developer,
 * 翻转区间为[0,3],则输出developer a am I。
 * String reverseWords(String s, int start, int end).
 * <p>
 * 输入描述
 * 使用换行隔开三个参数，第一个参数为英文文章内容即英文字符串，
 * 第二个参数为待反转内容起始单词下标，
 * 第三个参数为待翻转内容最后一个单词下标。
 * <p>
 * 输出描述
 * 翻转后的英文文章片段所有单词之间以一个半角空格分隔进行输出。
 * <p>
 * 示例一
 * 输入
 * I am a developer
 * 1
 * 2
 * 输出
 * I a am developer
 * 说明
 * 示例二
 * 输入
 * Hello world
 * -1
 * 1
 * 输出
 * world Hello
 * 说明
 * 下标小于0时从第一个单词开始
 * <p>
 * 示例三
 * 输入
 * I am a developer
 * 0
 * 5
 * 输出
 * developer a am I
 * 说明
 * 下标大于实际单词个数，则按最大下标算。
 * <p>
 * 示例四
 * 输入
 * I am a developer
 * -2
 * -1
 * 输出
 * I am a developer
 * 说明
 * 翻转区间无效时不做翻转。
 * @Author 2+7
 * @Date 2023/3/28 15:52
 */
public class _091dancifanzhaun2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println(reverseWords(s, start, end));
    }

    private static String reverseWords(String s, int start, int end) {
        String[] arr = s.split(" ");
        int i = start < 0 ? 0 : start;
        int j = end > arr.length? arr.length : end;
        if(j<0){
            return s;
        }
        while(i<j){
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < arr.length; k++) {
            sb.append(arr[k]);
            if(k!=arr.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}