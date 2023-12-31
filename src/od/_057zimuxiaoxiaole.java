package od;

import java.util.*;

/**
 * @ClassName _057zimuxiaoxiaole
 * @Description TODO 字母消消乐
 * 题目描述
 * 游戏规则：
 * 输入一个只包含英文字母的字符串,
 * 字符串中的两个字母如果相邻且相同,就可以消除。
 * 在字符串上反复执行消除的动作,
 * 直到无法继续消除为止,此时游戏结束。
 * 输出最终得到的字符串长度。
 * <p>
 * 输入描述
 * 输入原始字符串str
 * 只能包含大小写英文字母,字母的大小写敏感,
 * str长度不超过100
 * <p>
 * 输出描述
 * 输出游戏结束后,最终得到的字符串长度
 * <p>
 * 示例一
 * 输入
 * gg
 * 输出
 * 0
 * 说明
 * gg可以直接消除，得到空串，长度为0
 * <p>
 * 示例二
 * 输入
 * mMbccbc
 * 输出
 * 3
 * 说明
 * mMbccbc中 可以先消除cc 此时变为mMbbc
 * 再消除，bb，此时变成mMc
 * 此时没有相同且相邻的字符 无法继续消除
 * 最终得到字符串mMc，长度为3
 * <p>
 * 备注：
 * 输入中包含非大小写英文字母时
 * 均为异常输入
 * 直接返回0
 * @Author 2+7
 * @Date 2023/3/16 11:26
 */
public class _057zimuxiaoxiaole {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String str = scanner.nextLine();
            solution(str);
        }
    }

    private static void solution(String str) {
        if (str.replaceAll("[a-zA-Z]", "")
                .length() > 0) {
            System.out.println(0);
            return;
        }

        LinkedList<Character> link = new LinkedList<>();
        for (char c : str.toCharArray()) {
            link.add(c);
        }
        for (int i = 0; i < link.size() - 1; ) {
            if (link.get(i).equals(link.get(i + 1))) {
                link.remove(i);
                link.remove(i);
                i--;
                i = Math.max(i, 0);
            } else {
                i++;
            }
        }

        System.out.print(link.size());
    }
}