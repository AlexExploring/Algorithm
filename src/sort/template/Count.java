package sort.template;

/**
 * @author zhxspacex
 * @date 2020/12/25 12:29
 */

import java.util.Arrays;

/**
 * ���������飺��������ĺ������ڽ����������ֵת��Ϊ���洢�ڶ��⿪�ٵ�����ռ��С�
 * ��Ϊһ������ʱ�临�Ӷȵ����򣬼�������Ҫ����������ݱ�������ȷ����Χ��������
 */
public class Count {

    public static void main(String[] args) {

    }

    private int[] countingSort(int[] array) {
        //��Ҫȷ�����ֵ������ʹ������������
        int max = Arrays.stream(array).max().getAsInt();
        int bucketLen = max + 1;
        int[] bucket = new int[bucketLen];

        for (int value : array) {
            bucket[value]++;
        }

        int index = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                array[index++] = j;
                bucket[j]--;
            }
        }

        return array;
    }

}
