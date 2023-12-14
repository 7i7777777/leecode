package leecodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class _057LetterCombinations {

    /**
     * 这道题是要求给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。
     * 为了解决这个问题，我们可以使用回溯算法。
     * 具体步骤如下：
     * 1. 定义一个映射数组，将数字2-9对应的字母存储起来。
     * 2. 定义一个结果列表result，用于存储所有的字母组合结果。
     * 3. 定义一个路径字符串path，用于存储当前的字母组合路径。
     * 4. 使用回溯算法，具体步骤如下：
     * - 如果路径字符串的长度等于输入字符串的长度，将路径字符串加入结果列表。
     * - 获取当前数字对应的字母集合。
     * - 遍历字母集合，将当前字母加入路径字符串，递归调用回溯函数。
     * - 在递归调用后，将当前字母从路径字符串中移除，继续遍历下一个字母。
     * 5. 返回结果列表。
     * 以下是使用Java语言实现的代码：
     */
    private static final String[] LETTERS = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        StringBuilder path = new StringBuilder();
        backtrack(digits, 0, path, result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = LETTERS[digit];
        for (char letter : letters.toCharArray()) {
            path.append(letter);
            backtrack(digits, index + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        _057LetterCombinations solution = new _057LetterCombinations();
        String digits = "23";
        List<String> result = solution.letterCombinations(digits);
        System.out.println(result);
    }
}
