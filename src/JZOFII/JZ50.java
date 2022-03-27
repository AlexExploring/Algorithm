package JZOFII;

import java.util.HashMap;
import java.util.Map;

/**
 * ���µ�·���ڵ�֮��
 *
 */
public class JZ50 {

    /**
     * ��Ŀ���Ҫ������Ǵ�root�ڵ㿪ʼ�ģ��Ǿ��Ǽ����ˣ�ֱ��һ��������ȱ����Ϳ����ҳ�����·��
     *
     * ����������Ҫ��·������Ҫ�Ӹ��ڵ㿪ʼ������������ڵ㣬Ҫ��ô�죿��Ȼ�ǳ��Դ�ÿ��������ʼ�ˡ�
     */
    public int pathSum1(TreeNode root, int targetSum) {
        if (root==null) return 0;

        int ret = rootSum(root,targetSum);
        ret += pathSum1(root.left,targetSum);
        ret += pathSum1(root.right,targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root==null) return 0;
        int val = root.val;
        if (val==targetSum) ret++;
        ret += rootSum(root.left,targetSum-val);
        ret += rootSum(root.right,targetSum-val);
        return ret;
    }


    /**
     * ����ǰ׺��Ϊ���ɸ��ڵ㵽��ǰ�ڵ��·�������нڵ�ĺ�.
     */
    public int pathSum(TreeNode root, int targetSum) {
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
        prefix.put(cur,prefix.getOrDefault(cur,0)+1);
        ret += dfs(root.left,prefix,cur,targetSum);
        ret += dfs(root.right,prefix,cur,targetSum);
        prefix.put(cur,prefix.getOrDefault(cur,0)-1);

        return ret;
    }
}
