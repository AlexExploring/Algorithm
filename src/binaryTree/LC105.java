package binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ǰ��������������й��������  (�����Ŀ��LC106)
 */
public class LC105 {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        new LC105().buildTree(preorder,inorder);

    }

    private int [] preorder;
    private int [] inorder;
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        this.preorder = preorder;
        this.inorder = preorder;

        // ���������ϣӳ�䣬�������ǿ��ٶ�λ���ڵ�
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }

        return recursion(0, len - 1, 0, len - 1);
    }

    /**
     * ��������ͨ��ǰ�������˳����ȷ�����ڵ㣬�ټ����������Ĵ�С���ݹ�Ľ�����������������
     */
    public TreeNode recursion(int pre_left, int pre_right, int in_left, int in_right) {

        if (pre_left > pre_right) {
            return null;
        }

        // ǰ������еĵ�һ���ڵ���Ǹ��ڵ�
        int pre_root = pre_left;
        // ����������ж�λ���ڵ�
        int in_root = indexMap.get(preorder[pre_root]);

        // �ȰѸ��ڵ㽨������
        TreeNode root = new TreeNode(preorder[pre_root]);
        // �õ��������еĽڵ���Ŀ
        int left_size = in_root - in_left;
        // �ݹ�ع����������������ӵ����ڵ�
        // ��������С��� ��߽�+1 ��ʼ�� left_size����Ԫ�ؾͶ�Ӧ����������С��� ��߽� ��ʼ�� ���ڵ㶨λ-1����Ԫ��
        root.left = recursion(pre_left + 1, pre_left + left_size, in_left, in_root - 1);
        // �ݹ�ع����������������ӵ����ڵ�
        // ��������С��� ��߽�+1+�������ڵ���Ŀ ��ʼ�� �ұ߽硹��Ԫ�ؾͶ�Ӧ����������С��� ���ڵ㶨λ+1 �� �ұ߽硹��Ԫ��
        root.right = recursion(pre_left + left_size + 1, pre_right, in_root + 1, in_right);

        return root;
    }
}
