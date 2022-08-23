package binaryTree.pathSum;


import java.util.*;

/**
 * ·���ܺ�II
 *
 * ������Ŀ��LC112 ·���ܺ� I,LC113 ·���ܺ� II, LC437 ·���ܺ�III
 */
public class LC113 {

    /**
     * ������� + map��¼ÿ���ڵ�ĸ��ڵ�����Ѱ��·��
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new LinkedList<>();

        if (root == null) return ans;

        //map������¼�����ĸ��ڵ�
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        //�������У��ֱ�洢��Ҫ�����Ľڵ㣬�Լ����ڵ㵽��Щ�ڵ��·����
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty()){
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            //Ҷ�ӽڵ㣬��Ҫ�ж��Ƿ���Ҫ��¼·��
            if (now.left == null && now.right == null){
                if (temp == targetSum){
                    //ȡ�����ﵱǰ���������Ľڵ��·��
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
     *  ������ȱ���,����Ҫʹ��map����¼���ڵ�ĸ��ڵ�
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
        //rootΪҶ�ӽڵ㣬����targetSum = 0��˵���ҵ���һ��·��
        if (root.left == null && root.right == null && targetSum == 0){
            ans.add(new ArrayList<>(path));
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);

        //����
        path.pollLast();
    }
}