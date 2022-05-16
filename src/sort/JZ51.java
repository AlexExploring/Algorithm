package sort;

/**
 *数组中的逆序对
 */
public class JZ51 {
    public static void main(String[] args) {
        //int[] nums = {8, 7, 9, 2, 4};
        int[] nums = {8, 7, 9, 5, 2};
        //int[] nums = {317,206,-112,-9,-224,-207};
        System.out.println(new JZ51().reversePairs1(nums));
    }

    /**
     * 暴力 超出时间限制
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
     * 归并排序
     */
    public int reversePairs1(int[] nums) {
        this.count = 0;
        mergeSort(nums,0,nums.length-1);
        return count;
    }

    private int count;

    /**
     * mergeSort 递归 对两个有序节点序列进行合并来实现排序，分治思想
     */
    public void mergeSort(int[] arr,int left,int right){
        //如果左边索引小于右边就可以一直分，l=r时，就是分到只剩一个数了
        if(left<right){
            int mid = (right - left)/2 + left;
            //向左递归分解
            mergeSort(arr,left,mid);
            //向右递归分解
            mergeSort(arr,mid+1,right);
            //合并
            merge(arr,left,mid,right);
        }
    }

    /**
     * 合并的方法
     * @param arr 待排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边结束索引
     * @return
     */
    public void merge(int[] arr, int left,int mid,int right) {
        //数据中转数组
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid +1;
        int t = 0;//temp数组的当前索引

        //比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (i<=mid && j<=right){
            if(arr[i] <= arr[j]) temp[t++] = arr[i++];
            else {
                count += (mid - i + 1);
                temp[t++] = arr[j++];
            }
        }

        //以下两个while只有一个会执行
        while (i<=mid) temp[t++] = arr[i++];
        while (j<=right) temp[t++] = arr[j++];

        //将temp数组拷贝到arr数组，并不是每次都拷贝所有
        for (t = 0; t < temp.length; t++) {
            arr[left + t] = temp[t];
        }
    }
}