package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据身高重建队列
 *
 * 题目：每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 */
public class LC406 {

    public static void main(String[] args) {
        int [][] person = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        new LC406().reconstructQueue(person);
    }

    /**
     * 先按照hi降序、ki升序进行排序，
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
            //按照ki进行插入，保证当前person前面有ki个人即可
            list.add(person[1],person);
        }

        return list.toArray(new int[list.size()][]);
    }
}