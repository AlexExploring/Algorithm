package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/**
 *后序遍历
 */
public class LC145 {

    /**
     *方法一，递归方法
     */
    public List<Integer> ans = new ArrayList<>();
    public List<Integer> postOrderTraversal(TreeNode root) {
        if (root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            ans.add(root.val);
        }
        return ans;
    }

    /**
     *方法2, 迭代
     */
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null) {
                return res;
            }

            //后序遍历的顺序为左右中
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }//找到左边为空为止
                root = stack.pop();//该节点已没有左子树，如果后续找到它有右子树，则需要将它从新入栈；
                //并从它的右子树继续开始找左子树，重复
                if (root.right == null || root.right == prev) {//当前节点既没有左子树，也没有右子树
                    res.add(root.val);
                    prev = root;
                    root = null;//加入结果后，则将其置位null
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
            return res;
        }
    }
}
