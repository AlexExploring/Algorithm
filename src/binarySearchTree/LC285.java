package binarySearchTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * �����������е�������
 */
public class LC285 {

    /**
     * ��������������ҵ�Ŀ��ڵ�
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        boolean flag = false;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (flag) return curr;
            if (curr == p) flag = true;
            curr = curr.right;
        }
        return null;
    }

    /**
     * ������ĿֻҪ���ҳ�Ŀ��ڵ㣬���ݶ��������������ʣ��ҵ���һ����p�Ľڵ�ֵ��Ľڵ�
     */
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        // ��¼��ǰ�� p �ڵ��Ľڵ�
        TreeNode res = null;
        TreeNode curr = root;
        // �ڶ����������н�������
        while(curr != null){
            // �����ǰ�ڵ� > p������µ�ǰ�� p �ڵ��Ľڵ� res , ͬʱȥ��������������
            if(curr.val > p.val){
                res = curr;
                curr = curr.left;
            }else{// �����ǰ�ڵ� < p , ����������������
                curr = curr.right;
            }
        }
        // ����Ѱ������res ָ��ľ�������ı� p �ڵ��Ľڵ㡣
        return res;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}