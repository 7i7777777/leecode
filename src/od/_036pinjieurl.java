package od;

import java.util.Scanner;

/**
 * @ClassName _036pinjieurl
 * @Description TODO 拼接URL
 * 题目描述
 * 给定一个url前缀和url后缀
 * 通过,分割 需要将其连接为一个完整的url
 * 如果前缀结尾和后缀开头都没有/
 * 需要自动补上/连接符
 * 如果前缀结尾和后缀开头都为/
 * 需要自动去重
 * 约束：
 * 不用考虑前后缀URL不合法情况
 *
 * 输入描述
 * url前缀(一个长度小于100的字符串)
 * url后缀(一个长度小于100的字符串)
 *
 * 输出描述
 * 拼接后的url
 *
 * 示例一
 * 输入
 * /acm,/bb
 * 输出
 * /acm/bb
 * 示例二
 * 输入
 * /abc/,/bcd
 * 输出
 * /abc/bcd
 * 示例三
 * 输入
 * /acd,bef
 * 输出
 * /acd/bef
 * 示例四
 * 输入
 * ,
 * 输出
 * /
 * @Author 2+7
 * @Date 2023/3/8 15:14
 */
public class _036pinjieurl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        StringBuilder sb = new StringBuilder();
        for (String s1 : s) {
            if(!s1.startsWith("/")){
                s1 = "/" + s1;
            }
            sb.append(s1);
        }
        String res = sb.toString().replace("//", "/");
        if(res.equals(",")){
            res = "/";
        }
        System.out.println(res);
    }
}