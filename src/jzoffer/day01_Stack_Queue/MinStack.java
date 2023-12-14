package jzoffer.day01_Stack_Queue;

import java.util.Stack;

public class MinStack {

    Stack<Integer> A,B;

    public MinStack(){
        A = new Stack<Integer>();
        B = new Stack<Integer>();
    }
    public void push(int x){
        A.push(x);
        if(B.isEmpty() || B.peek()>=x){
            B.push(x);
        }
    }
    public void pop(){
        if(A.pop().equals(B.peek())){
            B.pop();
        }
    }
    public int top(){
        return A.peek();
    }
    public int min(){
        return B.peek();
    }
}