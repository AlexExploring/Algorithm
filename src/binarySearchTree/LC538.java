package binarySearchTree;

/**
 * 把二叉搜索树转换为累加树
 *
 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 */

public class LC538 {

    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    int num = 0;

    /**
     * 改造的中序遍历，右中左
     */
    public void inOrder(TreeNode root){
        if (root != null) {
            inOrder(root.right);
            root.val+=num;
            num = root.val;
            inOrder(root.left);
        }
    }
}
