package sort;

import java.util.Collections;
import java.util.List;

/**
 * ��Сʱ���
 */
public class LC539 {

    /**
     * �� timePoints �������Сʱ����Ȼ������timePoints ����������ʱ�䣬
     * ���� timePoints ��������βʱ���С�
     */
    public int findMinDifference(List<String> timePoints) {
        // ����ʱ�侫ȷ�����ӣ����timePoints�ĳ��ȳ���1440�����Ȼ���ظ���ʱ�䣬��ֵΪ0
        if (timePoints.size() > 1440) {
            return 0;
        }

        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < timePoints.size(); ++i) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes); // ����ʱ���ʱ���
            preMinutes = minutes;
        }
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes); // ��βʱ���ʱ���
        return ans;
    }

    /**
     * ��ȡ 00:00 ��ʽʱ��ķ�������
     */
    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }
}
