package leecodeHot100;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 */
public class _060Exist {

    /**
     * 这道题可以使用回溯算法来解决。回溯算法通过递归地尝试不同的选择，来寻找问题的解。
     * 具体思路如下：
     * 1. 首先遍历二维字符网格board，找到与单词word的第一个字符相等的起始位置。
     * 2. 对于每个起始位置，使用回溯算法来搜索是否存在符合要求的路径。
     * 3. 在回溯算法中，首先判断当前位置是否越界，或者当前位置的字符与单词中对应位置的字符不相等，如果是，则返回false。
     * 4. 如果当前位置的字符与单词中对应位置的字符相等，标记当前位置已访问，然后递归地搜索当前位置的上、下、左、右四个相邻位置。
     * 5. 在递归中，如果已经匹配到了单词的最后一个字符，说明找到了一条符合要求的路径，返回true。
     * 6. 如果在当前位置的上、下、左、右四个相邻位置中找到了符合要求的路径，返回true。
     * 7. 如果在当前位置的上、下、左、右四个相邻位置中没有找到符合要求的路径，回溯到上一层，将当前位置标记为未访问，继续搜索其他路径。
     * 8. 如果遍历完所有起始位置都没有找到符合要求的路径，返回false。
     * 以下是使用Java语言实现的代码：
     */
    public boolean exist(char[][] board, String word) {
        int m= board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(searchWord(board,word,visited,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board,String word,boolean[][] visited,int i,int j,int index){
        if(index == word.length()){
            return true;
        }

        if(i<0||i>=board.length||j<0||j>=board[0].length||visited[i][j]||board[i][j]!=word.charAt(index)){
            return false;
        }
        visited[i][j] = true;
        boolean found = searchWord(board,word,visited,i+1,j,index+1)
                || searchWord(board,word,visited,i-1,j,index+1)
                || searchWord(board,word,visited,i,j+1,index+1)
                || searchWord(board,word,visited,i,j-1,index+1);

        visited[i][j] = false;

        return found;
    }
}
