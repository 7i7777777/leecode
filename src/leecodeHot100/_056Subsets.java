package leecodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class _056Subsets {

    /**
     * 这道题是要求给定一个整数数组，返回该数组的所有可能的子集（幂集）。
     * 为了解决这个问题，我们可以使用回溯算法。
     * 具体步骤如下：
     * 1. 定义一个结果列表 result，用于存储所有的子集结果。
     * 2. 定义一个路径列表 path，用于存储当前的子集路径。
     * 3. 使用回溯算法，具体步骤如下：
     * - 将当前路径加入结果列表。
     * - 遍历数组中的每个数字，如果该数字已经在路径中，则跳过。
     * - 将当前数字加入路径中，并递归调用回溯函数。
     * - 在递归调用后，将当前数字从路径中移除，继续遍历下一个数字。
     * 4. 返回结果列表。
     * <p>
     * 以下是使用Java语言实现的代码：
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, 0, path, result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        _056Subsets solution = new _056Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }
}
