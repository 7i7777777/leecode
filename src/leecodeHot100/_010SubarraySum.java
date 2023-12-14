package leecodeHot100;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class _010SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp == k) {
                result++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                if (temp == k) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _010SubarraySum o = new _010SubarraySum();
        int[] nums1 = {1, 1, 1};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {0, 0};
        System.out.println(o.subarraySum(nums1, 2));
        System.out.println(o.subarraySum(nums2, 3));
        System.out.println(o.subarraySum(nums3, 0));
    }
}
