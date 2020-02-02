package book1.chapter1;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈2
 * Created by malong on 2019-12-27.
 */
public class _001_设计一个有getMin功能的栈2 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public _001_设计一个有getMin功能的栈2(){
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(Integer value){
        stackData.push(value);
        if(stackMin.empty()){
            stackMin.push(value);
        }else if(value <= this.getMin()){
            stackMin.push(value);
        }else {
            stackMin.push(getMin());
        }
    }

    public Integer pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Stack is empty!");
        }
        Integer value = stackData.pop();
        stackMin.pop();
        return value;
    }

    public Integer getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Stack is empty!");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        _001_设计一个有getMin功能的栈2 myStack = new _001_设计一个有getMin功能的栈2();
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.getMin());
        myStack.push(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(1);
        System.out.println(myStack.getMin());
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.getMin());


    }
}
