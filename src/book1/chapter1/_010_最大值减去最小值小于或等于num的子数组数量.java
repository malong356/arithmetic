package book1.chapter1;

import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组数量
 * 时间复杂度为O(N)
 * Created by malong on 2020-02-02.
 */
public class _010_最大值减去最小值小于或等于num的子数组数量 {
    /**
     * 双端队列实现
     * qmin qmax存储数组位子信息
     */
    public static int getNum(int[] arr, int num){
        if(arr == null || arr.length == 0 || num < 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length){
            while (j < arr.length){
                if (qmin.isEmpty() || qmin.peekLast() != j){
                    while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                        qmin.pollLast();
                    }
                    qmin.addLast(j);
                    while (!qmax.isEmpty() || arr[qmin.peekLast()] <= arr[j]){
                        qmax.pollLast();
                    }
                    qmax.addLast(j);
                }
                if(arr[qmax.getFirst()] - arr[qmin.getFirst()] > num){
                    break;
                }
                j++;
            }
            res += j - i;
            if(qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            if(qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            i++;
        }
        return res;
    }
}
