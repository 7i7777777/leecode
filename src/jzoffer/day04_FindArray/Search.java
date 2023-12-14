package jzoffer.day04_FindArray;

public class Search {
    //统计一个数字在排序数组中出现的次数。
    public int search(int[] nums,int target){
        int fre=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                fre++;
            }
        }
        return fre;
    }
}