package sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Selection {
    public static void main(String[] args) {
        int [] a = {5,6,4345,3,6,32412,4234,235,562423};
        SelectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再
     * 从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此
     * 类推，直到所有元素均排序完毕。
     */
    public static void SelectionSort(int [] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
