package Top100;

import java.util.*;

/**
 * 路劲总和II
 */
public class LC113 {

    /**
     * 层序遍历 + map记录每个节点的父节点用来寻找路径
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root==null) return null;

        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty()){
            TreeNode now = queNode.poll();
            Integer temp = queVal.poll();

            if (now.left==null&&now.right==null){
                if (temp == targetSum){
                    TreeNode p = map.get(now);
                    LinkedList tans = new LinkedList<>();
                    tans.offerFirst(now.val);
                    while (p!=null){
                        tans.offerFirst(p.val);
                        p = map.get(p);
                    }
                    ans.add(new ArrayList<>(tans));
                }
                continue;
            }

            if (now.left != null){
                queNode.offer(now.left);
                queVal.offer(now.left.val+temp);
                map.put(now.left,now);
            }

            if (now.right != null){
                queNode.offer(now.right);
                queVal.offer(now.right.val+temp);
                map.put(now.right,now);
            }
        }
        return ans;
    }


    /**
     *  深度优先遍历
     */
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root,int targetSum) {
        if (root == null) return;

        path.offerLast(root.val);
        targetSum-=root.val;
        if (root.left==null&&root.right==null&&targetSum==0){
            ret.add(new ArrayList<>(path));
        }

        dfs(root.left,targetSum);
        dfs(root.right,targetSum);

        path.pollLast();
    }
}