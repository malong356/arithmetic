package book1.chapter2;

/**
 * Created by malong on 2020-02-08.
 */
public class _017_一种怪异的节点删除方式 {

    /**
     * 删除链表中的node节点
     * @param node
     */
    public static void removeNodeWired(Node node){
        if(node == null){
            return;
        }
        if(node.next == null){
            throw new RuntimeException("can not remove");
        }
        node.value = node.next.value;
        node.next = node.next.next;
    }
}
