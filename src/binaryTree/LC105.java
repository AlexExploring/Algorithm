package binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ǰ��������������й��������  (�����Ŀ��LC106)
 */
public class LC105 {

    private int [] preorder;
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.indexMap = new HashMap<Integer, Integer>();
        int len = preorder.length;

        // ���������ϣӳ�䣬�������ǿ��ٶ�λ���ڵ�
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }

        return recursion(0, len - 1, 0, len - 1);
    }

    /**
     * ��������ͨ��ǰ�������˳����ȷ�����ڵ㣬�ټ����������Ĵ�С���ݹ�Ľ�����������������
     */
    public TreeNode recursion(int preLeft, int preRight, int inLeft, int inRight) {
        // �������û�нڵ㹹��������ˣ��ͽ���
        if (preLeft > preRight) return null;

        // �������ڵ� ǰ������еĵ�һ���ڵ���Ǹ��ڵ�
        TreeNode root = new TreeNode(preorder[preLeft]);
        // ����������ж�λ���ڵ�
        int inRoot = indexMap.get(preorder[preLeft]);
        // �õ��������еĽڵ���Ŀ
        int leftSize = inRoot - inLeft;

        // �ݹ�ع����������������ӵ����ڵ�
        // ��������С��� ��߽�+1 ��ʼ�� leftSize����Ԫ�ؾͶ�Ӧ�����������
        // ���� ��߽� ��ʼ�� ���ڵ㶨λ-1����Ԫ��
        root.left = recursion(preLeft + 1, preLeft + leftSize,
                inLeft, inRoot - 1);
        // �ݹ�ع����������������ӵ����ڵ�
        // ��������С��� ��߽�+1+�������ڵ���Ŀ ��ʼ�� �ұ߽硹��Ԫ�ؾͶ�Ӧ��
        // ��������С��� ���ڵ㶨λ+1 �� �ұ߽硹��Ԫ��
        root.right = recursion(preLeft + leftSize + 1,
                preRight, inRoot + 1, inRight);

        return root;
    }
}