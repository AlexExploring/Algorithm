package JZOF.tree.binaryTree;

/**
 * 树的子结构
 */
public class JZ26 {

    public boolean isSubStructure(TreeNode A, TreeNode B)
    {
        if (A==null||B==null)   //特殊判断
            return false;
        // 根节点相同的话直接进入比较，根节点不相同看B是不是A的左/右子树的子结构
        return hasSubStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // hasSubStructure函数是判断如果A,B根节点相同，B是不是A的子结构
    public boolean hasSubStructure(TreeNode A, TreeNode B)
    {
                            // 在isSubStructure中已经确保了每次从isSubStructure进入hasSubStructure时，B不可能是空树
        if (B==null)        //递归结束条件1：A的一个节点B的对应位置没有,可以认为是子结构  这里的B==null只针对hasSubStructure函数里面
            return true;
        if (A==null || A.val != B.val)  //递归结束条件2：B的一个节点A的对应位置没有 / A,B对应位置节点值不同，此时必然不可能是子结构
            return false;
        return hasSubStructure(A.left, B.left) && hasSubStructure(A.right, B.right); //返回值：继续在对应位置递归判断
    }
}


