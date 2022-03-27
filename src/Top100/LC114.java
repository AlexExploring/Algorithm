package Top100;

import java.util.*;

/**
 * ������չ��Ϊ����
 */
public class LC114 {

    /**
     * ����1
     */
    public void flatten(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<TreeNode> list = new LinkedList<>();

        //������ǰ����� ��-��-��
        while (!stack.isEmpty()||root!=null) {
            while (root!=null) {
                list.add(root);
                //System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.peek();
                stack.pop();
                root = root.right;
            }
        }

        if (list.size()>=1) {
            root = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                root.left = null;
                root.right = list.get(i);
                root = root.right;
            }
        }
    }

    /**
     * ����2
     */

    public void flatten1(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

}
