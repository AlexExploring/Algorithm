package binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树  (相关题目：LC106)
 */
public class LC105 {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        new LC105().buildTree(preorder,inorder);

    }

    private int [] preorder;
    private int [] inorder;
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        this.preorder = preorder;
        this.inorder = preorder;

        // 从中序构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }

        return recursion(0, len - 1, 0, len - 1);
    }

    /**
     * 核心在于通过前序遍历的顺序先确定根节点，再计算左子树的大小，递归的建立左子树和右子树
     */
    public TreeNode recursion(int pre_left, int pre_right, int in_left, int in_right) {

        if (pre_left > pre_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int pre_root = pre_left;
        // 在中序遍历中定位根节点
        int in_root = indexMap.get(preorder[pre_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[pre_root]);
        // 得到左子树中的节点数目
        int left_size = in_root - in_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 left_size」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = recursion(pre_left + 1, pre_left + left_size, in_left, in_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = recursion(pre_left + left_size + 1, pre_right, in_root + 1, in_right);

        return root;
    }
}
