package book1.chapter1;

import java.util.Stack;

/**
 * 由两个栈组成队列
 * Created by malong on 2019-12-27.
 */
public class _002_由两个栈组成的队列 {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public _002_由两个栈组成的队列(){
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
