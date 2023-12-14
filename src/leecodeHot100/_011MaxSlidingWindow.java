package leecodeHot100;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 */
public class _011MaxSlidingWindow {

    //超出时间限制问题
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer> windowList = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            windowList.add(nums[right]);
            if (right - left + 1 == k) {
                result.add(windowList.stream().max(Integer::compareTo).get());//集合找到最大值
                windowList.remove(0);
                left++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();//集合转数组
    }

    //双端队列Deque优化算法
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 如果队列不为空，且队列的第一个元素已经不在滑动窗口内，将其移出队列
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // 从队列尾部开始，移除小于当前元素的元素，因为它们不可能是最大值
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i); // 将当前元素的索引加入队列

            // 当达到窗口大小时，将队列的第一个元素（即最大值的索引）加入结果列表
            if (i >= k - 1) {
                result.add(nums[deque.peek()]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        _011MaxSlidingWindow o = new _011MaxSlidingWindow();
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1};
        System.out.println(Arrays.toString(o.maxSlidingWindow1(nums1, 3)));
        System.out.println(Arrays.toString(o.maxSlidingWindow(nums2, 1)));
    }
}
