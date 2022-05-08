package binarySearchTree;

/**
 * �Ѷ���������ת��Ϊ�ۼ���
 *
 * ����һ���������������뽫����ÿ���ڵ��ֵ�滻�����д��ڻ��ߵ��ڸýڵ�ֵ�����нڵ�ֵ֮�͡�
 */

public class LC538 {

    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    int num = 0;

    /**
     * ��������������������
     */
    public void inOrder(TreeNode root){
        if (root != null) {
            inOrder(root.right);
            root.val+=num;
            num = root.val;
            inOrder(root.left);
        }
    }
}
