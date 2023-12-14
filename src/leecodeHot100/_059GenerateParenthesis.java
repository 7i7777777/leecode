package leecodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * 提示：
 * 1 <= n <= 8
 */
public class _059GenerateParenthesis {

    /**
     * 这道题是要生成有效的括号组合，对于给定的数字n，生成所有可能的有效括号组合。
     * 为了解决这个问题，我们可以使用回溯算法。
     * 具体步骤如下：
     * 1. 定义一个列表 result 来存储生成的括号组合。
     * 2. 使用回溯算法来生成括号组合，具体步骤如下：
     * - 定义两个变量 left 和 right ，分别表示剩余左括号和右括号的数量。
     * - 如果 left 和 right 都为0，说明已经生成了一个有效的括号组合，将其加入到 result 中。
     * - 如果 left 大于0，可以添加一个左括号，并继续递归生成括号组合，此时 left 减1。
     * - 如果 right 大于0且 right 大于 left ，可以添加一个右括号，并继续递归生成括号组合，此时 right 减1。
     * 3. 返回最终的结果 result 。
     * 以下是使用Java语言实现的代码：
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, n, "", result);
        return result;
    }


    private void backtrack(int left, int right, String current, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }
        if (left > 0) {
            backtrack(left - 1, right, current + "(", result);
        }
        if (right > left) {
            backtrack(left, right - 1, current + ")", result);
        }
    }

    public static void main(String[] args) {
        _059GenerateParenthesis solution = new _059GenerateParenthesis();

        int n = 3;
        List<String> result = solution.generateParenthesis(n);
        System.out.println(result);

        n = 1;
        result = solution.generateParenthesis(n);
        System.out.println(result);
    }
}
