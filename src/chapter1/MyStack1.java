package chapter1;

import java.util.Objects;
import java.util.Stack;

/**
 * 设计一个有getMin功能的栈1
 * Created by malong on 2019-12-27.
 */
public class MyStack1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(){
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(Integer value){
        stackData.push(value);
        if(stackMin.empty()){
            stackMin.push(value);
        }else if(value <= this.getMin()){
            stackMin.push(value);
        }
    }

    public Integer pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Stack is empty!");
        }
        Integer value = stackData.pop();
        if(Objects.equals(getMin(), value)){
            stackMin.pop();
        }
        return value;
    }

    public Integer getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Stack is empty!");
        }
        return stackMin.peek();
    }
}
