package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据身高重建队列
 */
public class LC406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(int [] person1,int [] person2)->{
            if (person1[0] != person2[0]) {
                return person2[0] - person1[0];
            } else {
                return person1[1] - person2[1];
            }
        });

        List<int []> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1],person);
        }
        return list.toArray(new int[list.size()][]);
    }
}
