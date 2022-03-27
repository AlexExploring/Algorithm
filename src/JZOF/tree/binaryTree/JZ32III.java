package JZOF.tree.binaryTree;

import java.util.*;


/**
 * 按照你的想法去，定义你需要的变量，
 */

public class JZ32III {

    // 奇 偶 层逻辑分离
    public List<List<Integer>> levelOrder1(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.addLast(root);
        int flag = 0;
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                if (flag==0) {
                    TreeNode node = queue.removeFirst();
                    tmp.add(node.val);

                    if (node.left!=null) queue.addLast(node.left);
                    if (node.right!=null) queue.addLast(node.right);
                }else if (flag==1) {
                    TreeNode node = queue.removeLast();
                    tmp.add(node.val);

                    if (node.right!=null) queue.addFirst(node.right);
                    if (node.left!=null) queue.addFirst(node.left);
                }
            }
            flag = flag==0 ? 1 : 0;
            res.add(tmp);
        }
        return res;
    }

    /**
     * 还是按照JZ32II 的解法，只是这里的tmp是双向链表，根据层数的奇偶行，自己决定是加载对头还是队尾
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.addLast(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    /**
     * 层序遍历  + 倒叙
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(res.size() % 2 == 1) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }


}
