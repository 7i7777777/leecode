package random.Dec25;

public class QuickSort {
    public static int[] sort(int[] array,int low ,int high){
        if(low>high)
            return null;
        int i=low;
        int j=high;
        int sentry = array[i];
        int tmp;
        while(i<j){
            while (i<j && sentry<=array[j]) j--;
            while (i<j && sentry>=array[i]) i++;
//
            if(i<j){
                swap(array[i],array[j]);
            }
        }
        array[low] = array[i];
        array[i] =sentry;
        sort(array,low,j-1);
        sort(array,j+1,high);
        return array;
    }
    static void swap(int a, int b){
        int tmp;
        tmp=a;
        a=b;
        b=tmp;
    }

    public static void main(String[] args) {
        int[] array={5,4,3,2,1};
        int[] sort = sort(array,0,4);
        for (int i=0;i<sort.length;i++){
            System.out.println(sort[i]);
        }
    }
}
