package binaryTree.pathSum;

import java.util.HashMap;
import java.util.Map;

/**
 * ·���ܺ�III
 *
 * ע�⣺·�� ����Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��
 *
 * ������Ŀ��LC112 ·���ܺ� I,LC113 ·���ܺ� II, LC437 ·���ܺ�III
 *
 * �������:https://leetcode-cn.com/problems/path-sum-iii/solution/qian-zhui-he-di-gui-hui-su-by-shi-huo-de-xia-tian/
 */
public class LC437 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int ret = rootSum(root,targetSum);
        //�ݹ�Ĵ�ÿһ���ڵ㿪ʼ����Ѱ��·��
        ret += pathSum(root.left,targetSum);
        ret += pathSum(root.right,targetSum);

        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int ret = 0,val= root.val;
        if (targetSum == val) ret++;
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

    /**
     * ����ǰ׺��Ϊ���ɸ���㵽��ǰ����·�������нڵ�ĺ͡�
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
        //�ݹ�ļ��������������ܲ����ĸ���������·��
        ret += dfs(root.left,prefix,cur,targetSum);
        ret += dfs(root.right,prefix,cur,targetSum);
        //ȥ����ǰ��·������ǰ׺�ͣ�����Ժ�����·���Ӱ��
        prefix.put(cur,prefix.getOrDefault(cur,0)-1);

        return ret;
    }
}