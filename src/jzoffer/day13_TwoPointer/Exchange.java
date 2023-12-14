package jzoffer.day13_TwoPointer;

public class Exchange {
    //输入一个整数数组，
    // 实现一个函数来调整该数组中数字的顺序，
    // 使得所有在数组的前半部分，
    // 所有偶数在数组的后半部分。

    public int[] exchange(int[] nums){
        int low=0;
        int high=nums.length-1;
        while(low<high){
            while(low<high && (nums[low]%2==1)) low++;
            while(low<high && (nums[high]%2==0)) high--;
            int temp;
            temp=nums[low];
            nums[low]=nums[high];
            nums[high]=temp;
        }
        return nums;
    }
}