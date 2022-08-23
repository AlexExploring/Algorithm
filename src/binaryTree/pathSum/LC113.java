package binaryTree.pathSum;


import java.util.*;

/**
 * 路劲总和II
 *
 * 相似题目；LC112 路径总和 I,LC113 路径总和 II, LC437 路径总和III
 */
public class LC113 {

    /**
     * 层序遍历 + map记录每个节点的父节点用来寻找路径
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new LinkedList<>();

        if (root == null) return ans;

        //map用来记录各结点的父节点
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        //两个队列，分别存储将要遍历的节点，以及根节点到这些节点的路径和
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty()){
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            //叶子节点，需要判断是否需要记录路径
            if (now.left == null && now.right == null){
                if (temp == targetSum){
                    //取出到达当前满足条件的节点的路径
                    TreeNode p = map.get(now);
                    LinkedList<Integer> tans = new LinkedList<>();
                    tans.addFirst(now.val);
                    while (p != null){
                        tans.addFirst(p.val);
                        p = map.get(p);
                    }
                    ans.add(new ArrayList<>(tans));
                }
                continue;
            }

            if (now.left != null){
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
                map.put(now.left,now);
            }

            if (now.right != null){
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
                map.put(now.right,now);
            }
        }

        return ans;
    }

    /**
     *  深度优先遍历,不需要使用map来记录个节点的父节点
     */
    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ans;
    }

    List<List<Integer>> ans = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) return;

        path.offerLast(root.val);

        targetSum -= root.val;
        //root为叶子节点，并且targetSum = 0，说明找到了一条路径
        if (root.left == null && root.right == null && targetSum == 0){
            ans.add(new ArrayList<>(path));
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);

        //回溯
        path.pollLast();
    }
}