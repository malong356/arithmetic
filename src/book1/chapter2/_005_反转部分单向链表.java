package book1.chapter2;

/**
 * Created by malong on 2020-02-03.
 */
public class _005_反转部分单向链表 {

    public static Node reversePart(Node head, int from, int to){
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while (node1 != null){
            len++;
            if(len == from - 1){
                fPre = node1;
            }
            if(len == to + 1){
                tPos = node1;
            }
            node1 = node1.next;
        }
        if(from < 1 || from > to || to > len){
            return head;
        }
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if(fPre != null){
            fPre.next = node1;
            return head;
        }
        return node1;

    }
}
