package binaryTree;


/**
 * 相同的树
 */
public class LC100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null) return true;
        // p!=null && q!=null && p.val == q.val 判断一个节点
        // (isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right)) 递归判断左右子树的每一个节点
        else return p!=null && q!=null && p.val == q.val && (isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right));
    }

}
