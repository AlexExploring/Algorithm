package binaryTree.pathSum;

/**
 * ��������ֱ��
 *
 * ��Ŀ������һ�ö�����������Ҫ��������ֱ�����ȡ�һ�ö�������ֱ��
 * �����������������·�������е����ֵ������·�����ܴ���Ҳ���ܲ�
 * ��������㡣
 *
 * ע�⣺�����֮���·��������������֮��ߵ���Ŀ��ʾ��
 */
public class LC543 {

    /**
     * ����һ:��Ϊ�����������·�������е����ֵ��������Ҫά��һ��max������¼
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    int max = 0;

    public int dfs(TreeNode root) {
        int left = root.left == null ? 0 : dfs(root.left) + 1;
        int right = root.right == null ? 0 : dfs(root.right) + 1;
        max = Math.max(max,(left+right));
        return Math.max(left,right);
    }
}


