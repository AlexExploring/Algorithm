package binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * �����������������й�������� (�����Ŀ��LC105)
 */
public class LC106 {

    public static void main(String[] args) {
        int [] inorder = {9,3,15,20,7};
        int [] postorder = {9,15,7,20,3};
        new LC106().buildTree(inorder,postorder);
    }

    int post_index;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> index_map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        this.postorder = postorder;
        this.inorder = inorder;
        // �Ӻ�����������һ��Ԫ�ؿ�ʼ
        post_index = postorder.length - 1;

        // ������Ԫ�أ��±꣩��ֵ�ԵĹ�ϣ��
        for (int i = 0; i < len; i++) {
            index_map.put(inorder[i],i);
        }

        return recursion(0, len - 1);
    }

    public TreeNode recursion(int in_left, int in_right) {
        // �������û�нڵ㹹��������ˣ��ͽ���
        if (in_left > in_right) return null;

        // ѡ�� post_index λ�õ�Ԫ����Ϊ��ǰ�������ڵ�
        int rootVal = postorder[post_index];
        // ���� root_val ��inorder������λ�÷ֳ�������������
        int in_root = index_map.get(rootVal);
        // �Ѹ��ڵ㽨������
        TreeNode root = new TreeNode(rootVal);

        // �±��һ
        post_index--;
        // ����������
        root.left = recursion(in_left, in_root - 1);
        // ����������
        root.right = recursion(in_root + 1, in_right);

        return root;
    }
}

