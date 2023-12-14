package leecodeHot100;

import java.util.Arrays;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 提示：
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 */
public class _017FirstMissingPositive {

    /**
     * 这个问题可以通过原地哈希的方式来解决，满足时间复杂度为 O(n) 和常数级别额外空间的要求。具体思路如下：
     * 首先，遍历数组 nums，将所有不在 [1, n] 区间内的元素设置为 n+1，其中 n 是数组的长度。这是因为我们的目标是找出 [1, n] 区间内没有出现的最小正整数，而超出这个范围的元素不会影响答案。
     * 继续遍历数组，将数组中的每个元素 x，如果 1 <= x <= n，则将索引 x-1 处的元素标记为负数，表示数字 x 存在。
     * 最后，再次遍历数组，找到第一个正数的索引 i，则 i + 1 就是未出现的最小正整数。
     */
    public int firstMissingPositive(int[] nums) {
        int result = 0;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > nums.length) {
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1 && nums[i] <= nums.length) {
                arr[nums[i] - 1] = -1;
            }
        }
        int i = 0;
        while (i < arr.length) {
            if (arr[i] >= 0) {
                break;
            }
            i++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        _017FirstMissingPositive o = new _017FirstMissingPositive();
        int[] nums = {1, 2, 0};
        int[] nums1 = {3, 4, -1, 1};
        int[] nums2 = {7, 8, 9, 11, 12};
        int[] nums3 = {1};
        System.out.println(o.firstMissingPositive(nums));
        System.out.println(o.firstMissingPositive(nums1));
        System.out.println(o.firstMissingPositive(nums2));
        System.out.println(o.firstMissingPositive(nums3));
    }
}
