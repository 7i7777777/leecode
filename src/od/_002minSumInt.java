package od;

import java.util.*;

/**
 * @ClassName _002minSumInt
 * @Description TODO 给定两个整数数组 array1 array2
 * 数组元素按升序排列
 * 假设从array1 array2中分别取出一个元素可构成一对元素
 * 现在需要取出K个元素
 * 并对取出的所有元素求和
 * 计算和的最小值
 * 注意：
 * 两对元素如果对应于array1 array2中的两个下标均相同，则视为同一个元素
 *
 * 输入 ：
 * 3 1 1 2
 * 3 1 2 3
 * 2
 * 输出：
 * 2
 * @Author 2+7
 * @Date 2023/2/28 21:42
 */
public class _002minSumInt {
    //暴力相加
    public static int findMinSumKPairs(int[] array1, int[] array2, int k) {
        List<Integer> list = new ArrayList();
        int sum = 0;
        for(int i=0;i<array1.length;i++){
            for(int j=0;j<array2.length;j++){
                list.add(array1[i]+array2[j]);
            }
        }
        Collections.sort(list);
        for(int i=0;i<k;i++){
            sum += list.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            array1[i] = scanner.nextInt();
        }
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            array2[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        System.out.println(findMinSumKPairs(array1, array2, k));

//        for (int i = 0; i < size1; i++) {
//            System.out.print(array1[i]+" ");
//        }
//        System.out.println();
//        for (int i = 0; i < size2; i++) {
//            System.out.print(array2[i]+" ");
//        }
//        System.out.println(k);
    }
}