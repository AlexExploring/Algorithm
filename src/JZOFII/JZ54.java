package JZOFII;

/**
 *  所有大于等于节点的值之和
 */
public class JZ54 {
    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    int num = 0;

    public void inOrder(TreeNode root){
        if (root==null) return;
        inOrder(root.right);
        root.val+=num;
        num = root.val;
        inOrder(root.left);
    }
}
