package LinkedList;

/**
 * 排序链表
 */
public class LC148 {

    /**
     * 自顶向下的归并排序
     *
     * 时间复杂度：O(nlogn)，其中 n 是链表的长度。
     * 空间复杂度：O(logn)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间。。
     */
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        //节点为空
        if (head == null) {
            return null;
        }
        //只有一个节点
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        //查找链表的中点
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;

        //递归左边部分，不包括mid
        ListNode list1 = sortList(head, mid);
        //递归右边部分，不包括tail
        ListNode list2 = sortList(mid, tail);
        //合并两个有序的链表为一个更长的有序链表
        ListNode sorted = mergeTwoLists(list1, list2);

        return sorted;
    }

    public ListNode sortList1(ListNode head) {
        //链表节点个数小于等于1，终止
        if (head == null || head.next == null)
            return head;
        //使用快慢指针查找链表的中点,这里fast必须指向head.next(
        // 如果fast和head均指向head的话，那么对于长度为2的链表，经
        // 快慢指针操作后，实际上被划分为了两个长度分别为(2,0)的链表
        // 将处于无限循环)
        //或者，创建一个dummyHead使得，dummyHead.next = head;
        //然后 fast和head均指向dummyHead;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = slow.next;

        //断开head和head1
        slow.next = null;

        //递归
        ListNode left = sortList(head);
        ListNode right = sortList(head1);

        ListNode merged = mergeTwoLists(left, right);

        return merged;
    }

    /**
     * 自底向上的归并排序
     *
     * 复杂度分析：
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    public ListNode sortList2(ListNode head) {
        if (head == null) return null;

        //获取链表的长度
        int length = 0;
        ListNode node = head;
        while (node!=null) {
            length++;
            node= node.next;
        }

        ListNode dummyHead = new ListNode(0, head);

        // 归并部分,当subLength >= length 时，说明整个链表排序完成
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

                //合并两个有序链表为一个更长的有序链表
                ListNode merged = mergeTwoLists(head1, head2);
                //连接已经部分有序的链表
                prev.next = merged;
                //为下一次连接做准备
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
