package JZOF.string;

/**
 *替换空格
 */
public class JZ5 {
    public static void main(String[] args) {
        System.out.println(replaceSpace1("We are happy."));
    }

    /**
     *StringBuffer 或者 StringBuilder
     */
    public static String replaceSpace1(String s) {
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=' ') ans.append(s.charAt(i));
            else  ans.append("%20");
        }
        return ans.toString();
    }

    /**
     *效率最低，
     */
    public static String replaceSpace2(String s){
        return s.replaceAll(" ","%20");
    }

    /**
     * 开始的时候直接创建一个足够大的数组，用来存储结果，再用一个size来记录
     * 修改后的字符串的真实长度。
     */
    public static String replaceSpace3(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }
}
