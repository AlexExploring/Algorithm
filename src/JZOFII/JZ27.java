package JZOFII;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * »ØÎÄÁ´±í
 */
public class JZ27 {

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int i = 0,j = list.size()-1;
        while (i<j) {
            if (list.get(i)==list.get(j)){
                i++;j--;
            }else return false;
        }
        return true;
    }
}
