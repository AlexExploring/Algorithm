package a_books.algorithm_competition.nin.nin_Str_4;

/**
 *KMP���
 *
 */
public class hdu2087 {
    public static void main(String[] args) {
        System.out.println(ViolentMatch("abcxyz123","123"));
    }

    /**
     *�����㷨
     */
    public static int ViolentMatch(String s, String p)
    {
        int sLen = s.length();
        int pLen = p.length();

        int i = 0;
        int j = 0;
        while (i < sLen && j < pLen)
        {
            if (s.charAt(i) == p.charAt(j))
            {
                //�������ǰ�ַ�ƥ��ɹ�����S[i] == P[j]������i++��j++
                i++;
                j++;
            }
            else
            {
                //�����ʧ�䣨��S[i]! = P[j]������i = i - (j - 1)��j = 0
                i = i - j + 1;//i����
                j = 0;//j����ָ���һ��λ��
            }
        }
        //ƥ��ɹ�������ģʽ��p���ı���s�е�λ�ã����򷵻�-1
        if (j == pLen)
            return i - j;
        else
            return -1;
    }

//    public int KmpSearch(String s, String p)
//    {
//        int i = 0;
//        int j = 0;
//        int sLen = s.length();
//        int pLen = p.length();
//        while (i < sLen && j < pLen)
//        {
//            //�����j = -1�����ߵ�ǰ�ַ�ƥ��ɹ�����S[i] == P[j]��������i++��j++
//            if (j == -1 || s.charAt(i) == p.charAt(j))
//            {
//                i++;
//                j++;
//            }
//            else
//            {
//                //�����j != -1���ҵ�ǰ�ַ�ƥ��ʧ�ܣ���S[i] != P[j]�������� i ���䣬j = next[j]
//                //next[j]��Ϊj����Ӧ��nextֵ
//                j = next[j];
//            }
//        }
//        if (j == pLen)
//            return i - j;
//        else
//            return -1;
//    }
}
