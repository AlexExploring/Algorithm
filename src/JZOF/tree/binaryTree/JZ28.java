package JZOF.tree.binaryTree;

/**
 * ¶Ô³ÆµÄ¶þ²æÊ÷
 */
public class JZ28 {
    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;

        return (p.val==q.val) && (isMirror(p.left,q.right)) && ((isMirror(p.right,q.left)));
    }


    public boolean isSymmetric2(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

}
