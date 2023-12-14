package od;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @ClassName _050feiyangedizeng
 * @Description TODO 非严格递增连续数字序列
 * 题目描述
 * 输入一个字符串仅包含大小写字母和数字
 * 求字符串中包含的最长的非严格递增连续数字序列长度
 * 比如：
 * 12234属于非严格递增数字序列
 * <p>
 * 输入描述
 * 输入一个字符串仅包含大小写字母和数字
 * <p>
 * 输出描述
 * 输出字符串中包含的最长的非严格递增连续数字序列长度
 * <p>
 * 示例一
 * 输入
 * abc2234019A334bc
 * 输出
 * 4
 * 说明
 * 2234为最长的非严格递增连续数字序列，所以长度为4
 * @Author 2+7
 * @Date 2023/3/13 09:26
 */
public class _050feiyangedizeng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String> list = Arrays.stream(s.split("[A-Z,a-z]")).filter(x -> !x.isEmpty()).collect(Collectors.toList());
        String nums = "";
        for (String s1 : list) {
            nums += s1;
        }
        char[] c = nums.toCharArray();
        int i = 0, j = 1;
        int count = 1;
        int max = 1;
        while(j<c.length){
            if(c[i]==c[j]||c[i]+1==c[j]){
                count++;
            }else{
                count = 1;
            }
            if(max<count){
                max = count;
            }
            i++;
            j++;
        }
        System.out.println(max);
    }
}