package binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * �����������������й��������,��Ŀ��֤���ظ�Ԫ��(�����Ŀ��LC105)
 */
public class LC106 {

    public static void main(String[] args) {
        int [] inorder = {9,3,15,20,7};
        int [] postorder = {9,15,7,20,3};
        new LC106().buildTree(inorder,postorder);
    }

    private int[] postorder;
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        this.postorder = postorder;
        this.indexMap = new HashMap<>();

        // ������Ԫ�أ��±꣩��ֵ�ԵĹ�ϣ��
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i],i);
        }

        return recursion(0, len - 1,0,len - 1);
    }

    public TreeNode recursion(int inLeft, int inRight,int postLeft,int postRight) {
        if (postLeft > postRight) return null;

        // �������ڵ� ��������е����һ���ڵ���Ǹ��ڵ�
        TreeNode root = new TreeNode(postorder[postRight]);
        // ����������ж�λ���ڵ�
        int inRoot = indexMap.get(postorder[postRight]);
        // �õ��������еĽڵ���Ŀ
        int leftSize = inRoot - inLeft;

        root.left = recursion(inLeft,inRoot - 1,
                postLeft,postLeft + leftSize - 1);
        root.right = recursion(inRoot + 1,inRight,
                postLeft + leftSize,postRight - 1);

        return root;
    }
}