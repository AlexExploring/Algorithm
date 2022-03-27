package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/**
 *前序遍历
 */
public class LC144 {
    public static void main(String[] args) {

    }

    /**
     *方法1 递归
     * 和方法1的区别在于递归的时候隐式地维护了一个栈，而我们在迭代的时候需要显式地将
     * 这个栈模拟出来，其余的实现与细节都相同
     */
    public List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null){

            ans.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return ans;
    }

    /**
     *方法2 迭代
     *
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        //就是当栈不为空的时候,不断向左或向右移动
        while (!stack.isEmpty() || node != null) {
            //如果当前节点不为空则不断向左
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            //将当前节点左边的全部处理完毕，则向右进行扩展
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

}
