package od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName _094zifuchaunjiami
 * @Description TODO 字符串加密
 * 题目描述
 * 给你一串未加密的字符串str，
 * 通过对字符串的每一个字母进行改变来实现加密，
 * 加密方式是在每一个字母str[i]偏移特定数组元素a[i]的量，
 * 数组a前三位已经赋值：a[0]=1,a[1]=2,a[2]=4。
 * 当i>=3时，数组元素a[i]=a[i-1]+a[i-2]+a[i-3]，
 * 例如：原文 abcde 加密后 bdgkr，其中偏移量分别是1,2,4,7,13。
 * <p>
 * 输入描述
 * 第一行为一个整数n（1 <= n <= 1000），
 * 表示有n组测试数据，每组数据包含一行，
 * 原文str（只含有小写字母， 0 < 长度 <= 50）。
 * <p>
 * 输出描述
 * 每组测试数据输出一行，表示字符串的密文
 * <p>
 * 示例一
 * 输入
 * 1
 * xy
 * 输出
 * ya
 * @Author 2+7
 * @Date 2023/3/28 17:00
 */
public class _094zifuchaunjiami {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            char[] arr = s[i].toCharArray();
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr.length; j++) {
                sb.append(encrypt(arr[j], j));
            }
            s[i] = sb.toString();
        }
        System.out.println(Arrays.toString(s));
    }

    private static Character encrypt(char c, int index) {
       int offset = fibo(index);
       if(c+offset>122){
           return (char) (c+offset - 122 + 96);
       }
       return (char) (c+offset) ;
    }

    private static int fibo(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 4;
        } else {
            return fibo(n - 1) + fibo(n - 2) + fibo(n - 3);
        }
    }
}