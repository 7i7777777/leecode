package random.July;


/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class 最长回文字串 {
    // 1、暴力求解  时间复杂度n3  空间复杂度1
    public static String longestPalindrome1(String s) {
        String res = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String temp = s.substring(i, j);
                if (isPalindromic(temp) && temp.length() > max) {
                    res = temp;
                    max = temp.length();
                }
            }
        }
        return res;
    }

    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    //2、中心扩散

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome1(s));
    }
}
