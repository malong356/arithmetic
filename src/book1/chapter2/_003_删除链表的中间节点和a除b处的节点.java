package book1.chapter2;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by malong on 2020-02-02.
 */
public class _003_删除链表的中间节点和a除b处的节点 {

    /**
     * 删除中间节点
     * 快慢指针
     * @param head
     * @return
     */
    public static Node removeMidNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        if(head.next.next == null){
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null){
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    /**
     * 删除a/b处的节点
     * @param head
     * @param a
     * @param b
     * @return
     */
    public static Node removeByRatio(Node head, int a, int b){
        if(a < 1 || a > b){
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null){
            n++;
            cur = cur.next;
        }
        n = BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(n)).divide(BigDecimal.valueOf(b), 0, RoundingMode.UP).intValue();
        if(n == 1){
            return head.next;
        }
        if( n > 1){
            cur = head;
            while (--n != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
