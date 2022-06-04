package binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ҽ���III
 */
public class LC337 {

    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();

    /**
     * ���ǿ����� f(o) ��ʾѡ�� o �ڵ������£�o �ڵ�������ϱ�ѡ��Ľڵ�����Ȩֵ�ͣ�
     * g(o) ��ʾ��ѡ�� o �ڵ������£�o�ڵ�������ϱ�ѡ��Ľڵ�����Ȩֵ�ͣ�l �� r ��
     * �� o �����Һ��ӡ�
     */
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        //ѡ���˵�ǰ�ڵ㣬�Ͳ���ѡ�͵�ǰ�ڵ�ֱ���������ӽڵ�
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        //��ѡ��ǰ�ڵ㣬ѡ���ӽڵ��ѡ���ӽڵ� �� ѡ���ӽڵ��ѡ���ӽڵ� �е����ֵ
        g.put(root,
                Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0))
                        + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
    }

    /**
     * �ռ临�Ӷ��Ż���
     * ˼·�����Ƿ��������� f(o) ���� g(o)���������յ�ֵֻ��f(l)��g(l)��f(r)��g(r)
     * �йأ����Զ���ÿ���ڵ㣬����ֻ�������ĺ��ӽڵ��ǵ� f �� g �Ƕ��١����ǿ�����
     * ��һ���ṹ����ʾĳ���ڵ�� f �� g ֵ����ÿ�εݹ鷵�ص�ʱ�򣬶���������Ӧ��
     * f �� g ���ظ���һ�����ã���������ʡȥ��ϣ��Ŀռ䡣
     */
    public int rob1(TreeNode root) {
        int[] rootStatus = dfs1(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs1(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] l = dfs1(root.left);
        int[] r = dfs1(root.right);
        int selected = root.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}
