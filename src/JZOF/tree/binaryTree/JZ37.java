package JZOF.tree.binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class JZ37 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root==null) return null;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root);
            StringBuilder data = new StringBuilder();
            data.append(root.val+"");
            while(!deque.isEmpty()){
                TreeNode node = deque.poll();
                if (node.left!=null) {
                    deque.offer(node.left);
                    data.append(","+node.left.val);
                }else data.append(",n");
                if (node.right!=null) {
                    deque.offer(node.right);
                    data.append(","+node.right.val);
                } else data.append(",n");
            }
            System.out.println(data);
            return new String(data);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data==null) return null;
            String[] s = data.split(",");
            TreeNode root  = new TreeNode(Integer.parseInt(s[0]));
            Deque<TreeNode> deque = new ArrayDeque();
            deque.offer(root);
            int index = 1;
            while(!deque.isEmpty()){
                TreeNode node = deque.poll();
                if (!s[index].equals("n")){
                    TreeNode left = new TreeNode(Integer.parseInt(s[index]));
                    node.left = left;
                    deque.offer(left);
                }
                index++;
                if (!s[index].equals("n")){
                    TreeNode right = new TreeNode(Integer.parseInt(s[index]));
                    node.right = right;
                    deque.offer(right);
                }
                index++;
            }
            return root;
        }
    }
}
