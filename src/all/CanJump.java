package all;

/**
 * 55. 跳跃游戏
 * 中等
 * 2.5K
 * 相关企业
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // 记录当前能够达到的最远位置
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                // 如果当前位置大于最远位置，表示无法到达当前位置
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                // 如果最远位置已经能够到达或超过最后一个下标，返回 true
                return true;
            }
        }
        return false;
    }
}
