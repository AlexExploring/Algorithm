package sort.template;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhxspacex
 * @date 2020/12/25 12:28
 */
public class Quick {

    public static void main(String[] args) {
        int [] a = {7,5,6,8,2,3};
        new Quick().quickSort4(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 写法一：选取中间节点为基准值
     */
    public static void quickSort(int [] array, int left, int right)
    {
        if (left >= right) return;

        //因为使用的是do while 循环，所以l=left-1,r = right+1, 选用数组区间的中间数key为基准数
        int l = left - 1, r = right + 1, key = array[left + right >> 1];

        while (l < r) {
            //必须先从左向右扫描
            do l++ ; while (array[l] < key);
            do r-- ; while (array[r] > key);
            if (l < r) swap(array,l, r);
        }

        quickSort(array, left, r);
        quickSort(array, r + 1, right);
    }

    /**
     * 写法二：选取中间节点为基准值
     */
    public static void quickSort1(int [] array, int left, int right) {
        if (left >= right) return;

        int l = left,r = right,key = array[left + right >> 1];

        while (l < r) {
            while (array[l] < key) l++;
            while (array[r] > key) r--;
            if (l < r) swap(array,l++,r--);
        }

        quickSort1(array,left,r);
        quickSort1(array,r+1,right);
    }

    /**
     * 写法三：选取每个区间的array[left]作为基准值
     *
     * 效率很低
     */
    public static void quickSort2(int[] array,int left,int right) {
        if(left >= right) return;

        //选用array[left]为基准数,这里就是每个数组的第一个
        int l = left,r = right,key = array[left];

        while(l < r) {
            //右边当发现小于p的值时停止循环
            while(array[r] >= key && l < r) r--;
            //左边当发现大于p的值时停止循环
            while(array[l] <= key && l < r) l++;
            swap(array,l,r);
        }

        //这里的array[l]一定是小于key的，经过l、r交换后l处的值一定是小于key的(r先走)
        array[left] = array[l];
        //将基准数移动到它应该在的位置
        array[l] = key;
        //到这里，l和r是相等的，且array[l]处的值已经固定，不再参与排序
        quickSort2(array,left,r-1);
        quickSort2(array,r+1,right);
    }

    /**
     * 写法四
     */
    public void quickSort4(int[] nums, int l, int r) {
        if (l < r) {
            System.out.println("quickSort4:"+" l="+l+" r="+r+"  "+ Arrays.toString(nums));
            int pos = randomPartition(nums, l, r);
            quickSort4(nums, l, pos - 1);
            quickSort4(nums, pos + 1, r);
        }
    }

    private Random random = new Random();

    /**
     * 引入随机化防止快速排退化
     */
    public int randomPartition(int[] nums, int l, int r) {
        // 随机选一个作为我们的主元
        int i = random.nextInt(r - l + 1) + l;
        // 交换r,i处的元素
        swap(nums, r, i);
        System.out.println("randomPartition:"+" l="+l+" r="+r+"  "+ Arrays.toString(nums));
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int key = nums[r],i = l - 1;
        System.out.println("partition:"+" l="+l+" r="+r+" key="+key+ Arrays.toString(nums));
        for (int j = l; j < r; ++j) {
            if (nums[j] <= key) {
                i = i + 1;
                swap(nums, i, j);
                System.out.println("i="+i+" j="+j+" "+Arrays.toString(nums));
            }
        }
        swap(nums, i + 1, r);
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }

    public static void swap(int [] array,int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

