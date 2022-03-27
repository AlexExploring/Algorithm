package JZOF.string;

/**
 *把数字转换成整数
 */
public class JZ67 {
    public static void main(String[] args) {
        System.out.println(strToInt("  "));
    }

    public static int strToInt(String str) {
        str = str.trim();
        if (str.equals("")) return 0;
        int start = 0;
        int max = Integer.MAX_VALUE,min = Integer.MIN_VALUE;
        long res = 0,sign = 1;
        if (str.charAt(0)=='+'||str.charAt(0)=='-') {
            start = 1;
            if (str.charAt(0)=='-') sign = -1;
        }

        while (start<str.length()){
            if (str.charAt(start)>='0'&&str.charAt(start)<='9'){
                res = res * 10 + sign * (str.charAt(start) - '0');
                if (res>max) return max;
                else if (res<min) return min;
            } else return (int) res;
            start++;
        }
        return (int) res;
    }
}
