package random.Dec16;

public class Sort {


    public void sout(int a[],int n){
        int change=1;
        while(change==1){//change==0终止------连续两趟比较没有进行交换
            change=0;
            //奇数比较
            for(int i=1;i<n-1;i+=2){
                if(a[i]>a[i+1]){
                    int temp =a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    change=1;
                }
            }
            //偶数比较
            for(int i=0;i<n-1;i+=2){
                if(a[i]>a[i+1]){
                    int temp =a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    change=1;
                }
            }
        }
    }

    public static int[] sortArrayByParity1(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            while (begin < end && nums[begin] % 2 == 0) {
                begin++;
            }
            while (begin < end && nums[end] % 2 != 0) {
                end--;
            }
            int tmp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = tmp;
        }
        return nums;
    }


    private static void sortArray1(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start != end) {
            if (array[start] % 2 == 0) {
                for (int j = end; j >= 0; j--) {
                    if (array[j] % 2 == 1) {
                        int swap = array[start];
                        array[start] = array[j];
                        array[j] = swap;
                        break;
                    }
                    end--;
                }
            }
            start++;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {24,13,68,79,46,77};
//        int[] array = sortArrayByParity1(nums);
//        for (int i=0; i<array.length;i++){
//            System.out.print(array[i] + " ");
//        }
        sortArray1(nums);
    }

}