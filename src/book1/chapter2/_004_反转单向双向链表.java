package book1.chapter2;

/**
 * Created by malong on 2020-02-02.
 */
public class _004_反转单向双向链表 {

    /**
     * 反转单向链表
     * @param head
     * @return
     */
    public static Node reverseList(Node head){
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

    /**
     * 反转双向链表
     * @param head
     * @return
     */
    public static DubboNode reverseList(DubboNode head){
        DubboNode pre = null;
        DubboNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head.pre = next;
            head = next;
        }
        return pre;
    }
}
