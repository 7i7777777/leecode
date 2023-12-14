package codeTop;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName _006sanshuzhihe
 * @Description TODO
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * @Author 2+7
 * @Date 2023/3/23 17:00
 */
public class _006sanshuzhihe {

    //[[-1, 0, 1], [-1, 2, -1], [0, 1, -1]]
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            int j = i + 1;
//            while (j<list.size()){
//                int k = j+1;
//                while(k<list.size()){
//                    if(list.get(i)+list.get(j)+list.get(k)==0){
//                        int[] arr = {list.get(i),list.get(j),list.get(k)};
//                        res.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
//                    }
//                    k++;
//                }
//                j++;
//            }
//        }
//        return res;
//    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            int j = i + 1, k = list.size() - 1;
            while (j < k) {
                if (list.get(i) + list.get(j) + list.get(k) == 0) {
                    int[] arr = {list.get(i), list.get(j), list.get(k)};
                    set.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
                    j++;
                    k--;
                } else if (list.get(i) + list.get(j) + list.get(k) < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}