package Tree;

/**
 *二叉树中的最大路径和
 */
public class LC124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 首先，考虑实现一个简化的函数 maxGain(node)，该函数计算二叉树中的一个节
     * 点的最大贡献值，具体而言，就是在以该节点为根节点的子树中寻找以该节点为起点
     * 的一条路径，使得该路径上的节点值之和最大。
     *
     */
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        /**
         *据函数 maxGain 得到每个节点的最大贡献值之后，如何得到二叉树的最大路径和？对于
         * 二叉树中的一个节点，该节点的最大路径和取决于该节点的值与该节点的左右子节点的最
         * 大贡献值，如果子节点的最大贡献值为正，则计入该节点的最大路径和，否则不计入该
         * 节点的最大路径和
         *
         * 本质上就是选择某一个节点，以及它的leftGain()和rightGain()的最大值。。。
         */

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 本质上就是选择某一个节点，以及它的leftGain()和rightGain()的最大值。。。
        //而左右两边可以只有一个节点，也可以是一系列从一系列的子树中选择出的最大值。。。
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);  //关键点，二叉树的遍历的顺序
        // ，二叉树的结构，答案是由二叉树中的那些节点组合起来的

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);//这里选择两边中最大的一个，并返回
        //这样在上一层次的leftaGain或rightGain中得到的是对上一层次的节点的最大的贡献值。。。如果是
        // 一系列的树最终返回得到的值得话，也就是上一次层次的左或右子树中的和的最大的路线，为上一层次的
        //maxSum的更新做准备。
    }
}
