package sort;

/**
 *�����е������
 */
public class JZ51 {
    public static void main(String[] args) {
        //int[] nums = {8, 7, 9, 2, 4};
        int[] nums = {8, 7, 9, 5, 2};
        //int[] nums = {317,206,-112,-9,-224,-207};
        System.out.println(new JZ51().reversePairs1(nums));
    }

    /**
     * ���� ����ʱ������
     */
    public int reversePairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) res++;
            }
        }
        return res;
    }

    /**
     * �鲢����
     */
    public int reversePairs1(int[] nums) {
        this.count = 0;
        mergeSort(nums,0,nums.length-1);
        return count;
    }

    private int count;

    /**
     * mergeSort �ݹ� ����������ڵ����н��кϲ���ʵ�����򣬷���˼��
     */
    public void mergeSort(int[] arr,int left,int right){
        //����������С���ұ߾Ϳ���һֱ�֣�l=rʱ�����Ƿֵ�ֻʣһ������
        if(left<right){
            int mid = (right - left)/2 + left;
            //����ݹ�ֽ�
            mergeSort(arr,left,mid);
            //���ҵݹ�ֽ�
            mergeSort(arr,mid+1,right);
            //�ϲ�
            merge(arr,left,mid,right);
        }
    }

    /**
     * �ϲ��ķ���
     * @param arr �������ԭʼ����
     * @param left ����������еĳ�ʼ����
     * @param mid �м�����
     * @param right �ұ߽�������
     * @return
     */
    public void merge(int[] arr, int left,int mid,int right) {
        //������ת����
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid +1;
        int t = 0;//temp����ĵ�ǰ����

        //�Ƚ����������ֵ�Ԫ�أ��ĸ�С�����Ǹ�Ԫ������temp��
        while (i<=mid && j<=right){
            if(arr[i] <= arr[j]) temp[t++] = arr[i++];
            else {
                count += (mid - i + 1);
                temp[t++] = arr[j++];
            }
        }

        //��������whileֻ��һ����ִ��
        while (i<=mid) temp[t++] = arr[i++];
        while (j<=right) temp[t++] = arr[j++];

        //��temp���鿽����arr���飬������ÿ�ζ���������
        for (t = 0; t < temp.length; t++) {
            arr[left + t] = temp[t];
        }
    }
}