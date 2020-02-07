package book1.chapter2;

/**
 * 将单向链表按某个值划分成左边小、中间相等、右边大的形式
 * Created by malong on 2020-02-04.
 */
public class _008_将单向链表按某个值划分 {
    /**
     * 解法一 数组 改版快排
     * 解法二 分成三段链表（小的一段 相等的一段 右边的一段） 然后在连起来
     */
    public static Node listPartition2(Node head, int pivot){
        Node sh = null; // 小的头
        Node st = null; // 小的尾
        Node eh = null; // 相等的头
        Node et = null; // 相等的尾
        Node bh = null; // 大的头
        Node bt = null; // 大的尾
        Node next = null;
        //分成三段链表
        while (head != null){
            next = head.next;
            head.next = null;
            if(head.value < pivot){
                if(sh == null){
                    sh = head;
                    st = head;
                }else {
                    st.next = head;
                    st = head;
                }
            }else if(head.value == pivot){
                if(eh == null){
                    eh = head;
                    et = head;
                }else {
                    et.next = head;
                    et = head;
                }
            }else {
                if(bh == null){
                    bh = head;
                    bt = head;
                }else {
                    bt.next = head;
                    bt = head;
                }
            }
            head = next;
        }
        // 小的和相等的重新连接
        if(st != null){
            st.next = eh;
            et = et == null ? st : et;
        }
        // 所有的重新连接
        if(et != null){
            et.next = bh;
        }

        return sh != null ? sh : eh != null ? eh : bh;
    }
}
