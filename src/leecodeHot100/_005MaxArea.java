package leecodeHot100;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 */
public class _005MaxArea {
    public int maxArea(int[] height) {

        //超出时间限制
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h1 = height[i];
                int h2 = height[j];
                if (h1 <= h2) {
                    maxArea = Math.max(maxArea,(j - i) * h1);
                } else {
                    maxArea = Math.max(maxArea,(j - i) * h2);
                }
            }
        }
        return maxArea;
    }

    public int maxWater(int[] height){
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int h1 = height[left];
            int h2 = height[right];
            int h = Math.min(h1, h2);
            int width = right - left;
            int water = h * width;
            maxWater = Math.max(maxWater, water);

            if (h1 < h2) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        _005MaxArea maxArea = new _005MaxArea();
        int[] height = {1, 8, 6, 2, 6, 4, 8, 3, 7};
        System.out.println(maxArea.maxArea(height));
    }
}
