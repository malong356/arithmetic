package book1.chapter2;

/**
 * Created by malong on 2020-02-04.
 */
public class _006_环形单链表的约瑟夫问题 {
    /**
     * 约瑟夫环
     * 时间复杂度为 n * m 传统解法
     * @param head
     * @param m
     * @return
     */
    public static Node josephusKill1(Node head, int m){
        if(head == null || m < 1 || head.next == head){
            return head;
        }
        Node last = head;
        while (last.next != head){
            last = last.next;
        }
        int i = 0;
        while (head != last){
            if(++i == m){
                last.next = head.next;
                i = 0;
            }else {
                last = last.next;
            }
            head = head.next;

        }
        return head;
    }

    /**
     * 约瑟夫环
     * 时间复杂度为 O(n) 解法
     * @param head
     * @param m
     * @return
     */
    public static Node josephusKill2(Node head, int m){
        if(head == null || m < 1 || head.next == head) {
            return head;
        }
        Node cur = head;
        int n = 1;

        while (cur.next != head){
            n++;
            cur = cur.next;
        }
        int tmp = getLive(n, m);
        while (--tmp != 0){
            head = head.next;
        }
        head.next = head;
        return head;

    }

    private static int getLive(int n, int m){
        if(n == 1){
            return 1;
        }
        return (getLive(n - 1, m) + m - 1) % n + 1;
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
        node5.next = node1;

//        Node node = josephusKill1(node1, 3);
        Node node = josephusKill2(node1, 3);
        System.out.println("@@@" + node.value);
    }
}
