package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @ClassName ArrayDesc
 * @Description TODO
 * @Author 2+7
 * @Date 2023/3/2 13:58
 */
public class ArrayDesc {
    public static int[] ArraySort(int[] arr) {
        Integer[] arr1 = {1, 5, 3, 9, 7};
        Integer[] arr2 = {};

        Arrays.sort(arr1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr)); // [9, 7, 5, 3, 1]
        return arr;
    }
    public static int[] StreamToDesc(int[] arr) {
        Integer[] arr1 = {1, 5, 3, 9, 7};
        Arrays.sort(arr1, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(arr1)); // [9, 7, 5, 3, 1]
        return arr;
    }

    // 首先，使用Arrays.stream()方法将int数组转换为IntStream，然后使用boxed()方法将IntStream转换为Stream<Integer>。
    //
    //接着，使用sorted()方法对Stream<Integer>进行排序，传入Collections.reverseOrder()作为比较器，表示降序排序。
    //
    //最后，使用mapToInt()方法将Stream<Integer>转换为IntStream，再使用toArray()方法将IntStream转换为int数组。
    public static int[] ofStream(int[] arr){
        int[] nums = {4, 2, 6, 1, 8, 3};
        int[] sortedNums = Arrays.stream(arr)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        return sortedNums;
    }
}