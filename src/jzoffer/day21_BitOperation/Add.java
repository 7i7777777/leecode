package jzoffer.day21_BitOperation;

public class Add {
    //写一个函数，求两个整数之和，
    // 要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
    public int add(int a,int b){
        while(b!=0){ //当进位为0时跳出
            int c=(a&b)<<1; //c=进位
            a^=b; //a=非进位和
            b=c; //b=进位
        }
        return a;
    }
}
