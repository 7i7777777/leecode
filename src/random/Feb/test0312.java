package random.Feb;

import java.util.*;

/**
 * @ClassName test0312
 * @Description TODO
 * @Author 2+7
 * @Date 2023/3/12 16:14
 */
public class test0312 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        for (int t = 0; t < m; t++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    continue;
                }
                int j = i + 1;
                int k = n - 1;
                while (j < k) {
                    int A = a[i];
                    int B = a[j];
                    int C = a[k];
                    if (A + B <= C && C > A && C > B) {
                        break;
                    }
                    int sum = A * A + B * B;
                    int square = C * C;
                    if (sum < square) {
                        j++;
                    } else if (sum > square) {
                        k--;
                    } else {  // 找到一组解
                        count++;
                        a[i] = 0;
                        a[j] = 0;
                        a[k] = 0;
                        Arrays.sort(a);
                        break;
                    }
                }
            }
            System.out.println(count);
        }
        scanner.close();
    }
}