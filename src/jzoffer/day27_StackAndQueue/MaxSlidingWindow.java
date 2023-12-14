package jzoffer.day27_StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    //给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
    //输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    //输出: [3,3,5,5,6,7]

    public int[] maxSlidingWindow(int[] nums,int k){
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        for(int j=0,i=1-k;j<nums.length;i++,j++){
            //删除deque中对应的nums[i-1]
            if(i>0 && deque.peekFirst()==nums[i-1])
                deque.removeFirst();
            //保持deque递减
            while(!deque.isEmpty() && deque.peekLast()<nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            //记录窗口最大值
            if(i>0)
                res[i] = deque.peekFirst();
        }
        return res;
    }
}
