package book1.chapter2;

/**
 * Created by malong on 2020-02-08.
 */
public class _020_按照左右半区的方式重新组合单链表 {

    public static void relocate(Node head){
        if(head == null || head.next == null){
            return;
        }
        Node mid = head;
        Node cur = head.next;
        while (cur.next != null && cur.next.next != null){
            mid = mid.next;
            cur = cur.next.next;
        }
        cur = mid.next;
        mid.next = null;
        mergeLR(head, cur);
    }

    public static void mergeLR(Node left, Node right){
        Node next = null;
        Node rightNext = null;
        while (left.next != null){
            next = left.next;
            rightNext = right.next;
            right.next = next;
            left.next = right;
            left = next;
            right = rightNext;
        }
        left.next = right;
    }

    public static void main(String[] args) throws InterruptedException {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node1;

//        Node node = josephusKill1(node1, 3);
        relocate(node1);
        Node cur = node1;
        while (cur != null ) {
            System.out.println("@@@" + cur.value);
            cur = cur.next;
        }
    }
}
