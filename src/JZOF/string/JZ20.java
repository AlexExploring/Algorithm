package JZOF.string;

/**
 * ��ʾ��ֵ���ַ���
 */
public class JZ20 {
    public boolean isNumber(String s) {
        s = s.trim();

        if (s.length()==0) return false;

        boolean numFlag = false;
        boolean Not_num_flag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            //�ж�Ϊ���֣�����numFlag
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
                //�ж�Ϊ.  ��Ҫû���ֹ� . ����û���ֹ� e
            } else if (s.charAt(i) == '.' && !Not_num_flag && !eFlag) {
                Not_num_flag = true;
                //�ж�Ϊe����Ҫû���ֹ�e�����ҳ���������
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;//Ϊ�˱���123e�������󣬳���e֮��ͱ�־Ϊfalse
                //�ж�Ϊ+-���ţ�ֻ�ܳ����ڵ�һλ���߽���e����
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                //������������ǷǷ���
            } else {
                return false;
            }
        }
        return numFlag;
    }
}
