package TwoPointers;

/**
 * �����ˮ������
 */


/**
 *  ��ȷ��֤����
 * ������ö�٣�ˮ������Χ�����S(i,j) ��״̬����Ϊ C(n,2) ��
 *
 * ����״̬ S(i,j) �� h[i]<h[j] ���������ƶ��̰��� S(i+1,j) �����൱����ȥ�� {S(i, j - 1), S(i, j - 2), ... , S(i, i + 1)}
 * ״̬���ϡ���������ȥ״̬�����һ����С�ڵ�ǰ������� < S(i, j)<S(i,j)������Ϊ��Щ״̬��
 *
 * �̰�߶ȣ����S(i,j) ��ͬ����̣��� ��h[i] ����
 * �ױ߿�ȣ����S(i,j) ���̣�
 * ��ˣ�ÿ�������ƶ��̰壬������ȥ��״̬�� ���ᵼ��������ֵ��ʧ ��֤�ϡ�
 */
public class LC11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }
}
