package leecodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class _055Permute {

    /**
     * 这道题是要求给定一个不含重复数字的数组，返回该数组的所有可能的全排列。
     * 为了解决这个问题，我们可以使用回溯算法。
     * 具体步骤如下：
     * 1. 定义一个结果列表 result，用于存储所有的全排列结果。
     * 2. 定义一个路径列表 path，用于存储当前的排列路径。
     * 3. 使用回溯算法，具体步骤如下：
     * - 如果路径的长度等于数组的长度，说明已经找到了一个全排列，将其加入结果列表。
     * - 遍历数组中的每个数字，如果该数字已经在路径中，则跳过。
     * - 将当前数字加入路径中，并递归调用回溯函数。
     * - 在递归调用后，将当前数字从路径中移除，继续遍历下一个数字。
     * 4. 返回结果列表。
     * 以下是使用Java语言实现的代码：
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, path, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            path.add(num);
            backtrack(nums, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        _055Permute o = new _055Permute();
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> result = o.permute(nums);
        System.out.println(result);
    }
}
