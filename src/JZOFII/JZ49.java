package JZOFII;

/**
 *  从根节点到叶节点的路径数字之和
 */
public class JZ49 {

    public int sumNumbers(TreeNode root) {
        rec(root,0);
        return ans;
    }

    private int ans = 0;

    public void rec(TreeNode root,int preVal) {

        if (root.left != null) {
            rec(root.left,(preVal*10)+root.val);
        }

        if (root.right != null) {
            rec(root.right,(preVal*10)+root.val);
        }

        if (root.left == null && root.right == null) {
            ans += ((preVal*10)+root.val);
        }
    }

    public int sumNumbers1(TreeNode root) {
        return dfs(root,0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) return 0;

        int sum = prevSum*10 + root.val;
        if (root.left == null && root.right == null){
            return sum;
        }else {
            return dfs(root.left,sum) + dfs(root.right,sum);
        }
    }
}