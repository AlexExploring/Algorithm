package JZOF.tree.binaryTree;

/**
 *ƽ�������
 */
public class JZ55II {
    public static void main(String[] args) {

    }

    /**
     *�Ե��򶥣�ֻ����һ������������ƽ�����������ö���������ƽ�������
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root) !=-1;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;
        int nLeft = helper(root.left);
        int nRight = helper(root.right);
        if (nLeft==-1||nRight==-1) return -1;
        return Math.abs(nLeft-nRight)<2 ? Math.max(nLeft,nRight)+1 : -1;
    }

    /**
     *�Զ���ף�˼·�ǹ���һ����ȡ��ǰ������ȵĺ���depth(root),ͨ���Ƚ�ĳ
     * ������������������Ȳ���ж�ĳ�����Ƿ���ƽ�������������
     * ��������ƽ�⣬�����ƽ��
     */


}
