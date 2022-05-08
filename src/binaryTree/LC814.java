package binaryTree;

/**
 * ��������֦
 */
public class LC814 {

    public TreeNode pruneTree(TreeNode root) {
        return recur(root) ? root : null;
    }

    /**
     * �ж���root�ڵ�Ϊ���ڵ�������Ƿ����1
     */
    public boolean recur(TreeNode root) {
        // �߽�������root Ϊ null ����false
        if (root == null) return false;
        boolean left = recur(root.left);
        boolean right = recur(root.right);
        if (!left) root.left = null;
        if (!right) root.right = null;

        return root.val == 1 || left || right;
    }

    /**
     * �Ե����ϵ��𲽼�֦
     */
    public TreeNode pruneTree1(TreeNode root) {
        if (root == null) return null;

        // ���޼���������
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // ��ǰ�ڵ�ֵΪ0������Ҷ�ӽڵ㣬����Ҫ�޼�
        if (root.val == 0 && root.left == null && root.right == null)
            return null;

        return root;
    }
}
