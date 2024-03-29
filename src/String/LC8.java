package String;

/**
 * 字符串转换整数
 *
 * z
 */
public class LC8 {

    public static int myAtoi(String s) {
        s = s.trim();
        if (s.equals("")) return 0;

        int flag = 0,index = 0;

        if (s.charAt(index)=='-'){
            flag = -1;
            index++;
        }else if (s.charAt(index)=='+'){
            flag = 1;
            index++;
        }else if (!Character.isDigit(s.charAt(index))) {
            return 0;
        }

        int ans = 0;
        //注意处理好边界问题
        while (index < s.length() && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index++) - '0';
            //判断加入digit是否会导致溢出
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return flag < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
        }

        return flag < 0 ? -ans : ans;
    }
}
