package String;

/**
 *  把数字转换成整数
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
                //溢出了，直接返回最大值或最小值即可
                if (res > max) return max;
                else if (res < min) return min;
                //不是数字了，提前返回
            } else return (int) res;
            index++;
        }

        return (int) res;
    }
}

