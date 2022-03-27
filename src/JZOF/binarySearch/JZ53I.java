package JZOF.binarySearch;

/**
 *�����������в���Ŀ������
 */
public class JZ53I {
    public static void main(String[] args) {
        int [] nums = {1};
        System.out.println(search1(nums,1));
    }

    /**
     *����
     */
    public int search(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target==nums[i]) res++;
        }
        return res;
    }

    /**
     *���ҵ�һ��Ŀ�����֣�����������չ
     */
    public static int search1(int[] nums, int target) {
        if (nums.length==0) return 0;
        int low = 0,high = nums.length-1,mid = 0,flag = 0;
        while (low<=high){
            mid = (low+high)/2;
            if (nums[mid]<target) low = mid+1;
            else if (nums[mid]>target) high = mid-1;
            else if (nums[mid]==target) {
                flag=1;break;
            }
        }

        int i = mid,j = mid+1,res = 0;
        if (flag==1){
            while (i>=0&&nums[i]==target) {
                i--;res++;
            }
            while (j<=nums.length-1&&nums[j]==target){
                j++;res++;
            }
        }else return 0;

        return res;
    }

    /**
     * �ҵ���������Ŀ�����ֵ�һ����߽磬һֱ������չ��ֱ��û��Ŀ������
     */
    public static int search2(int[] nums, int target) {
        int left =0,right = nums.length-1;
        int count = 0;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>=target)
                right=mid;
            if(nums[mid]<target)
                left = mid+1;
        }
        while(left<nums.length&&nums[left++]==target)
            count++;
        return count;
    }

    /**
     *�Ż�������Լ�����������nums�е�target�������ӽ�nums�ĳ��ȣ��ڼ���count�Ĺ��̵�ʱ�临�ӶȾ���O(N)
     *
     * �����Ż�
     */

    /**
     *����������� �ֱ�ȷ�����ұ߽�  ���ұ߽���Ŀ�����������
     */
    public static int search3(int[] nums, int target) {
        // �����ұ߽� right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;   //�±�i����ָ�����Ҳ�target����һλ
        // ���������� target ������ǰ����
        if(j >= 0 && nums[j] != target) return 0;
        // ������߽� left  ֻ��Ҫ��֤����������ұ߽�jλ�������target����һλ
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;   //�±�j����ָ�������target�ĵ���һλ
        return right - left - 1;
    }

    /**
     *�Ż�search3
     */
    public int search4(int[] nums, int target) {
        //arget-1 ������ȥ���ұ� target С���׸����ֵ��ұ߽�~ ����������־���С���٣������ܲ��ҵ���
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
