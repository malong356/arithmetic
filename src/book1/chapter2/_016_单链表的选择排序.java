package book1.chapter2;

/**
 * Created by malong on 2020-02-08.
 */
public class _016_单链表的选择排序 {

    public static Node selectionSort(Node head){
        Node cur = head;
        Node newHead = null;
        Node small = null;
        Node smallPre = null;
        Node tail = null;
        while (cur != null){
            small = cur;
            smallPre = getSmallPreNode(cur);
            if(smallPre != null){
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if(newHead == null){
                newHead = small;
            }else {
                tail.next = small;
            }
            tail = small;
        }
        return newHead;
    }

    public static Node getSmallPreNode(Node head){
        Node small = head;
        Node smallPre = null;
        Node cur = head;
        Node next = null;
        while (cur.next != null){
            next = cur.next;
            if(next.value < small.value){
                small = next;
                smallPre = cur;
            }
            cur = next;
        }
        return smallPre;
    }
}
