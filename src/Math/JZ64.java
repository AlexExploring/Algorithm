package Math;

/**
 * ��Ŀ�� ��1+2+��+n��Ҫ����ʹ�ó˳�����for��while��if��else��
 * switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 */
public class JZ64 {

    public int sumNums(int n) {
        //����&&�Ķ�·ЧӦ
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
