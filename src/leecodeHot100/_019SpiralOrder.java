package leecodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class _019SpiralOrder {

    /**
     * 1. 初始化上边界 top 为0，下边界 bottom 为 matrix.length - 1 ，左边界 left 为0，右边界 right 为 matrix[0].length - 1 。
     * 2. 初始化结果列表 result 。
     * 3. 进入循环，循环条件为 top <= bottom 且 left <= right 。
     * - 遍历上边界，从 left 到 right ，将 matrix[top][i] 添加到 result 中。
     * - 遍历右边界，从 top + 1 到 bottom ，将 matrix[i][right] 添加到 result 中。
     * - 判断是否存在下边界和左边界，如果存在，则遍历下边界，从 right - 1 到 left ，将 matrix[bottom][i] 添加到 result 中；遍历左边界，从 bottom - 1 到 top + 1 ，将 matrix[i][left] 添加到 result 中。
     * - 更新边界变量，即 top++ 、 bottom-- 、 left++ 、 right-- 。
     * 4. 返回结果列表 result 。
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom && left <= right) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _019SpiralOrder o = new _019SpiralOrder();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = o.spiralOrder(matrix);
        System.out.println(list.toString());
    }
}
