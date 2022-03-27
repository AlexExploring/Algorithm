package JZOFII;

/**
 * ��������֦
 */
public class JZ47 {
    public TreeNode pruneTree(TreeNode root) {
        return rec(root) ? root : null;
    }

    /**
     * �ж���root�ڵ�Ϊ���ڵ�������Ƿ����1
     */
    public boolean rec(TreeNode root) {
        if (root == null) return false;
        boolean left = rec(root.left);
        boolean right = rec(root.right);
        if (!left) root.left = null;
        if (!right) root.right = null;

        return root.val == 1 || left || right;
    }

    public TreeNode pruneTree1(TreeNode root) {
        if (root == null)
            return null;

        // ���޼���������
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // ��ǰ�ڵ�ֵΪ0������Ҷ�ӽڵ㣬����Ҫ�޼�
        if (root.val == 0 && root.left == null && root.right == null)
            return null;

        return root;
    }
}
