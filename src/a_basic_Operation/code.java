package a_basic_Operation;

public class code {
    /**
     *�ж��Ƿ�������
     */
    static boolean isLeap(int year) { // ���꣺2��29�죻ƽ�꣺2��28��
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }


    /**
     *���������
     */
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    /**
     *����󹫱���
     */
    public static int commonMultiples(int a,int b){
        int t = gcd(a,b);
        return (a*b)/t;
    }

    /**
     *��չŷ����ã����������������ʣ����ܴճ������������a��b-a-b
     */
}
