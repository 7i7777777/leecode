package leecodeHot100;

import java.util.Arrays;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
public class _007CatchRainwater {

    //时间超时-按行
    public int trap(int[] height) {
        int res = 0;
        int maxHeight = Arrays.stream(height).max().getAsInt();
        int y = 1;
        while (y <= maxHeight) {
            int i = 0, j = 1;
            while (j < height.length) {
                if (height[i] >= y) {
                    if (height[j] >= y) {
                        res += j - i - 1;
                        i = j;
                        j++;
                    } else {
                        j++;
                    }
                } else {
                    i++;
                    j++;
                }
            }
            y++;
        }
        return res;
    }

    //按行-超时
    public static int trap1(int[] height) {
        int res = 0;
        int max = Arrays.stream(height).max().getAsInt();
        for (int i = 1; i <= max; i++) {
            boolean isStart = false; //标记是否开始更新 temp
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    temp_sum++;
                }
                if (height[j] >= i) {
                    res += temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return res;
    }

    //双指针
    public int trap2(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {//从左到右更
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
            } else {//从右到左更
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    /**
     * 具体步骤如下：
     * 1. 初始化左指针  left  为 0，右指针  right  为  height  数组的长度减 1。
     * 2. 初始化左边最大高度  leftMax  为 0，右边最大高度  rightMax  为 0，雨水量  result  为 0。
     * 3. 使用一个循环，当  left  小于等于  right  时，执行以下操作：
     * - 如果  height[left]  小于等于  height[right] ，表示左边的高度较小，可以确定左边的柱子能够接到雨水。
     * - 如果  height[left]  大于等于  leftMax ，更新  leftMax  为  height[left] 。
     * - 否则，将  result  增加  leftMax - height[left] ，表示接到的雨水量。
     * - 将  left  向右移动一位。
     * - 否则，表示右边的高度较小，可以确定右边的柱子能够接到雨水。
     * - 如果  height[right]  大于等于  rightMax ，更新  rightMax  为  height[right] 。
     * - 否则，将  result  增加  rightMax - height[right] ，表示接到的雨水量。
     * - 将  right  向左移动一位。
     * 4. 返回雨水量  result 。
     */
    //gpt 双指针
    public int trap3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right--;
            }
        }

        return result;
    }

    public int trap4(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        _007CatchRainwater catchRainwater = new _007CatchRainwater();
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        System.out.println(catchRainwater.trap(height));
        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println(catchRainwater.trap2(height2));

    }
}
