package leecodeHot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，
 * 则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * 提示：
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 */
public class _012MinWindow {

    //
    public String minWindow(String s, String t) {
        String result = "";
        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> windowsCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            windowsCount.put(s.charAt(right), windowsCount.getOrDefault(s.charAt(right), 0) + 1);
            while (right - left + 1 >= t.length()) {
                Set<Character> keySet = tCount.keySet();
                boolean flag = false;
                for (Character c : keySet) {
                    if (windowsCount.getOrDefault(c,0) >= tCount.get(c)) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {//
                    if (result.length() > 0) {
                        result = result.length() < s.substring(left, right + 1).length() ? result : s.substring(left, right + 1);
                    } else {
                        result = s.substring(left, right + 1);
                    }
                    windowsCount.put(s.charAt(left), windowsCount.get(s.charAt(left)) - 1);
                    left++;
                }else{
                    break;
                }
            }


        }
        return result;
    }

    //gpt牛逼 时间复杂度O(m+n)
    public String minWindow1(String s, String t) {
        Map<Character, Integer> tFreq = new HashMap<>();
        Map<Character, Integer> windowFreq = new HashMap<>();

        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLenStart = 0;
        int requiredChars = tFreq.size();
        int formedChars = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            if (tFreq.containsKey(c) && windowFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                formedChars++;
            }

            //ADOBEC ODEBANC
            while (left <= right && formedChars == requiredChars) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLenStart = left;
                }

                char leftChar = s.charAt(left);

                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                if (tFreq.containsKey(leftChar) && windowFreq.get(leftChar).intValue() < tFreq.get(leftChar).intValue()) {
                    formedChars--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLenStart, minLenStart + minLen);
    }

    public static void main(String[] args) {
        _012MinWindow o = new _012MinWindow();
        System.out.println(o.minWindow("ADOBECODEBANC", "ABC"));
    }
}
