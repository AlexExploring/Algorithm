package sort.templates;

import java.util.Arrays;

/**
 * @author zhxspacex
 * @date 2020/12/25 12:16
 */
public class Insertion {
    public static void main(String[] args) {
        int [] a = {5,6,4345,3,6,32412,4234,235,562423};
        InsertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void InsertionSort(int [] array){
        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                //后移
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i+1];
            int preIndex = i;
            while (preIndex >= 0 && array[preIndex] > current) {
                // 后移
                array[preIndex+1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] = current;
        }
    }

}
