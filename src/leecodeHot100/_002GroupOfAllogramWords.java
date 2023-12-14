package leecodeHot100;

import java.util.*;

/**
 * 49.字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class _002GroupOfAllogramWords {

    public static List<List<String>> groupAnagrams(String[] strs) {
        //创建一个哈希表，用于将字母异位词分组
        Map<String, List<String>> anagramGroups = new HashMap<>();

        //遍历输入字符串数组
        for (String str : strs) {
            //将字符串转换为字符串数组并排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            //检查是否存在于哈希表中
            if (!anagramGroups.containsKey(sortedStr)) {
                //不存在，创建一个新的列表并添加到哈希表
                anagramGroups.put(sortedStr, new ArrayList<>());
            }
            //将当前字符串添加到对应的列表中
            anagramGroups.get(sortedStr).add(str);
        }

        // 返回哈希表中的所有值，即字母异位词分组
        return new ArrayList<>(anagramGroups.values());

    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }
}
