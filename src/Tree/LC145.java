package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/**
 *�������
 */
public class LC145 {

    /**
     *����һ���ݹ鷽��
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
     *����2, ����
     */
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null) {
                return res;
            }

            //���������˳��Ϊ������
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }//�ҵ����Ϊ��Ϊֹ
                root = stack.pop();//�ýڵ���û������������������ҵ�����������������Ҫ����������ջ��
                //��������������������ʼ�����������ظ�
                if (root.right == null || root.right == prev) {//��ǰ�ڵ��û����������Ҳû��������
                    res.add(root.val);
                    prev = root;
                    root = null;//��������������λnull
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
            return res;
        }
    }
}
