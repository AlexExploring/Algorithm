package binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍III
 */
public class LC337 {

    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();

    /**
     * 我们可以用 f(o) 表示选择 o 节点的情况下，o 节点的子树上被选择的节点的最大权值和；
     * g(o) 表示不选择 o 节点的情况下，o节点的子树上被选择的节点的最大权值和；l 和 r 代
     * 表 o 的左右孩子。
     */
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        //选择了当前节点，就不能选和当前节点直接相连的子节点
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        //不选择当前节点，选左子节点或不选左子节点 和 选右子节点或不选右子节点 中的最大值
        g.put(root,
                Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0))
                        + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
    }

    /**
     * 空间复杂度优化：
     * 思路：我们发现无论是 f(o) 还是 g(o)，他们最终的值只和f(l)、g(l)、f(r)、g(r)
     * 有关，所以对于每个节点，我们只关心它的孩子节点们的 f 和 g 是多少。我们可以设
     * 计一个结构，表示某个节点的 f 和 g 值，在每次递归返回的时候，都把这个点对应的
     * f 和 g 返回给上一级调用，这样可以省去哈希表的空间。
     */
    public int rob1(TreeNode root) {
        int[] rootStatus = dfs1(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs1(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] l = dfs1(root.left);
        int[] r = dfs1(root.right);
        int selected = root.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}
