package leecodeHot100;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * 提示:
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
public class _009FindAnagrams {

    //滑动窗口和哈希表

    /**
     * 初始化两个哈希表：charCountP 用于存储字符串 p 中字符的出现次数，charCountWindow 用于存储滑动窗口内字符的出现次数。
     * 先遍历字符串 p，统计其中每个字符的出现次数，存储在 charCountP 中。
     * 初始化左右指针 left 和 right，分别指向滑动窗口的开始和结束。
     * 开始遍历字符串 s，移动右指针 right 向右，同时更新 charCountWindow。
     * 如果当前窗口内的字符频次超过了 p 中的字符频次，说明可能存在多余的字符，需要收缩窗口。移动左指针 left 向右，同时更新 charCountWindow。
     * 在每次移动右指针的过程中，检查 charCountWindow 是否等于 charCountP，如果是，则将 left 添加到结果列表。
     * 最终返回结果列表
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> charCountP = new HashMap<>();
        Map<Character, Integer> charCountWindow = new HashMap<>();
        for (char c : p.toCharArray()) {
            charCountP.put(c, charCountP.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            charCountWindow.put(s.charAt(right), charCountWindow.getOrDefault(s.charAt(right), 0) + 1);
            if (right - left + 1 == p.length()) {
                if (charCountWindow.equals(charCountP)) {
                    result.add(left);
                }
                charCountWindow.put(s.charAt(left), charCountWindow.get(s.charAt(left)) - 1);
                if (charCountWindow.get(s.charAt(left)) == 0) {
                    charCountWindow.remove(s.charAt(left));
                }
                left++;
            }
        }
        return result;
    }


}
