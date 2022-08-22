package binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树 (相关题目：LC105)
 */
public class LC106 {

    public static void main(String[] args) {
        int [] inorder = {9,3,15,20,7};
        int [] postorder = {9,15,7,20,3};
        new LC106().buildTree(inorder,postorder);
    }

    int post_index;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> index_map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_index = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        for (int i = 0; i < len; i++) {
            index_map.put(inorder[i],i);
        }

        return recursion(0, len - 1);
    }

    public TreeNode recursion(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) return null;

        // 选择 post_index 位置的元素作为当前子树根节点
        int rootVal = postorder[post_index];
        // 根据 root_val 在inorder中所在位置分成左右两棵子树
        int in_root = index_map.get(rootVal);
        // 把根节点建立出来
        TreeNode root = new TreeNode(rootVal);

        // 下标减一
        post_index--;
        // 构造左子树
        root.left = recursion(in_left, in_root - 1);
        // 构造右子树
        root.right = recursion(in_root + 1, in_right);

        return root;
    }
}

