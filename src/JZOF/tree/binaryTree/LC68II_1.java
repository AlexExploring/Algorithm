package JZOF.tree.binaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC68II_1 {
    public static void main(String[] args) {

    }

    //会先一直递归找到p或q，然后将结果一层一层的返回。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        //l、r 非空时，说明 p、q 分居 root 的两侧，root 就是 LCA
        //l、r 任一为空，说明 LCA 位于另一子树或其祖先中
        //最近的公共祖先被找到后，会被left或者right带到上一层，最终被返回
        return l == null ? r : (r == null ? l : root);
    }




    // 用map存储所有节点的父节点之后，
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);  //这里直到找到根节点 root 它的父节点为nul
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;  //从底向上找到的第一个公共节点就是最近的公共祖先。。。
            }
            q = parent.get(q.val);
        }
        return null;
    }

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    //直接存储所有节点的父节点
    // parent.put(父节点的左节点或右节点的值,父节点)
    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
