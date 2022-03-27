package JZOF.tree.binaryTree;


/**
 *�������������������
 */
public class JZ68II {
    public static void main(String[] args) {

    }

    public TreeNode ans;

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;  //�ݹ����
        boolean lson = dfs(root.left, p, q);  // ���������Ƿ���p����q
        boolean rson = dfs(root.right, p, q); // ���������Ƿ���p����q
        //(lson && rson) ��ʾ��������������������p�ڵ��ȥ�ڵ㣬�����������������p�ڵ㣬��ô������ֻ�ܰ���q�ڵ㣬��֮��Ȼ��
        // ������p����qǡ����root�ڵ㣬
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root; //���ϸ���ans ����Ϊ�����ҵ���һ�������֮ǰ�����Ĺ�������
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       dfs(root,p,q);
       return ans;
    }

    // �������ĳһ����ͬʱ���� p��q����������ĸ��ڵ����p��q������������ȡ�����
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        //l��r �ǿ�ʱ��˵�� p��q �־� root �����࣬root ���� LCA
        //l��r ��һΪ�գ�˵�� LCA λ����һ��������������
        return l == null ? r : (r == null ? l : root);
    }
}