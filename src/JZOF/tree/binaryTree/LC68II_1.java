package JZOF.tree.binaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC68II_1 {
    public static void main(String[] args) {

    }

    //����һֱ�ݹ��ҵ�p��q��Ȼ�󽫽��һ��һ��ķ��ء�
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        //l��r �ǿ�ʱ��˵�� p��q �־� root �����࣬root ���� LCA
        //l��r ��һΪ�գ�˵�� LCA λ����һ��������������
        //����Ĺ������ȱ��ҵ��󣬻ᱻleft����right������һ�㣬���ձ�����
        return l == null ? r : (r == null ? l : root);
    }




    // ��map�洢���нڵ�ĸ��ڵ�֮��
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);  //����ֱ���ҵ����ڵ� root ���ĸ��ڵ�Ϊnul
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;  //�ӵ������ҵ��ĵ�һ�������ڵ��������Ĺ������ȡ�����
            }
            q = parent.get(q.val);
        }
        return null;
    }

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    //ֱ�Ӵ洢���нڵ�ĸ��ڵ�
    // parent.put(���ڵ����ڵ���ҽڵ��ֵ,���ڵ�)
    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
