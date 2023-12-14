package leecodeHot100;

import java.util.Arrays;

/**
 * 189. 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class _015Rotate {

    public void rotate(int[] nums, int k) {
        while (k >= nums.length) {
            k = k - nums.length;
        }
        if (k == 0) {
            return;
        }
        int[] temp = new int[k];
        if (nums.length - (nums.length - k) >= 0)
            System.arraycopy(nums, nums.length - k, temp, 0, k);
        for (int i = nums.length - 1; i - k >= 0; i--) {
            nums[i] = nums[i - k];
        }
        System.arraycopy(temp, 0, nums, 0, k);
    }

    public static void main(String[] args) {
        _015Rotate o = new _015Rotate();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums1 = {-1,-100,3,99};
        o.rotate(nums, 3);
        o.rotate(nums1, 2);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums1));
    }
}
