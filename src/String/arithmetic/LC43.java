package String.arithmetic;

/**
 * 字符串相乘
 * 相关题目：LC415
 */
public class LC43 {
    public static void main(String[] args) {
        new LC43().multiply("1234","567");
    }

    /**
     * 方法一：做加法
     *
     * 1. 如果 num1和num2之一是 0，则直接将 0 作为结果返回即可。
     * 2. 如果 num1和num2都不是 0，则可以通过模拟「竖式乘法」的方法计算乘积。
     * 需要注意的是，num2除了最低位以外，其余的每一位的运算结果都需要补 0。见
     * 图LC43.png
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        String res = "0";

        //从num2的最后一位开始逐位和num1相乘
        for (int i = num2.length() - 1; i >= 0 ; i--) {
            //保存临时结果
            StringBuilder temp = new StringBuilder();
            //补0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append("0");
            }
            System.out.println("temp:"+temp);
            //当前从num2中取得的数
            int n2 = num2.charAt(i)-'0';
            //进位
            int carry = 0;

            for (int j = num1.length()-1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j)-'0';
                int cur = (n1*n2+carry)%10;
                temp.append(cur);
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
            if (i >= 0) carry += num1.charAt(i--) - '0';
            if (j >= 0) carry += num2.charAt(j--) - '0';
            res.append(carry%10);
            carry /= 10;
        }
        return res.reverse().toString();
    }

    /**
     * 方法二：优化竖式
     */
    public String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int [] res = new int[num1.length()+num2.length()];

        for (int i = num1.length()-1; i >= 0 ; i--) {
            int n1 = num1.charAt(i)-'0';
            for (int j = num2.length()-1; j >= 0 ; j--) {
                int n2 = num2.charAt(j)-'0';
                //res[i+j+1 考虑之前的计算产生的进位
                int sum = (res[i+j+1]+n1*n2);
                res[i+j+1] = sum%10;
                res[i+j] += sum/10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            //去除前导0
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }

        return result.toString();
    }

}


