package random.June;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class 寻找右区间 {
    public static int[] findRightInterval(int[][] intervals) {
            int n = intervals.length;
            int[][] startIntervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                startIntervals[i][0] = intervals[i][0];
                startIntervals[i][1] = i;
            }
            Arrays.sort(startIntervals, (o1, o2) -> o1[0] - o2[0]);

            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                int left = 0;
                int right = n - 1;
                int target = -1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (startIntervals[mid][0] >= intervals[i][1]) {
                        target = startIntervals[mid][1];
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                ans[i] = target;
            }
            return ans;
        }


    public static void main(String[] args) {
        int[][] intervals = {{3, 4}, {2, 3}, {1, 2}};
        int[] arr = findRightInterval(intervals);
        for (int j : arr) {
            System.out.print(j + ",");
        }
    }
}
