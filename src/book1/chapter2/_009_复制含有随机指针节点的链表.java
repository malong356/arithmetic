package book1.chapter2;

/**
 * Created by malong on 2020-02-05.
 */
public class _009_复制含有随机指针节点的链表 {

    /**
     * 含有随机指针节点的链表
     */
    public static class Node{
        public int value;
        public Node next;
        public Node rand;
        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 复制
     */
    public static Node copy(Node head){
        // 原链表 1->2->3->null
        Node cur = head;
        Node next = null;
        // 1.原链表变为 1->1'->2->2'->3->3'->null
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        // 2.添加复制的节点rand指针
        cur = head;
        Node copyNode = null;
        while (cur != null){
            next = cur.next.next;
            copyNode = cur.next;
            copyNode.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        // 3.拆分
        Node result = head.next;
        cur = head;
        while (cur != null){
            next = cur.next.next;
            copyNode = cur.next;
            cur.next = next;
            copyNode.next = next != null ? next.next : null;
            cur = next;
        }
        return result;
    }
}
