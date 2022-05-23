package binaryTree;

/**
 * 树的子结构
 *
 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
 */
public class JZ26 {

    /**
     * 题解：https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //约定空树不是任意一个树的子结构
        if (A == null || B == null)
            return false;
        // 根节点相同的话直接进入比较，根节点不相同看B是不是A的左/右子树的子结构
        return hasSubStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * hasSubStructure函数是判断如果A,B根节点相同，B是不是A的子结构
     */
    public boolean hasSubStructure(TreeNode A, TreeNode B) {
        // 在isSubStructure中已经确保了每次从isSubStructure进入hasSubStructure时，B不可能是空树
        //当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true
        if (B == null)
            return true;
        //当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false;
        //当节点 A 和 B 的值不同：说明匹配失败，返回 false ；
        if (A == null || A.val != B.val)
            return false;
        //返回值：继续在对应位置递归判断
        return hasSubStructure(A.left, B.left) && hasSubStructure(A.right, B.right);
    }
}


