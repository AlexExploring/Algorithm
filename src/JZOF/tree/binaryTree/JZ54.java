package JZOF.tree.binaryTree;


import java.util.ArrayList;

/**
 *给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class JZ54 {
    public static void main(String[] args) {

    }

    /**
     *求第k大的节点
     *
     * 中序遍历加有序数组
     */
    public int kthLargest1(TreeNode root, int k) {
        backTrack1(root);
        return list.get(list.size()-k);
    }

    static ArrayList<Integer> list = new ArrayList<>();

    public static void backTrack1(TreeNode root) {
        if (root!=null){
            backTrack1(root.left);
            list.add(root.val);
            backTrack1(root.right);
        }
    }


    public int kthLargest2(TreeNode root, int k) {
        backTrack2(root,k);
        return res;
    }

    int n_th = 0,res = 0;

    public void backTrack2(TreeNode root, int k) {
        if (root!=null&&n_th<=k){
            backTrack2(root.right,k);
            n_th++;
            if (n_th==k) res = root.val;
            backTrack2(root.left,k);
        }
    }
}
