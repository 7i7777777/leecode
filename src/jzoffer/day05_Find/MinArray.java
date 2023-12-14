package jzoffer.day05_Find;

public class MinArray {
    public static int minArray(int[] numbers){
        //把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
        //给你一个可能存在重复元素值的数组numbers,它原来是一个升序排列的数组，并按上述清醒进行了一次旋转。
        //请返回旋转数组的最小元组。
        //例如，数组[3，4，5，1，2]为[1,2,3,4,5]的一次旋转，还数组的最小值为1
        int low = 0;
        int high = numbers.length-1;
        while(low<high){
            int pivot = low + (high-low)/2;
            if(numbers[pivot]<numbers[high]){
                high=pivot;
            }else if(numbers[pivot]>numbers[high]){
                low=pivot+1;
            }else {
                high--;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int[] array = {2,2,2,0,1};
        System.out.println(minArray(array));
    }
}