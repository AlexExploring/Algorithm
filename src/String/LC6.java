package String;


import java.util.ArrayList;
import java.util.List;

/**
 * Z���α任
 *
 * z
 */
public class LC6 {

    /**
     * ���մ������¡������ҽ��� Z �������е�˳������Ϊÿһ������ַ������
     * ������ƴ������
     */
    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;

        List<StringBuffer> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuffer());
        }

        int curRow = 0;
        boolean goingDown = false;

        //�Ƚ�ÿ���ַ�ƴ�ӵ�Ӧ���ڵ��е�ĩβ
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            //�����������ƶ�����������л������ƶ������������ʱ����ǰ����Żᷢ���ı䡣
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