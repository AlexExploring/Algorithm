package binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * ·���ܺ�III
 *
 * ������Ŀ��LC112 ·���ܺ� I,LC113 ·���ܺ� II, LC437 ·���ܺ�III
 *
 * �������:https://leetcode-cn.com/problems/path-sum-iii/solution/qian-zhui-he-di-gui-hui-su-by-shi-huo-de-xia-tian/
 */
public class LC437 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int ret = rootSum(root,targetSum);
        ret += pathSum(root.left,targetSum);
        ret += pathSum(root.right,targetSum);

        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null) return 0;
        int val = root.val;
        if (targetSum == val) ret++;
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
    /**
     * ����ǰ׺��Ϊ�����ﵱǰԪ�ص�·���ϣ�֮ǰ����Ԫ�صĺ�
     */
    public int pathSum1(TreeNode root, int targetSum) {
        Map<Integer,Integer> prefix = new HashMap<>();
        //�������ġ����ڵ㡰һ��ǰ׺�͡� ����� put(0,1) ����������Ϊ��
        // ���֮ǰ��ǰ׺���� 0���������Լ����Ը����Ϊ����·����ǰ׺�͡�
        prefix.put(0,1);
        return dfs(root,prefix,0,targetSum);
    }

    public int dfs(TreeNode root, Map<Integer,Integer> prefix, int cur, int targetSum) {
        if (root == null) return 0;
        int ret = 0;
        cur += root.val;

        ret += prefix.getOrDefault(cur-targetSum,0);
        //��¼����һ�㼶�ĵ�ʹ�õ�ǰ׺��
        prefix.put(cur,prefix.getOrDefault(cur,0)+1);
        ret += dfs(root.left,prefix,cur,targetSum);
        ret += dfs(root.right,prefix,cur,targetSum);
        //ȥ����ǰ��·������ǰ׺�ͣ�����Ժ�����·���Ӱ��
        prefix.put(cur,prefix.getOrDefault(cur,0)-1);

        return ret;
    }


}