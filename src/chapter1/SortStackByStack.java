package chapter1;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 * Created by malong on 2019-12-28.
 */
public class SortStackByStack {

    public static Stack<Integer> sortByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while (!stack.empty()) {
            Integer value = stack.pop();
            if (help.empty() || value <= help.peek()) {
                help.push(value);
            } else {
                while (!help.empty() && value > help.peek()) {
                    stack.push(help.pop());
                }
                help.push(value);
            }
        }
        return help;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(1);
        Stack<Integer> stack1 = sortByStack(stack);
        System.out.println(stack1.toString());
        while (!stack1.empty()){
            System.out.println(stack1.pop());
        }
    }
}
