package binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树  (相关题目：LC106)
 */
public class LC105 {

    private int [] preorder;
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.indexMap = new HashMap<Integer, Integer>();
        int len = preorder.length;

        // 从中序构造哈希映射，帮助我们快速定位根节点
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }

        return recursion(0, len - 1, 0, len - 1);
    }

    /**
     * 核心在于通过前序遍历的顺序先确定根节点，再计算左子树的大小，递归的建立左子树和右子树
     */
    public TreeNode recursion(int preLeft, int preRight, int inLeft, int inRight) {
        // 如果这里没有节点构造二叉树了，就结束
        if (preLeft > preRight) return null;

        // 建立根节点 前序遍历中的第一个节点就是根节点
        TreeNode root = new TreeNode(preorder[preLeft]);
        // 在中序遍历中定位根节点
        int inRoot = indexMap.get(preorder[preLeft]);
        // 得到左子树中的节点数目
        int leftSize = inRoot - inLeft;

        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 leftSize」个元素就对应了中序遍历中
        // 「从 左边界 开始到 根节点定位-1」的元素
        root.left = recursion(preLeft + 1, preLeft + leftSize,
                inLeft, inRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了
        // 中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = recursion(preLeft + leftSize + 1,
                preRight, inRoot + 1, inRight);

        return root;
    }
}