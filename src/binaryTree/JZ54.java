package binaryTree;

import java.util.ArrayList;

/**
 *  ����һ�ö��������������ҳ����е�k��Ľڵ㡣
 */
public class JZ54 {

    /**
     * �����������������
     */
    public int kthLargest(TreeNode root, int k) {
        backTrack(root);
        return list.get(list.size()-k);
    }

    static ArrayList<Integer> list = new ArrayList<>();

    public static void backTrack(TreeNode root) {
        if (root!=null){
            backTrack(root.left);
            list.add(root.val);
            backTrack(root.right);
        }
    }

    /**
     * ������������ + count��¼
     */
    public int kthLargest1(TreeNode root, int k) {
        backTrack2(root,k);
        return res;
    }

    int count = 0,res = 0;

    public void backTrack2(TreeNode root, int k) {
        if (root != null && count < k){
            backTrack2(root.right,k);
            count++;
            if (count == k) res = root.val;
            backTrack2(root.left,k);
        }
    }
}
