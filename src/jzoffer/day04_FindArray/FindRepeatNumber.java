package jzoffer.day04_FindArray;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
    /*
        找出数组中重复的数字。
        在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
        数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
        请找出数组中任意一个重复的数字
     */

    public int findRepeatNumber(int[] nums){
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i] == nums[j]){
//                    return nums[i];
//                }
//            }
//        }
//        return -1;
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for(int i:nums){
            if(!set.add(i)){
                repeat=i;
                break;
            }
        }
        return repeat;
    }
}