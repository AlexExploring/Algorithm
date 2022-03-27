package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/**
 *ǰ�����
 */
public class LC144 {
    public static void main(String[] args) {

    }

    /**
     *����1 �ݹ�
     * �ͷ���1���������ڵݹ��ʱ����ʽ��ά����һ��ջ���������ڵ�����ʱ����Ҫ��ʽ�ؽ�
     * ���ջģ������������ʵ����ϸ�ڶ���ͬ
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
     *����2 ����
     *
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        //���ǵ�ջ��Ϊ�յ�ʱ��,��������������ƶ�
        while (!stack.isEmpty() || node != null) {
            //�����ǰ�ڵ㲻Ϊ���򲻶�����
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            //����ǰ�ڵ���ߵ�ȫ��������ϣ������ҽ�����չ
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

}
