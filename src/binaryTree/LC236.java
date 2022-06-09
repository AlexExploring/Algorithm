package binaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * �������������������
 *
 * ��Ŀ����������һ��������, �ҵ�����������ָ���ڵ������������ȡ�
 *
 * ��ĿҪ��1.���нڵ��ֵ����Ψһ�ġ�2.p��q Ϊ��ͬ�ڵ��Ҿ������ڸ����Ķ������С�
 *
 * ��LC235����
 */
public class LC236 {

    /**
     * ʵ���Ͼ��ǶԵݹ��������������������һЩ����Ĵ���
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //����������Ϊ�գ��򷵻�null
        if(left == null || right == null) return null;
        if(left == null) return right;
        if(right == null) return left;
        //�����������ҵ�p��q�ˣ��Ǿ�˵��p��q�ֱ����������������ϣ����Դ�ʱ������������Ⱦ���root
        return root;
    }



    /**
     * ���ȱ�������ʹ��map�洢���нڵ�ֵ�ĸ��ڵ�
     *
     * ע�����ݷ�Χ��
     * ���нڵ���Ŀ�ڷ�Χ [2, 105] �ڡ�
     * -109 <= Node.val <= 109
     * ���� Node.val ������ͬ ��
     * p != q
     * p �� q �������ڸ����Ķ������С�
     *
     */

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //�Ȼ�ó����ڵ�֮�����нڵ�ĸ��ڵ�
        dfs(root);

        //ʹ��visited�洢root��p��·��
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }

        while (q != null) {
            //���q��·����ͬʱ�ж��Ƿ��p��·�����غϵ㣬���غϵ�˵�����غϵ����������Ĺ�������
            if (visited.contains(q.val)) return q;
            q = parent.get(q.val);
        }
        return null;
    }

    /**
     * ʹ��hashmap�洢���˳����ڵ��������нڵ�ĸ��ڵ�
     */
    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }
}
