package String;

/**
 *�ַ���ת������
 */
public class LC8 {
    public static void main(String[] args) {

    }

    public static int myAtoi(String s) {
        s = s.trim();
        if (s.equals("")) return 0;
        int flag = 0;
        int index = 0;
        if (s.charAt(index)=='-'){
            index++;
            flag = -1;
        }else if (s.charAt(index)=='+'){
            index++;
            flag = 1;
        }else if (!Character.isDigit(s.charAt(index)))
            return 0;

        int ans = 0;
        //ע�⴦��ñ߽�����
        while (index<s.length()&&Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // ����Ӧ���� ans * 10 + digit > Integer.MAX_VALUE
                // ���� *10 �� + digit ���п���Խ�磬���ж��ƶ����ұ�ȥ�Ϳ����ˡ�
                return flag<0? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            index++;
        }
        return flag<0 ? -ans : ans;
    }
}
