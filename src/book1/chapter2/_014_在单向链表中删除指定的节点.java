package book1.chapter2;

/**
 * Created by malong on 2020-02-08.
 */
public class _014_在单向链表中删除指定的节点 {

    public static Node removeValue(Node head, int num){
        if(head == null){
            return null;
        }
        Node pre = null;
        Node cur = head;
        while (cur != null){
            if(cur.value == num) {
                if (pre != null) {
                    pre.next = cur.next;
                    cur = cur.next;
                } else if(head.next != null){
                    head = head.next;
                    cur = head;
                } else {
                    return null;
                }
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
