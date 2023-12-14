package jzoffer.day09_DynamicProgramming;

public class MaxSubArray {
    //输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
    //
    //要求时间复杂度为O(n)。
    //常见解法  时间复杂度   空间复杂度
    //暴力搜索  O(N^2)      O(1)
    //分治思想  O(NlogN)    O(logN)
    //动态规划  O(N)        O(1)
    public int maxSubArray(int[] nums){
        int res =nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i] += Math.max(nums[i-1],0);
            res = Math.max(res,nums[i]);
        }
        return res;
    }
}