package sort.template;

import java.util.Arrays;

/**
 * 选择排序
 *
 * 总结：
 * 算法思想 1：贪心算法：每一次决策只看当前，当前最优，则全局最优。
 * 注意：这种思想不是任何时候都适用。
 *
 * 算法思想 2：减治思想：外层循环每一次都能排定一个元素，问题的规模
 * 逐渐减少，直到全部解决，即「大而化小，小而化了」。运用「减治思想」
 * 很典型的算法就是大名鼎鼎的「二分查找」。
 *
 * 优点：交换次数最少。
 *
 * 「选择排序」看起来好像最没有用，但是如果在交换成本较高的排序任务中，就可以使用「选择排序」
 *
 * 复杂度分析：时间复杂度：O(N^2)，这里 N 是数组的长度；
 * 空间复杂度：O(1)，使用到常数个临时变量。
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
        int len = array.length;
        //只需要len-1趟排序，就可以确定len个数的位置
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i; j < len; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            swap(array,i,minIndex);
        }
    }

    public static void swap(int [] array,int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
