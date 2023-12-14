package od;

import java.util.Scanner;

/**
 * @ClassName _100zhaodanci
 * @Description TODO 找单词 !!! dfs  ?????????????
 * 题目描述
 * 给一个字符串和一个二维字符数组，如果该字符串存在于该数组中，则按字符串的字符顺序输出字符串每个字符所在单元格的位置下标字符串，如果找不到返回字符串N。
 * <p>
 * 需要按照字符串的字符组成顺序搜索，且搜索到的位置必须是相邻单元格，其中“相邻单元格”是指那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 假定在数组中最多只存在一个可能的匹配。
 * 输入描述
 * 第1行为一个数字N指示二维数组在后续输入所占的行数。
 * 第2行到第N+1行输入为一个二维大写字符数组，每行字符用半角,分割。
 * 第N+2行为待查找的字符串，由大写字符组成。
 * 二维数组的大小为N*N，0 < N <= 100。
 * 单词长度K，0 < K < 1000。
 * 输出描述
 * 输出一个位置下标字符串，拼接格式为：第1个字符行下标+","+第1个字符列下标+","+第2个字符行下标+","+第2个字符列下标...+","+第N个字符行下标+","+第N个字符列下标示例1
 * <p>
 * 示例一
 * 输入
 * 4
 * A,C,C,F
 * C,D,E,D
 * B,E,S,S
 * F,E,C,A
 * ACCESS
 * 输出
 * 0,0,0,1,0,2,1,2,2,2,2,3
 * 说明
 * ACCESS分别对应二维数组的[0,0] [0,1] [0,2] [1,2] [2,2] [2,3]下标位置
 * @Author 2+7
 * @Date 2023/3/29 16:07
 */
public class _100zhaodanci {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
        /** 思路：
         * 可以使用深度优先搜索（DFS）来解决这个问题。我们首先在二维数组中找到与字符串的第一个字符相匹配的元素。然后从这个元素开始深度优先搜索，在搜索的过程中依次匹配字符串的下一个字符。如果搜索能够匹配完整个字符串，则找到了目标单词。
         * 在深度优先搜索的过程中，需要保证搜索过的字符不能再次被使用，这可以使用一个布尔数组来记录。同时，我们需要记录当前搜索的字符所在的位置，这可以用一个二元组（row, col）表示。
         * 在找到目标单词时，我们需要记录搜索路径上的所有位置，这可以用一个列表来保存。最后，我们将这些位置列表中的所有位置按照要求拼接成一个字符串并返回。
         */
        int n = 4;
        char[][] c = new char[][]{
                {'A', 'C', 'C', 'F'},
                {'C', 'D', 'E', 'D'},
                {'B', 'E', 'S', 'S'},
                {'F', 'E', 'C', 'A'}
        };
        String s = "ACCESS";
        solution(n, c, s);
    }

    private static void solution(int n, char[][] c, String s) {
        char[] arr = s.toCharArray();
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(c, i, j, k, s);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c[i][j]+",");
            }
            System.out.println();
        }
    }

    private static void dfs(char[][] c, int i, int j, int k, String s) {
        if (i < 0 || i >= c.length || j < 0 || j >= c.length || k >= s.length() || c[i][j] != s.charAt(k)) {
            return;
        }
        k++;
        c[i][j] = ' ';
        dfs(c, i - 1, j, k, s);
        dfs(c, i + 1, j, k, s);
        dfs(c, i, j - 1, k, s);
        dfs(c, i, j + 1, k, s);
    }
}