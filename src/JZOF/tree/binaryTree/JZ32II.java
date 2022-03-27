package JZOF.tree.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JZ32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList(){{ add(root); }};
        List<List<Integer>> ans = new ArrayList<>();
        int x = 1,t = 0;
        while(!queue.isEmpty()) {
            List<Integer> t_ans = new ArrayList<>();
            while(t_ans.size()<x){
                TreeNode node = queue.poll();
                t_ans.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);t+=1;
                }
                if(node.right != null) {
                    queue.offer(node.right);t+=1;
                }
            }
            ans.add(t_ans);
            x=t;t=0;
        }
        return ans;
    }

    /**
     *
     *
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
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
            res.add(tmp);
        }
        return res;
    }
}
