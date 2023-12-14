package codeTop;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName _004Kdayuansu
 * @Description TODO
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * @Author 2+7
 * @Date 2023/3/23 15:56
 */
public class _004Kdayuansu {
    public static int findKthLargest(int[] nums, int k) {
//        方法一：
        Arrays.sort(nums);
        int res = nums[nums.length-k];
        return res;
//        方法二:
//        List<Integer> list = Arrays.stream(nums).boxed().sorted((o1, o2) -> o2-o1).collect(Collectors.toList());
//        int res = list.get(k - 1);
//        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}