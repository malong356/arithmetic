package book1.chapter1;

import java.util.Stack;

/**
 * 求最大子矩阵的大小
 *
 * Created by malong  2020-01-01.
 */
public class _009_求最大子矩阵的大小 {

    public static int maxRexSize(int[][] map){
        if(map == null || map.length == 0 || map[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for(int i = 0; i < map.length ; i++){
            for(int j = 0 ; j < map[0].length; j++){
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }

        return maxArea;
    }

    private static int maxRecFromBottom(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < height.length ; i++){
            while (!stack.empty() && height[stack.peek()] >= height[i]){
                Integer pop = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - leftLessIndex - 1) * height[pop];
                maxArea = Math.max(curArea, maxArea);
            }
            stack.push(i);
        }
        while(!stack.empty()) {
            Integer pop = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - leftLessIndex - 1) * height[pop];
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;
    }
}
