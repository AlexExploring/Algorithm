package BinarySearch;

/**
 * �����������в���Ŀ�����֣�����Ҫ���ҵ����ֳ��ֵĴ�����
 *
 * ��LC34��ͬ����ֻ�Ƿ���ֵ��һ��
 */
public class JZ53I {

    /**
     * ����
     */
    public int search(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) res++;
        }
        return res;
    }

    /**
     * ���ֲ������ҵ�һ��Ŀ�����֣�����������չ
     */
    public int search1(int[] nums, int target) {
        if (nums.length == 0) return 0;

        int low = 0, high = nums.length - 1, mid = 0, flag = 0;

        while (low <= high) {
            mid = (high - low) / 2 + low;
            if (nums[mid] < target) low = mid + 1;
            else if (nums[mid] > target) high = mid - 1;
            else if (nums[mid] == target) {
                flag = 1;
                break;
            }
        }

        //��mid����������չ��i����j����
        int i = mid, j = mid + 1, res = 0;
        if (flag == 1) {
            while (i >= 0 && nums[i] == target) {
                i--;
                res++;
            }
            while (j <= nums.length - 1 && nums[j] == target) {
                j++;
                res++;
            }
        } else return 0;

        return res;
    }

    /**
     * �ҵ���������Ŀ�����ֵ�һ����߽磬һֱ������չ��ֱ��û��Ŀ������
     */
    public int search2(int[] nums, int target) {
        int len = nums.length;

        //����nums��һ����С��Ŀ��ֵ�������±꣬��߽�
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        int left = l;
        //�����߽� >= len,˵��nums��û��target��ֱ�ӷ���0
        if (left >= len) return 0;

        //����nums�е�һ������Ŀ��ֵ�������±꣬�ұ߽�
        l = 0;
        r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        //��ʱlָ��ľ����ұ߽�
        return l - left;
    }

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        System.out.println(new JZ53I().search3(nums, 8));
    }

    /**
     * �Ż�search2
     */
    public int search3(int[] nums, int target) {
        return helper(nums,target) - helper(nums,target-1);
    }

    /**
     * ����nums�е�һ������Ŀ��ֵ�������±�
     */
    public int helper(int [] nums,int target) {
        int l = 0,r = nums.length-1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (nums[mid] <= target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }
}
