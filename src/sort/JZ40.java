package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  ��С��k���� (k������˳����Ҫ��)
 */
public class JZ40 {

    /**
     * ʹ�����ú������򼴿�
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k>=arr.length) return arr;

        Arrays.sort(arr);

        int [] res = new int[k];

        System.arraycopy(arr,0,res,0,k);

        return res;
    }

    /**
     * ���ڿ�����������黮��
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (arr.length <= k) return arr;
        return quickSort(arr,k,0,arr.length-1);
    }

    public int[] quickSort(int[] array,int k,int left,int right) {

        //ѡ��array[left]Ϊ��׼��,�������ÿ������ĵ�һ��
        int l = left,r = right,key = array[left];

        while(l < r) {
            //�ұߵ�����С��p��ֵʱֹͣѭ��
            while(array[r] >= key && l < r) r--;
            //��ߵ����ִ���p��ֵʱֹͣѭ��
            while(array[l] <= key && l < r) l++;
            swap(array,l,r);
        }

        //�����array[l]һ���Ǵ���array[left](key)�ģ�����l��r������l����ֵһ����С��array[left](key)��(r����)
        array[left] = array[l];
        //����׼���ƶ�����Ӧ���ڵ�λ��
        array[l] = key;
        //�����l��r����ȵģ���array[l]����ֵ�Ѿ��̶������ٲ�������
        // l > k : �����k+1 С�������� �������� �У���ݹ��������飻
        if (l > k) quickSort(array,k,left,l-1);
        // l < k : �����k+1 С�������� �������� �У���ݹ��������飻
        if (l < k) quickSort(array,k,l+1,right);
        // l == k : �����ʱ arr[k] ��Ϊ�� k+1 С�����֣���ֱ�ӷ�������ǰ k �����ּ��ɣ�
        return Arrays.copyOf(array,k);
    }

    public void swap(int [] array,int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * С����
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k >= arr.length) return arr;
        if (k == 0) return new int[0];

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }

        int [] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }

        return res;
    }
}
