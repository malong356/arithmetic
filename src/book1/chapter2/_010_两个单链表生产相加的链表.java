package book1.chapter2;

/**
 * Created by malong on 2020-02-06.
 */
public class _010_两个单链表生产相加的链表 {

    public static Node addNode(Node head1, Node head2){
        // 反转链表
        head1 = reverseNode(head1);
        head2 = reverseNode(head2);
        // 两数相加
        Node add = add(head1, head2);
        // 反转链表
        return reverseNode(add);
    }

    public static Node reverseNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node add(Node head1, Node head2){
        Node root = new Node(0);
        int point = 0;
        while (head1 != null || head2 != null || point != 0){
            int v1 = head1 != null ? head1.value : 0;
            int v2 = head2 != null ? head2.value : 0;
            int value = v1 + v2 +point;
            point = value / 10;
            root.next = new Node(value % 10);
            root = root.next;
            if(head1 != null){
                head1 = head1.next;
            }
            if(head2 != null){
                head2 = head2.next;
            }
        }
        return root.next;
    }
}
