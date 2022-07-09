package binarySearchTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ��֤����������
 */
public class LC98 {

    /**
     * ����һ��
     *
     * ���һ���ݹ麯�� helper(root, lower, upper) ���ݹ��жϣ�������ʾ������ root Ϊ�����������ж����������нڵ��ֵ�Ƿ�
     * ���� (l,r) �ķ�Χ�ڣ�ע���ǿ����䣩����� root �ڵ��ֵ val ���� (l,r) �ķ�Χ��˵������������ֱ�ӷ��أ���������Ҫ��
     * ���ݹ���ü���������������Ƿ����㣬����������˵������һ�ö�����������
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) return true;

        if (root.val <= lower || root.val >= upper) return false;

        return isValidBST(root.left,lower,root.val) && isValidBST(root.right,root.val,upper);
    }

    /**
     * �������
     *
     * ��������������������Ľ��һ����һ����������
     */
    public boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        //��¼֮ǰ�������Ľڵ��ֵ
        double inorder = Long.MIN_VALUE;

        while (!stack.isEmpty() || curr != null){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if (curr.val <= inorder) return false;
            inorder = curr.val;
            curr = curr.right;
        }

        return true;
    }
}
