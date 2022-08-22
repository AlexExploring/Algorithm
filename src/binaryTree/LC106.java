package binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树,题目保证无重复元素(相关题目：LC105)
 */
public class LC106 {

    public static void main(String[] args) {
        int [] inorder = {9,3,15,20,7};
        int [] postorder = {9,15,7,20,3};
        new LC106().buildTree(inorder,postorder);
    }

    private int[] postorder;
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        this.postorder = postorder;
        this.indexMap = new HashMap<>();

        // 建立（元素，下标）键值对的哈希表
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i],i);
        }

        return recursion(0, len - 1,0,len - 1);
    }

    public TreeNode recursion(int inLeft, int inRight,int postLeft,int postRight) {
        if (postLeft > postRight) return null;

        // 建立根节点 后序遍历中的最后一个节点就是根节点
        TreeNode root = new TreeNode(postorder[postRight]);
        // 在中序遍历中定位根节点
        int inRoot = indexMap.get(postorder[postRight]);
        // 得到左子树中的节点数目
        int leftSize = inRoot - inLeft;

        root.left = recursion(inLeft,inRoot - 1,
                postLeft,postLeft + leftSize - 1);
        root.right = recursion(inRoot + 1,inRight,
                postLeft + leftSize,postRight - 1);

        return root;
    }
}