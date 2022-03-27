package JZOFII;

/**
 * �ڵ�֮������·��
 */
public class JZ51 {
    public static void main(String[] args) {

    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    int maxSum = Integer.MIN_VALUE;

    public int maxGain(TreeNode node) {
        if (node == null) return 0;

        // �ݹ���������ӽڵ�������ֵ
        // ֻ���������ֵ���� 0 ʱ���Ż�ѡȡ��Ӧ�ӽڵ�
        int left = Math.max(maxGain(node.left),0);
        int right = Math.max(maxGain(node.right),0);

        // �ڵ�����·����ȡ���ڸýڵ��ֵ��ýڵ�������ӽڵ�������ֵ
        int priceNewPath = node.val+ left + right;

        // ���´�
        maxSum = Math.max(maxSum,priceNewPath);

        // ���ؽڵ�������ֵ
        return node.val + Math.max(left,right);
    }
}
