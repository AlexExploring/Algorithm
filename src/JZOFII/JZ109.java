package JZOFII;

import java.util.*;

/**
 * �������� ����LC752��ͬ����ת������
 */
public class JZ109 {

    public int openLock(String[] deadends, String target) {
        // 0000 ��ΪĿ������
        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        // 0000 ������deadends �У��򲻿��ܽ⿪��
        if (dead.contains("0000")) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer("0000");
        Set<String> seen = new HashSet<String>();
        seen.add("0000");

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for (String nextStatus : get(status)) {
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * ����������ת�õ�������
     */
    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    /**
     * ����������ת�õ�������
     */
    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    /**
     * ö�� status ͨ��һ����ת�õ�������
     */
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            //����Ϊ����ת������
            array[i] = num;
        }
        return ret;
    }
}
