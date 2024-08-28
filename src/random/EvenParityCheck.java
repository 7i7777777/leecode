package random;

/**
 * @author zhengjq3
 * @data 2024/6/26 10:04
 */
public class EvenParityCheck {

    public static void main(String[] args) {
        int[] arr = { 12, 345, 2, 6, 7896 };
        System.out.println(evenParityCheck(arr));
    }

    public static int evenParityCheck(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(String.valueOf(arr[i]).length()%2==0){
                res++;
            }
        }
        return res;
    }
}
