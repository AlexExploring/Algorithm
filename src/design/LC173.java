package design;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ����������������
 */
public class LC173 {

}

/**
 * ����һ �����ǿ���ֱ�ӶԶ�����������һ����ȫ�ĵݹ��������ȡ���������ȫ�������
 * �����������С�����������õõ������鱾����ʵ�ֵ�������
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
     * ������������ݼ�¼�����Ա���
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
 * ��������ʹ�ã�����ջ�����������ķ�����
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
        //����������������һ����˵����������û�б�����
        return cur != null || !stack.isEmpty();
    }
}