package random.June;

/**
 * 2023.06.13
 * 如果数组是单调递增或单调递减的，那么它是 单调 的。
 *
 * 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums 是单调递减的。
 *
 * 当给定的数组 nums 是单调数组时返回 true，否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [6,5,4,4]
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,3,2]
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/monotonic-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 单调数列 {
    public boolean isMonotonic(int[] nums) {
        boolean isAdd = false;
        boolean isSub = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                isAdd = true;
            } else if (nums[i] > nums[i + 1]) {
                isSub = true;
            }
            if (isAdd && isSub) {
                return false;
            }
        }
        return true;
    }
}
