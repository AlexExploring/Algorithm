package Top100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * �������������������
 *
 * ��Ŀ����������һ��������, �ҵ�����������ָ���ڵ������������ȡ�
 */
public class LC236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    /**
     * �洢���нڵ�ĸ��ڵ�
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while (p!=null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }

        while (q!=null) {
            if (visited.contains(q.val)) return q;
            q = parent.get(q.val);
        }
        return null;
    }

    /**
     * �����洢���˸��ڵ��������нڵ�ĸ��ڵ�
     */
    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }
}
