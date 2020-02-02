package book1.chapter2;

/**
 * Created by malong on 2020-02-02.
 */
public class _001_打印两个有序链表的公共部分 {

    public static void printCommonPart(Node n1, Node n2){

        while (n1 != null && n2 != null){
            if(n1.value == n2.value){
                System.out.println(n1.value);
                n1 = n1.next;
                n2 = n2.next;
            }else if(n1.value > n2.value){
                n2 = n2.next;
            }else {
                n1 = n1.next;
            }
        }
    }
}
