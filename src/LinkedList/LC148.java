package LinkedList;

/**
 * 排序链表
 */

/**
 * 排序链表
 */
public class LC148 {

    /**
     * 自顶向下的归并排序
     *
     * 时间复杂度：O(n \log n)O(nlogn)，其中 nn 是链表的长度。
     * 空间复杂度：O(\log n)O(logn)，其中 nn 是链表的长度。空间复杂度主要取决于递归调用的栈空间。。
     */
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        //节点为空
        if (head == null) {
            return head;
        }
        //只有一个节点
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = mergeTwoLists(list1, list2);
        return sorted;
    }

    /**
     * 自底向上的归并排序
     */
    public ListNode sortList1(ListNode head) {
        if (head == null) return null;

        //获取链表的长度
        int length = 0;
        ListNode node = head;
        while (node!=null) {
            length++;
            node= node.next;
        }

        ListNode dummyHead = new ListNode(0, head);

        // 归并部分
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;//curr 指向当前归并部分的第一个节点
            while (curr != null) {
                //一组归并操作中的第一部分
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next!=null; i++) {
                    curr = curr.next;
                }

                //一组归并操作种的第二部分
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr!=null && curr.next!=null; i++) {
                    curr = curr.next;
                }

                //处理curr 为下一组归并操作做准备
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }

                ListNode merged = mergeTwoLists(head1, head2);
                prev.next = merged;
                while (prev.next != null){
                    prev = prev.next;
                }

                //将curr指向下一次需要归并的部分
                curr = next;
            }
        }

        return dummyHead.next;
    }

    /**
     * 合并两个有序链表为一个新的有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0),tail = head;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 != null ? l1 : l2;

        return head.next;
    }
}
