package book1.chapter2;

/**
 * Created by malong on 2020-02-04.
 */
public class _007_判断一个链表是否是回文结构 {

    /**
     * 回文结构
     * 1 -> 2 -> 2 -> 1
     * 1 -> 2 -> 3 -> 2 -> 1
     * 快慢指针
     * 1）找到中间点
     * 2）反转后半部分 1 -> 2 -> 3(.next = null) <- 2 <- 1
     * 3）比较
     * 4）恢复链表成原来的结构
     * 5）返回
     * @param head
     * @return
     */
    public static boolean isPalindrome3(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node mid = head;
        Node last = head;
        while (last.next != null && last.next.next != null){
            mid = mid.next;
            last = last.next.next;
        }
        //mid 为中间节点 后边的节点反转
        Node h = mid.next;
        mid.next = null;

        Node pre = null;
        Node next = null;
        while (h != null){
            next = h.next;
            h.next = pre;
            pre = h;
            h = next;
        }
        Node h1 = head;
        Node h2 = pre;

        while (h1 != null && h2 != null){
            if(h1.value != h2.value){
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }

        h = pre;
        pre = null;
        next = null;
        while (h != null){
            next = h.next;
            h.next = pre;
            pre = h;
            h = next;
        }
        mid.next = pre;
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        boolean palindrome3 = isPalindrome3(node1);
        Node node = node1;
        while (node != null){
            Thread.sleep(1000);
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println("@@@" + palindrome3);
    }
}
