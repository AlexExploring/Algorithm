package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ��������ؽ�����
 *
 * ��Ŀ��ÿ�� people[i] = [hi, ki] ��ʾ�� i ���˵����Ϊ hi ��ǰ�� ���� �� ki ����ߴ��ڻ���� hi ���ˡ�
 */
public class LC406 {

    public static void main(String[] args) {
        int [][] person = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        new LC406().reconstructQueue(person);
    }

    /**
     * �Ȱ���hi����ki�����������
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(int [] person1,int [] person2)->{
            if (person1[0] != person2[0]) {
                return person2[0] - person1[0];
            } else {
                return person1[1] - person2[1];
            }
        });

        for (int[] person : people) {
            System.out.println(Arrays.toString(person));
        }

        List<int []> list = new ArrayList<>();
        for (int[] person : people) {
            //����ki���в��룬��֤��ǰpersonǰ����ki���˼���
            list.add(person[1],person);
        }

        return list.toArray(new int[list.size()][]);
    }
}