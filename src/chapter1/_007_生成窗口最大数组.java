package chapter1;

import java.util.LinkedList;

/**
 * 生成窗口最大数组
 * 例如数组 [4,3,5,4,3,3,6,7]
 * Created by malong on 2019-12-29.
 */
public class _007_生成窗口最大数组 {

    public static int[] getMaxWindow(int[] arrs, int w){
        if(arrs == null || w < 1 || arrs.length < w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arrs.length - w + 1];
        for(int i = 0 ; i < arrs.length ; i ++){
            while (!qmax.isEmpty() && arrs[qmax.peekLast()] <= arrs[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() < i - w + 1){
                qmax.pollFirst();
            }
            if(i >= w - 1) {
                res[i - w + 1] = arrs[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arrs = {4,3,5,4,3,3,6,7};
        int[] maxWindow = getMaxWindow(arrs, 3);
        for (int i = 0; i < maxWindow.length; i++) {
            System.out.println(maxWindow[i]);
        }

    }
}
