package book1.chapter2;

/**
 * Created by malong on 2020-02-07.
 */
public class _012_将单链表的每K个节点之间逆序 {

    public Node reverseKNode(Node head, int k){
        if(head == null || head.next == null || k < 2){
            return head;
        }
        Node cur = head;
        int n = 1;
        Node start = null;
        Node pre = null;
        Node next = null;
        while (cur != null){
            next = cur.next;
            if(n == k){
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign(pre, start, cur, next);
                pre = start;
                n = 0;

            }
            cur = next;
            n++;
        }
        return head;
    }

    public void resign(Node left, Node start, Node end, Node right){
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while (cur != right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if(left != null){
            left.next = end;
        }
        start.next = right;
    }
}
