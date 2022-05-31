package String;

/**
 *  ������ת��������
 */
public class JZ67 {

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("-1"));
    }

    public static int strToInt(String str) {
        str = str.trim();
        if (str.equals("")) return 0;

        int index = 0,flag = 1;
        char first = str.charAt(0);
        if (first == '+' || first == '-') {
            if (str.charAt(0) == '-') flag = -1;
            index = 1;
        }

        long res = 0;
        int max = Integer.MAX_VALUE,min = Integer.MIN_VALUE;
        while (index < str.length()){
            if (Character.isDigit(str.charAt(index))){
                res = res * 10 + flag * (str.charAt(index) - '0');
                //����ˣ�ֱ�ӷ������ֵ����Сֵ����
                if (res > max) return max;
                else if (res < min) return min;
                //���������ˣ���ǰ����
            } else return (int) res;
            index++;
        }

        return (int) res;
    }
}

