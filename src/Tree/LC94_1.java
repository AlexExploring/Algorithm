package Tree;

import java.util.*;

/**
 *二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * https://leetcode-cn.com/problems/binary-tree-ino
 * rder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/
 */
public class LC94_1 {
    public static void main(String[] args) {

    }

    /**
     *迭代方法 使用栈
     *
     * 中续遍历 按照左中右的顺序
     *
     * 不改变树的结构
     */

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
//        !stk.isEmpty()是为了保证当上一次使用root=root.left前，root指向叶子节点，这样root为
//        空时，由于栈中还有值，则可以继续执行下去，否则将停止执行
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
//                这里的root节点就是目前遍历到的节点，且已经确定了当前root节点没有左节点
            root = stk.pop();
            res.add(root.val);
//                为下一次做准备
            root = root.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(stack.size()>0 || root!=null) {
            //不断往左子树方向走，每走一次就将当前节点保存到栈中
            //这是模拟递归的调用
            if(root!=null) {
                stack.add(root);
                root = root.left;
                //当前节点为空，说明左边走到头了，从栈中弹出节点并保存
                //然后转向右边节点，继续上面整个过程
            } else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }

    /**
     *Morris 中序遍历
     * 思路与算法
     *
     * Morris 遍历算法是另一种遍历二叉树的方法，它能将非递归的中序遍历空间复杂度降为 O(1)。
     *假设当前遍历到的节点为 x，将 x 的左子树中最右边的节点的右孩子指向 xx，这样在左子树遍
     * 历完成后我们通过这个指向走回了 x，且能通过这个指向知晓我们已经遍历完成了左子树，而不
     * 用再通过栈来维护，省去了栈的空间复杂度。
     *
     */

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
//            通过操作predecessor使得以predecessor指向的节点为前驱节点的右指针指向当前的ro
//            ot节点，即将树的结构进行了改变成了链式结构
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
//                predecessor.right != root主要是用来判断是否进入了一个循环。
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接，如果不断开的话将陷入一个死循环
                else {
                    res.add(root.val);
//                    下面两步可以交换顺序，
                    predecessor.right = null;  //这一句可以删除，对结果没有影响因为通过predecessor.right != root
                    //可以保证当root再次指向之前指向过的节点时predecesor不为空，从而进入该部分。
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }


    public List<Integer> inorderTraversal4(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode pre = null;
        while(root!=null) {
            //如果左节点不为空，就将当前节点连带右子树全部挂到
            //左节点的最右子树下面
            if(root.left!=null) {
                pre = root.left;
                while(pre.right!=null) {
                    pre = pre.right;
                }
                pre.right = root;
                //将root指向root的left 彻底改变了二叉树的结构
                TreeNode tmp = root;
                root = root.left;
                tmp.left = null;
                //左子树为空，则打印这个节点，并向右边遍历
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}