package tx50;

/**
 * 字符串相乘
 * 相关题目：LC415
 */
public class LC43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String res = "0";

        //从num2的最后一位开始逐位和num1相乘
        for (int i = num2.length()-1; i >= 0 ; i--) {
            //保存临时结果
            StringBuilder temp = new StringBuilder();
            //补0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append("0");
            }
            //当前从num2中取得的数
            int n2 = num2.charAt(i)-'0';
            //进位
            int carry = 0;

            for (int j = num1.length()-1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j);
                int pro = (n1*n2+carry)%10;
                temp.append(pro);
                carry = (n1*n2+carry)/10;
            }
            res = addStrings(res,temp.reverse().toString());
        }
        return res;
    }

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


