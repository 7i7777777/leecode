package jzoffer.day08_DynamicProgramming;

public class Fib {
    //递归法 （时间超时）
    public static int fib(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        return (fib(n-1)+fib(n-2));
    }
    //循环求余法
    public int fib1(int n){
        int a=0,b=1,sum;
        for(int i=0;i<n;i++){
            sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(fib(8));
    }
}