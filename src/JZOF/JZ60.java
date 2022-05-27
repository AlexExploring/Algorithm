package JZOF;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * ��ʱ
 * ʹ�û���  �������
 */
public class JZ60 {

    public static void main(String[] args) {
        double [] res = dicesProbability(3);
        System.out.println(Arrays.toString(res));
    }

    /**
     * ���ݷ�
     *
     * ʱ�临�Ӷ�: O(6^n),
     */
    public static double[] dicesProbability(int n) {
        double all =  Math.pow(6,n);
        HashSet<Integer> set = new HashSet<>();

        back_Track(n,0);

        double [] res = new double[map.size()];
        int i = 0;
        for (Integer key : map.keySet()) {
            res[i++] = Double.parseDouble(df.format(map.get(key)/all));
        }

        return res;
    }

    static HashMap<Integer,Integer> map = new HashMap();
    static int total = 0;
    static DecimalFormat df = new DecimalFormat("0.00000");

    /**
     * �ܹ���nö���ӣ�ÿһö������ 1~6 �������
     */
    public static void back_Track(int n,int cur){
        if (cur == n) {
            map.put(total,map.getOrDefault(total,0)+1);
            return;
        }

        for (int i = 1; i <= 6; i++) {
            total+=i;
            back_Track(n,cur+1);
            total-=i;
        }
    }
}
