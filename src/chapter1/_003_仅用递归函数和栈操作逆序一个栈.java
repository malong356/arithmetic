package chapter1;

import java.util.Stack;

/**
 * 仅用递归函数和栈操作逆序一个栈
 * Created by malong on 2019-12-27.
 */
public class _003_仅用递归函数和栈操作逆序一个栈 {

    public static Integer getAndRemoveLastElement(Stack<Integer> stack){
        Integer result = stack.pop();
        if(stack.empty()){
            return result;
        }
        Integer last = getAndRemoveLastElement(stack);
        stack.push(result);
        return last;
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        Integer i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);

        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
