package book1.chapter2;

/**
 * Created by malong on 2020-02-02.
 */
public class _002_在单链表和双链表中删除倒数第K个节点 {

    /**
     * 单链表
     * @param head
     * @param lastK
     * @return
     */
    public Node removeLastK(Node head, int lastK){
        if(head == null || lastK < 1){
            return head;
        }
        Node cur = head;
        while (cur != null){
            lastK--;
            cur = cur.next;
        }
        if(lastK == 0){
            return head.next;
        }
        if(lastK < 0){
            cur = head;
            while (++lastK != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        // lastK > 0的情况 不需要删除 直接返回
        return head;
    }

    /**
     * 双链表
     * @param head
     * @param lastK
     * @return
     */
    public DubboNode removeLastK(DubboNode head, int lastK){
        if(head == null || lastK < 1){
            return head;
        }
        DubboNode cur = head;
        while (cur != null){
            lastK--;
            cur = cur.next;
        }
        if(lastK == 0){
            return head.next;
        }
        if(lastK < 0){
            cur = head;
            while (++lastK != 0){
                cur = cur.next;
            }
            DubboNode newNode = cur.next.next;
            cur.next = newNode;
            if(newNode != null) {
                newNode.pre = cur;
            }
        }
        // lastK > 0的情况 不需要删除 直接返回
        return head;
    }
}
