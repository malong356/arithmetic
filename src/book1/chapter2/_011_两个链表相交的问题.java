package book1.chapter2;

/**
 * Created by malong on 2020-02-07.
 */
public class _011_两个链表相交的问题 {

    public static Node getIntersectNode(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        // 1.判断链表是否有换 有返回进入环的点
        // 2.如果两个链表都没有环，判断相交
        // 3.如果两个链表都有环，判断相交
        return null;
    }

    /**
     * 判断链表是否有换 有返回第一个进入环的点
     * @param head
     * @return
     */
    public static Node getLoopNode(Node head){
        // 快慢指针 fast与show
        // 一旦fast到达终点 说明无环
        // 如果有环，fast与show一定会在换上相遇
        // fast指针重新回到head位置，从原来的移动两步到移动一步
        // fast与show再次相遇，即是第一个进环点
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node show = head.next;
        Node fast = head.next.next;
        while (show != fast){
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            show = show.next;
            fast = fast.next.next;
        }
        fast = head;
        while (show != fast){
            fast = fast.next;
            show = show.next;
        }
        return show;
    }

    /**
     * 无环 判断相交
     * @param head1
     * @param head2
     * @return
     */
    public static Node noLoop(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        int n = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1.next != null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0){
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 有环
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            // 在进环前相交
            int n = 0;
            cur1 = head1;
            cur2 = head2;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            // 进环后可能相交
            cur1 = loop1.next;
            while (cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
