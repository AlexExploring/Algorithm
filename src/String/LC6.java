package String;


import java.util.ArrayList;
import java.util.List;

/**
 *Z字形变换
 */
public class LC6 {
    public static void main(String[] args) {
        System.out.println(convert1("PAYPALISHIRING",4));
    }

    /**
     *按行排序
     */
    public static String convert(String s, int numRows) {
        if(numRows==1) return s;

        List<StringBuffer> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuffer());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            //当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
            if (curRow==0||curRow==numRows-1) goingDown = !goingDown;
            curRow += goingDown ? 1: -1;
        }

        StringBuffer ans = new StringBuffer();
        for (StringBuffer row : rows) {
            ans.append(row);
        }
        return ans.toString();
    }


    /**
     *按行访问
     */
    public static String convert1(String s, int numRows) {
        if (numRows==1) return s;

        int step = numRows*2-2;
        int index = 0;
        int len = s.length();
        int add = 0;
        StringBuffer ans = new StringBuffer();

        for (int i = 0; i < numRows; i++) {
            index = i;
            add = i*2;
            while (index<len){
                ans.append(s.charAt(index));
                add = step-add;
                index += (i==0||i==numRows-1) ? step : add;
            }
        }

        return ans.toString();
    }
}