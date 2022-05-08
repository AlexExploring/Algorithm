package binaryTree;

import java.util.ArrayList;

/**
 *恢复二叉搜索树(BST)
 *
 * 很奇怪，
 */
public class LC99 {
    public static void main(String[] args) {

    }

    ArrayList<TreeNode> list = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        inOrder(root);
        //这里的方法可以被用来找一组有序的数中的两个被互换了顺序的值
        TreeNode x = null,y = null;
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).val> list.get(i+1).val){
                y = list.get(i+1);
                if (x == null){
                    x = list.get(i);
                }
            }
        }

        if (x!=null&&y!=null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    public void inOrder(TreeNode root){
        if (root != null){
            inOrder(root.left);
            list.add(root);
            inOrder(root.right);
        }
    }
}
