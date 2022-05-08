package binaryTree;

/**
 * 求根节点到叶节点数字之和
 *
 * 类似题目 LC129，LC437
 */
public class LC129 {

    public int sumNumbers(TreeNode root) {
        rec(root,0);
        return ans;
    }

    private int ans = 0;

    /**
     * @param preVal 记录到父节点生成的数字
     */
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

    public int dfs(TreeNode root, int preVal) {
        if (root == null) return 0;

        int sum = preVal*10 + root.val;
        if (root.left == null && root.right == null){
            return sum;
        }else {
            return dfs(root.left,sum) + dfs(root.right,sum);
        }
    }
}
