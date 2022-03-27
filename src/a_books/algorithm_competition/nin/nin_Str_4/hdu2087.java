package a_books.algorithm_competition.nin.nin_Str_4;

/**
 *KMP相关
 *
 */
public class hdu2087 {
    public static void main(String[] args) {
        System.out.println(ViolentMatch("abcxyz123","123"));
    }

    /**
     *暴力算法
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
                //①如果当前字符匹配成功（即S[i] == P[j]），则i++，j++
                i++;
                j++;
            }
            else
            {
                //②如果失配（即S[i]! = P[j]），令i = i - (j - 1)，j = 0
                i = i - j + 1;//i回溯
                j = 0;//j从新指向第一个位置
            }
        }
        //匹配成功，返回模式串p在文本串s中的位置，否则返回-1
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
//            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
//            if (j == -1 || s.charAt(i) == p.charAt(j))
//            {
//                i++;
//                j++;
//            }
//            else
//            {
//                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
//                //next[j]即为j所对应的next值
//                j = next[j];
//            }
//        }
//        if (j == pLen)
//            return i - j;
//        else
//            return -1;
//    }
}
