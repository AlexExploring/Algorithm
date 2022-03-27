package JZOF.tree.binaryTree;

/**
 * �����ӽṹ
 */
public class JZ26 {

    public boolean isSubStructure(TreeNode A, TreeNode B)
    {
        if (A==null||B==null)   //�����ж�
            return false;
        // ���ڵ���ͬ�Ļ�ֱ�ӽ���Ƚϣ����ڵ㲻��ͬ��B�ǲ���A����/���������ӽṹ
        return hasSubStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // hasSubStructure�������ж����A,B���ڵ���ͬ��B�ǲ���A���ӽṹ
    public boolean hasSubStructure(TreeNode A, TreeNode B)
    {
                            // ��isSubStructure���Ѿ�ȷ����ÿ�δ�isSubStructure����hasSubStructureʱ��B�������ǿ���
        if (B==null)        //�ݹ��������1��A��һ���ڵ�B�Ķ�Ӧλ��û��,������Ϊ���ӽṹ  �����B==nullֻ���hasSubStructure��������
            return true;
        if (A==null || A.val != B.val)  //�ݹ��������2��B��һ���ڵ�A�Ķ�Ӧλ��û�� / A,B��Ӧλ�ýڵ�ֵ��ͬ����ʱ��Ȼ���������ӽṹ
            return false;
        return hasSubStructure(A.left, B.left) && hasSubStructure(A.right, B.right); //����ֵ�������ڶ�Ӧλ�õݹ��ж�
    }
}


