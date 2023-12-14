package random.June;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[][] people = {{7, 1}, {8, 2}, {9, 0}, {6, 3}, {8, 0}};

        // 对二维数组进行排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 按照体重降序排列
                return o1[1] - o2[1];
            }
        });
        //[9, 0] [8, 0] [7, 1] [8, 2] [6, 3]

        for (int i = 1; i < people.length; i++) {
            int[] temp = people[i];
            int j = i - 1;

            while (j >= 0 && (temp[0] < people[j][0] || (temp[0] == people[j][0] && temp[1] < people[j][1]))) {
                people[j + 1] = people[j];
                j--;
            }
            people[j + 1] = temp;
        }

        // 输出排序后的结果
        for (int[] person : people) {
            System.out.print(Arrays.toString(person)+" ");
        }
    }

}
