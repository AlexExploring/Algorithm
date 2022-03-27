package Top100;

/**
 * ¥Úº“ΩŸ…·III
 */
public class LC337II {
    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[] {0,0};
        int [] l = dfs(root.left);
        int [] r = dfs(root.right);
        int selected = root.val + l[1]+r[1];
        int notSelected = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);
        return new int[] {selected,notSelected};
    }
}
