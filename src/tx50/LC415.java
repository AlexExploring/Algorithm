package tx50;

/**
 * 字符串相加
 * 相关题目：LC43
 */
public class LC415 {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0,i = num1.length()-1,j = num2.length()-1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) carry+=num1.charAt(i--)-'0';
            if (j >= 0) carry+=num2.charAt(j--)-'0';
            res.append(carry%10);
            carry/=10;
        }
        return res.reverse().toString();
    }
}
