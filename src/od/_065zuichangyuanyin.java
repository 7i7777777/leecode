package od;

import java.util.Scanner;

/**
 * @ClassName _065zuichangyuanyin
 * @Description TODO 最长的元音字符串
 * 题目描述
 * 定义当一个字符串只有元音字母(a,e,i,o,u,A,E,I,O,U)组成,
 * 称为元音字符串，现给定一个字符串，请找出其中最长的元音字符串，
 * 并返回其长度，如果找不到请返回0，
 * 字符串中任意一个连续字符组成的子序列称为该字符串的子串
 * <p>
 * 输入描述
 * 一个字符串其长度 0 < length ,字符串仅由字符a-z或A-Z组成
 * <p>
 * 输出描述
 * 一个整数，表示最长的元音字符子串的长度
 * <p>
 * 示例一
 * 输入
 * asdbuiodevauufgh
 * 输出
 * 3
 * 说明
 * 最长的元音字符子串为uio和auu长度都为3，因此输出3
 * @Author 2+7
 * @Date 2023/3/21 10:58
 */
public class _065zuichangyuanyin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        solution(s);
    }

    private static void solution(String s) {
        char[] arr = s.toCharArray();
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                int temp = 1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (isVowel(arr[j])) {
                        temp++;
                    } else {
                        i = j;
                        break;
                    }
                }
                if (temp > len) {
                    len = temp;
                }
            }
        }
        System.out.println(len);
    }

    private static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}