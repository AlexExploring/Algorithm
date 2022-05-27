package JZOF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ��Ϊs�������������У����ٺ�����������
 *
 * ����һ�������� target ��������к�Ϊ target ���������������У����ٺ�������������
 * �����ڵ�������С�������У���ͬ���а����׸����ִ�С�������С�
 */
public class JZ57II {

    /**
     * ���� ��֦�Ż�
     */
    public static int[][] findContinuousSequence(int target) {
        //data[i] ��dataǰ[0,i]�����ĺ�
        int [] data = new int[target];
        for (int i = 1; i < target; i++) {
            data[i] = data[i-1]+i;
        }

        ArrayList<int[]> res = new ArrayList<>();

        //���ѭ��ö���ұ߽磬�ڲ�ѭ������߽�
        for (int i = 1; i < target/2+1; i++) {
            for (int j = i+1; j < target; j++) {
                int t = data[j] - data[i - 1];
                if (t == target){
                    int[] tmp = new int[j-i+1];
                    //������Ҫ�����������temp��
                    for (int k = i; k <= j; k++) {
                        tmp[k-i] = k;
                    }
                    //��temp���뵽���յĽ����
                    res.add(tmp);
                }else if (t > target) break;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * ˫ָ��
     */
    public int[][] findContinuousSequence1(int target) {
        List<int[]> res=new ArrayList();
        int i=1;
        while(target>0){
            target=target-i++;
            if(target>0&&target%i==0){
                int[] temp=new int[i];
                for(int j=0;j<i;j++) temp[j]=target/i+j;
                res.add(temp);
            }
        }

        int[][] fin = new int[res.size()][];
        for(int k=fin.length-1;k>=0;k--){
            fin[fin.length-k-1]=res.get(k);
        }
        return fin;
    }
}
