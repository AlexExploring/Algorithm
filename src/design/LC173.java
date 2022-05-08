package design;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉搜索树迭代器
 */
public class LC173 {

}

/**
 * 方法一 ：我们可以直接对二叉搜索树做一次完全的递归遍历，获取中序遍历的全部结果并
 * 保存在数组中。随后，我们利用得到的数组本身来实现迭代器。
 */
class BSTIterator {
    private int index;
    private List<Integer> data;

    public BSTIterator(TreeNode root) {
        index = 0;
        data = new ArrayList<Integer>();
        inOrder(root, data);
    }

    public int next() {
        return data.get(index++);
    }

    public boolean hasNext() {
        return index < data.size();
    }

    /**
     * 中序遍历将数据记录到线性表中
     */
    private void inOrder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
    }
}

/**
 * 方法二：使用（借助栈遍历二叉树的方法）
 */
class BSTIterator1 {
    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIterator1(TreeNode root) {
        cur = root;
        stack = new LinkedList<TreeNode>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        //两个条件任意满足一个，说明二叉树还没有遍历完
        return cur != null || !stack.isEmpty();
    }
}