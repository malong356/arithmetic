package chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈结构
 * -- 栈中放的元素是数组的位置 栈内元素是严格的递增 或严格的递减
 * 找到每一个i位置左边和右边离i位置最近且值比arr[i]小的位置
 * Created by malong on 2019-12-29.
 */
public class _008_单调栈结构 {
    // 不重复的数组
    // arr = [3, 4, 1, 5, 6, 2, 7]
    public static int[][] getNearLessNoRepeat(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < arr.length; i++){
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                Integer pop = stack.pop();
                res[pop][0] = stack.isEmpty() ? -1 : stack.peek();
                res[pop][1] = i;
            }
            stack.push(i);
        }
        while(!stack.empty()){
            Integer pop = stack.pop();
            res[pop][0] = stack.isEmpty() ? -1 : stack.peek();
            res[pop][1] = -1;
        }
        return res;
    }

    // 可重复的数组
    // 例arr = [3, 1, 3, 4, 3, 5, 3, 2, 2]
    public static int[][] getNearLess(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for(int i = 0 ; i < arr.length; i++){
            while (!stack.isEmpty() && arr[i] < arr[stack.peek().get(0)]) {
                List<Integer> pops = stack.pop();
                // 取位于下面位置的列表中，最晚加入的那个
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for(Integer pop : pops) {
                    res[pop][0] = leftLessIndex;
                    res[pop][1] = i;
                }
            }
            if(!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]){
                stack.peek().add(i);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while(!stack.empty()){
            List<Integer> pops = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for(Integer pop : pops) {
                res[pop][0] = stack.isEmpty() ? -1 : leftLessIndex;
                res[pop][1] = -1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 6, 2, 7};
        int[][] nearLessNoRepeat = getNearLessNoRepeat(arr);
        for(int i = 0 ; i < nearLessNoRepeat.length; i++){
            System.out.println(nearLessNoRepeat[i][0] + " " + nearLessNoRepeat[i][1]);
        }
    }

}
