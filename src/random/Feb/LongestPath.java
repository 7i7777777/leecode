package random.Feb;

import java.util.Scanner;

/**
 * @ClassName LongestPath
 * @Description TODO
 * @Author 2+7
 * @Date 2023/2/28 11:16
 */
public class LongestPath {
    public static int findLongestPath(int[][] matrix) {
        int n = matrix.length;
        boolean[] visited = new boolean[n];
        int maxPathSize = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                maxPathSize = Math.max(maxPathSize, dfs(matrix, visited, i));
            }
        }
        return maxPathSize;
    }

    public static int dfs(int[][] matrix, boolean[] visited, int node) {
        visited[node] = true;
        int pathSize = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[node][i] == 1 && !visited[i]) {
                pathSize += dfs(matrix, visited, i);
            }
        }
        return pathSize;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(findLongestPath(matrix));
    }
}