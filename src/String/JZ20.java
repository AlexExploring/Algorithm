package String;

/**
 * 表示数值的字符串
 */
public class JZ20 {
    public boolean isNumber(String s) {
        //去除首尾空格
        s = s.trim();

        if (s.length()==0) return false;

        //是否出现数字
        boolean numFlag = false;
        //是否出现小数点
        boolean Not_num_flag = false;
        //是否出现e或E
        boolean eFlag = false;

        for (int i = 0; i < s.length(); i++) {
            //判定为数字，则标记numFlag
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
                //判定为.  需要没出现过 . 并且没出现过 e
            } else if (s.charAt(i) == '.' && !Not_num_flag && !eFlag) {
                Not_num_flag = true;
                //判定为e，需要没出现过e，并且出过数字了
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false，由题目要求，e或E后面必须还有整数，所以不影响结果
                //判定为+-符号，只能出现在第一位或者紧接e后面
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') &&
                    // + 或 - 只能是第一个字符或前一个字符是 e或E
                    (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                //其他情况，都是非法的
            } else {
                return false;
            }
        }

        return numFlag;
    }
}
