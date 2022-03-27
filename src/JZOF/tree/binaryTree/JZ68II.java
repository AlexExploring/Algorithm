package JZOF.tree.binaryTree;


/**
 *二叉树的最近公共祖先
 */
public class JZ68II {
    public static void main(String[] args) {

    }

    public TreeNode ans;

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;  //递归出口
        boolean lson = dfs(root.left, p, q);  // 左子树中是否含有p或者q
        boolean rson = dfs(root.right, p, q); // 右子树中是否含有p或者q
        //(lson && rson) 表示右子树和左子树均包含p节点或去节点，如果左子树包含的是p节点，那么右子树只能包含q节点，反之亦然。
        // 考虑了p或者q恰好是root节点，
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root; //不断更新ans ，因为最新找到的一定是相比之前更近的公共祖先
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       dfs(root,p,q);
       return ans;
    }

    // 如果树中某一子树同时含有 p和q，则该子树的根节点就是p和q的最近公共祖先。。。
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        //l、r 非空时，说明 p、q 分居 root 的两侧，root 就是 LCA
        //l、r 任一为空，说明 LCA 位于另一子树或其祖先中
        return l == null ? r : (r == null ? l : root);
    }
}