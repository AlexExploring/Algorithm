package DP.array;

/**
 * ������
 */
public class LC312 {

    public static void main(String[] args) {
        int [] nums = new int[]{3,1,5,8};
        System.out.println(new LC312().maxCoins(nums));
    }

    /**
     * dp[i][j]: ��ʾ���ƿ�����(i,j)�ڵ����򣬿��Ի�õ��������
     *
     * ��⣺https://leetcode.cn/problems/burst-balloons/solution/zhe-ge-cai-pu-zi-ji-zai-jia-ye-neng-zuo-guan-jian-/
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        //Ϊ�˱���Խ�磬���ʹ����д�Ѷȣ�ʹ��val���洢nums�е�����������Ԥ����
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }

        //ö��������
        for (int i = n - 1; i >= 0; i--) {
            //ö���ҿ�����
            for (int j = i + 2; j <= n + 1; j++) {
                //�����ڵ�����һ�������п������һ��������
                for (int k = i + 1; k < j; k++) {
                    //���Ƶ�ǰ�����õĽ��
                    int sum = val[i] * val[k] * val[j];
                    //���ڼ��赱ǰ���Ƶ�k�ǵ�ǰ��������һ���������Ե�ǰ��������߱�Ȼ��
                    // �������ƣ���ֵ�Ѿ����������
                    sum += rec[i][k] + rec[k][j];
                    //��֤rec[i][j],�Ǵ��Ƶĵ�ǰ�����������������ܻ�õ��������
                    rec[i][j] = Math.max(rec[i][j], sum);
                    for (int[] ints : rec) {
                        for (int anInt : ints) {
                        }
                    }
                }
            }
        }

        return rec[0][n + 1];
    }
}
