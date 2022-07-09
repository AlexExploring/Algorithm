package TwoPointers;

/**
 * ʢˮ��������
 */
public class LC11 {

    /**
     * ��ȷ��֤����
     * ������ö�٣�ˮ������Χ�����S(i,j) ��״̬����Ϊ C(n,2) ��
     *
     * ����״̬ S(i,j) �� h[i]<h[j] ���������ƶ��̰��� S(i+1,j) �����൱����ȥ�� {S(i, j - 1), S(i, j - 2), ... , S(i, i + 1)}
     * ״̬���ϡ���������ȥ״̬�����һ����С�ڵ�ǰ������� < S(i, j)<S(i,j)������Ϊ��Щ״̬��
     *
     * �̰�߶ȣ����S(i,j) ��ͬ����̣��� ��h[i] ����
     * �ױ߿�ȣ����S(i,j) ���̣�
     * ��ˣ�ÿ�������ƶ��̰壬������ȥ��״̬�� ���ᵼ��������ֵ��ʧ ��֤�ϡ�
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, ans = 0;

        //���������ƶ��̰壬ֱ�����̰�����
        while(l < r) {
            ans = height[l] <= height[r] ?
                    Math.max(ans, (r - l) * height[l++]):
                    Math.max(ans, (r - l) * height[r--]);
        }

        return ans;
    }
}

