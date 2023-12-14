package random.June;

/**
 * 2023.06.13
 * 给定一个按非递减顺序排列的数字数组digits。你可以用任意次数digits[i]来写的数字。例如，如果digits = ['1','3','5']，我们可以写数字，如'13','551', 和'1351315'。
 *
 * 返回 可以生成的小于或等于给定整数 n 的正整数的个数。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：digits = ["1","3","5","7"], n = 100
 * 输出：20
 * 解释：
 * 可写出的 20 个数字是：
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * 示例 2：
 *
 * 输入：digits = ["1","4","9"], n = 1000000000
 * 输出：29523
 * 解释：
 * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
 * 81 个四位数字，243 个五位数字，729 个六位数字，
 * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。
 * 总共，可以使用D中的数字写出 29523 个整数。
 * 示例 3:
 *
 * 输入：digits = ["7"], n = 8
 * 输出：1
 * 
 *
 * 提示：
 *
 * 1 <= digits.length <= 9
 * digits[i].length == 1
 * digits[i]是从'1'到'9' 的数
 * digits中的所有值都 不同
 * digits按非递减顺序排列
 * 1 <= n <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/numbers-at-most-n-given-digit-set
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最大为N的数字组合 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String numStr = String.valueOf(n);
        int len = numStr.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;

        for (int i = len - 1; i >= 0; i--) {
            int currDigit = numStr.charAt(i) - '0';

            for (String digit : digits) {
                int digitVal = Integer.parseInt(digit);
                if (digitVal < currDigit) {
                    dp[i] += Math.pow(digits.length, len - i - 1);
                } else if (digitVal == currDigit) {
                    dp[i] += dp[i + 1];
                }
            }
        }

        int result = 0;
        for (int i = 1; i < len; i++) {
            result += Math.pow(digits.length, i);
        }

        result += dp[0];
        return result;
    }
}
