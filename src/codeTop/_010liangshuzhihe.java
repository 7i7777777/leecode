package codeTop;

import java.util.*;

/**
 * @ClassName _010liangshuzhihe
 * @Description TODO
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * @Author 2+7
 * @Date 2023/3/24 13:46
 */
public class _010liangshuzhihe {

    //法2：排序 存索引
    public static int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i,nums[i]);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()- o2.getValue();
            }
        });
        int i =0,j = list.size()-1;
        while(i<j){
            if(list.get(i).getValue()+list.get(j).getValue() == target){
                res[0] = list.get(i).getKey();
                res[1] = list.get(j).getKey();
                break;
            }else if(list.get(i).getValue()+list.get(j).getValue() < target){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }

    //法1：暴力双循环
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            while(j<nums.length){
                if(nums[i]+nums[j]==target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] res = twoSum1(nums, 6);
        System.out.println(Arrays.toString(res));
    }
}