package jzoffer.day23_Math;

public class MajorityElement {
    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    public int majorityElement(int[] nums){
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
