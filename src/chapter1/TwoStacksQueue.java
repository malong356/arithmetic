package chapter1;

import java.util.Stack;

/**
 * 由两个栈组成队列
 * Created by malong on 2019-12-27.
 */
public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    private void pushToPop(){
        if(stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }
    public void add(Integer value){
        stackPush.push(value);
        pushToPop();
    }
    public Integer poll(){
        pushToPop();
        if(stackPop.isEmpty()){
            throw new RuntimeException("Queue is Empty!");
        }
        return stackPop.pop();
    }

    public Integer peek(){
        pushToPop();
        if(stackPop.isEmpty()){
            throw new RuntimeException("Queue is Empty!");
        }
        return stackPop.peek();
    }
}
