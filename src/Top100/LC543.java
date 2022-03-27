package Top100;

public class LC543 {
    int max = 0;
    public int diameterOfBinaryTree1(TreeNode root) {
        if (root==null) return 0;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        int left = root.left==null ? 0: dfs(root.left)+1;
        int right = root.right==null ? 0 : dfs(root.right)+1;
        max = Math.max(max,(left+right));
        return Math.max(left,right);
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
         this.right = right;
     }
}
