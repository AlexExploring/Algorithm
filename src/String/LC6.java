package String;


import java.util.ArrayList;
import java.util.List;

/**
 * Z字形变换
 *
 * z
 */
public class LC6 {

    /**
     * 按照从上往下、从左到右进行 Z 字形排列的顺序依次为每一行添加字符，最后将
     * 所有行拼接起来
     */
    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;

        List<StringBuffer> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuffer());
        }

        int curRow = 0;
        boolean goingDown = false;

        //先将每个字符拼接到应该在的行的末尾
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            //当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1: -1;
        }

        StringBuffer ans = new StringBuffer();
        for (StringBuffer row : rows) {
            ans.append(row);
        }
        return ans.toString();
    }
}