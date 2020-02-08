package book1.chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by malong on 2020-02-08.
 */
public class _013_删除无序单链表中值重复出现的节点 {

    /**
     * 方法一：借助哈希表 时间复杂度O(n) 空间复杂度O(N)
     * @param head
     * @return
     */
    public static void removeReq1(Node head){
        if(head == null){
            return;
        }
        Set<Integer> set = new HashSet<>();
        Node pre = null;
        Node cur = head;
        Node next = null;
        while (cur != null){
            next = cur.next;
            int value = cur.value;
            if(set.contains(value)){
                pre.next = next;
            }else {
                set.add(value);
            }
            pre = cur;
            cur = next;
        }
    }

    /**
     * 方法二：不借助辅助空间 类似选择排序，时间复杂度O(n*n)
     * @param head
     */
    public static void removeReq2(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null){
            pre = cur;
            next = cur.next;
            while (next != null){
                if(next.value == cur.value){
                    pre.next = next.next;
                }else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }
}
