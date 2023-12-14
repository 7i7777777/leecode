package jzoffer.day22_BitOperation;

public class SingleNumbers {
    //一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
    // 请写程序找出这两个只出现一次的数字。
    // 要求时间复杂度是O(n)，空间复杂度是O(1)。

    public int[] singleNumbers(int[] nums){
        int ret=0;
        for(int n:nums)
            ret^=n;
        int div=1;
        while((div&ret)==0)
            div<<=1;
        int a=0,b=0;
        for(int n:nums){
            if((div&n)!=0){
                a^=n;
            }else{
                b^=n;
            }
        }
        return new int[]{a,b};
    }
}
