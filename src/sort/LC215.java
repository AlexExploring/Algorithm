package sort;

import java.util.Random;

/**
 * �����еĵ�K�����Ԫ��
 */
public class LC215 {

    /**
     * ð��������ǰ����
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;

        //ֻ��Ҫk�֣�����ȷ����k�������
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums,j,j+1);
                }
            }
        }

        return nums[len - k];
    }

    /**
     * ���������� + ���������
     */
    public int findKthLargest1(int[] nums, int k) {
        //nums.length()-k ��Ϊ������k���±꣬Ҳ��Ϊ��K������ֵ��±�
        return quickSort(nums,0,nums.length-1,nums.length-k);
    }

    public int quickSort(int[] nums, int l, int r,int index) {
        int pos = randomPartition(nums, l, r);
        if (pos == index) {
            return nums[pos];
        }else {
            if (pos < index) return quickSort(nums,pos+1,r,index);
            else return quickSort(nums,l,pos-1,index);
        }
    }

    private Random random = new Random();

    public int randomPartition(int[] nums, int l, int r) {
        // ���ѡһ����Ϊ���ǵ���Ԫ
        int pivot = random.nextInt(r - l + 1) + l;
        // ����r,i����Ԫ��
        swap(nums, r, pivot);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int key = nums[r],i = l - 1;
        for (int j = l; j < r; ++j) {
            if (nums[j] <= key) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    public void swap(int [] array,int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * ������ʹ�����ȶ��н��
     */
}
