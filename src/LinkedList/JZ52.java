package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 *两个链表的第一个公共节点
 */
public class JZ52 {

    //双指针
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        ListNode node1 = headA,node2 = headB;

        while (node1!=node2){
            if (node1!=null) node1 = node1.next;
            else node1 = headB;

            if (node2!=null) node2 = node2.next;
            else node2 = headA;
        }

        return node1;
    }

    //hash
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        Set<ListNode> hashSet = new HashSet<>();

        ListNode curNode = headA;
        while (curNode != null) {
            hashSet.add(curNode);
            curNode = curNode.next;
        }

        curNode = headB;
        while (curNode != null) {
            if(hashSet.contains(curNode)){
                return curNode;
            }
            curNode = curNode.next;
        }
        return null;

    }

    //统计步长
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        int len_a = 0,len_b = 0;
        ListNode flag_a = headA,flag_b = headB;
        while (flag_a!=null){
            len_a++;
            flag_a = flag_a.next;
        }
        while (flag_b!=null){
            len_b++;
            flag_b = flag_b.next;
        }

        if (headA==headB) return headA;  //排除开始就相等，即两个链表实际上都只有一个节点，且这个节点是同一个

        int step = Math.abs(len_a-len_b);
        flag_a = headA;flag_b = headB;

        if (len_a>len_b){
            while (step!=0){
                flag_a = flag_a.next;
                step--;
            }
        }else if (len_a<len_b){
            while (step!=0){
                flag_b = flag_b.next;
                step--;
            }
        }

        while (flag_a!=null&&flag_b!=null){
            if (flag_a==flag_b){
                return flag_a;
            }else {
                flag_a = flag_a.next;
                flag_b = flag_b.next;
            }
        }

        return null;
    }
}
