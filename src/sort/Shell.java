package sort;

import java.util.Arrays;

/**
 * @author zhxspacex
 * @date 2020/12/25 12:27
 */
public class Shell {
    public static void main(String[] args) {
        int [] a = {5,6,4345,3,6,32412,4234,235,562423};
        ShellSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 希尔排序的基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入
     * 排序，待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序。
     */
    public static void ShellSort(int [] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                //对每一组分别进行插入排序
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }

    public static void ShellSort1(int [] array) {
        int len = array.length;
        int temp, gap = len/=2;
        while (gap>0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i-gap;
                while (preIndex >= 0&& array[preIndex] > temp) {
                    array[preIndex+gap] = array[preIndex];
                    preIndex-=gap;
                }
                array[preIndex+gap] = temp;
            }
            gap/=2;
        }
    }
}
