package String.arithmetic;

/**
 * ��������ת����
 */
public class LC13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCD"));
    }

    public static int romanToInt(String s) {
        StringBuffer data = new StringBuffer(s);
        int ans = 0;
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String reps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        //ǧλ
        if (data.indexOf("M")==0) {
            ans+=values[0];data.deleteCharAt(0);
        }

        return ans;
    }
}
