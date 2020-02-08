package book1.chapter2;

/**
 * Created by malong on 2020-02-08.
 */
public class _018_向有序的环形单链表中插入新节点 {

    public static Node insertNum(Node head, int num){
        Node node = new Node(num);
        if(head == null){
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head){
            if(num >= pre.value && num <= cur.value){
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return num < head.value ? node : head;
    }
}
