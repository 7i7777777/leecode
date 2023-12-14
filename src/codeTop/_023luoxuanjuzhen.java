package codeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _023luoxuanjuzhen
 * @Description TODO 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * @Author 2+7
 * @Date 2023/4/3 14:30
 */
public class _023luoxuanjuzhen {

    public static List<Integer> spiralOrder1(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                for (int i = bottom - 1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }

    //预期结果
    //[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
    //实际结果
    //[1,2,3,4,8,12,16,15,14,13,9,10,11,7,6,5]
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != ' ') {
                    dfs(matrix, i, j, list);
                }
            }
        }
        return list;
    }

    private static void dfs(int[][] matrix, int i, int j, List<Integer> list) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == ' ') {
            return;
        }
        list.add(matrix[i][j]);
        matrix[i][j] = ' ';
        dfs(matrix, i, j + 1, list);
        dfs(matrix, i + 1, j, list);
        dfs(matrix, i, j - 1, list);
        dfs(matrix, i - 1, j, list);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(spiralOrder1(matrix));


    }
}