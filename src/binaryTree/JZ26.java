package binaryTree;

/**
 * �����ӽṹ
 *
 * ��Ŀ���������ö�����A��B���ж�B�ǲ���A���ӽṹ��
 */
public class JZ26 {

    /**
     * ��⣺https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //Լ��������������һ�������ӽṹ
        if (A == null || B == null)
            return false;
        // ���ڵ���ͬ�Ļ�ֱ�ӽ���Ƚϣ����ڵ㲻��ͬ��B�ǲ���A����/���������ӽṹ
        return hasSubStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * hasSubStructure�������ж����A,B���ڵ���ͬ��B�ǲ���A���ӽṹ
     */
    public boolean hasSubStructure(TreeNode A, TreeNode B) {
        // ��isSubStructure���Ѿ�ȷ����ÿ�δ�isSubStructure����hasSubStructureʱ��B�������ǿ���
        //���ڵ� B Ϊ�գ�˵���� B ��ƥ����ɣ�Խ��Ҷ�ӽڵ㣩����˷��� true
        if (B == null)
            return true;
        //���ڵ� A Ϊ�գ�˵���Ѿ�Խ���� A Ҷ�ӽڵ㣬��ƥ��ʧ�ܣ����� false;
        //���ڵ� A �� B ��ֵ��ͬ��˵��ƥ��ʧ�ܣ����� false ��
        if (A == null || A.val != B.val)
            return false;
        //����ֵ�������ڶ�Ӧλ�õݹ��ж�
        return hasSubStructure(A.left, B.left) && hasSubStructure(A.right, B.right);
    }
}


