package JZOFII;

/**
 * ¶þ²æËÑË÷Ê÷µü´úÆ÷
 */
public class JZ55 {

}


class BSTIterator {

    private TreeNode dummyHead = new TreeNode(-1);
    private TreeNode pre = dummyHead;
    private TreeNode cursor;

    public BSTIterator(TreeNode root) {
        flatTree(root);
        cursor = dummyHead;
    }

    public int next() {
        int ans = cursor.right.val;
        cursor = cursor.right;
        return ans;
    }

    public boolean hasNext() {
        return cursor.right != null;
    }

    public void flatTree(TreeNode root) {
        if (root != null) {
            flatTree(root.left);
            pre.right = root;
            pre = root;
            root.left = null;
            flatTree(root.right);
        }
    }
}