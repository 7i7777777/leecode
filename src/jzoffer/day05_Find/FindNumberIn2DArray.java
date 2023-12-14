package jzoffer.day05_Find;

public class FindNumberIn2DArray {
    //在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    // 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    public boolean findNumberIn2DArray(int[][] matrix,int target){
        //法一：暴力求解
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int rows =matrix.length,colums=matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray_linear(int[][] matrix,int target){
        //法二:线性查找
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int rows=matrix.length,colums=matrix[0].length;
        int row=0,colum=colums-1;
        while(row<rows && colum>=0){
            if(target == matrix[row][colum]){
                return true;
            }else if(target<matrix[row][colum]){
                colum--;
            }else {
                row++;
            }
        }
        return false;
    }
}