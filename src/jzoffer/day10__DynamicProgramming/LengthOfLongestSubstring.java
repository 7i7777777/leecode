package jzoffer.day10__DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    //请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
    public int lengthOfLongestSubstring(String s){
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}