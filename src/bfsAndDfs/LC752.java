package bfsAndDfs;

import java.util.*;

/**
 * 打开转盘锁
 */
public class LC752 {

    public int openLock(String[] deadends, String target) {
        // 0000 即为目标数字
        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        // 0000 出现在deadends 中，则不可能解开锁
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
            // 按层进行遍历，方便计算step
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for (String nextStatus : get(status)) {
                    // nextStatus 可以由status旋转得到
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
     * 返回正向旋转得到的数字
     */
    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    /**
     * 返回逆向旋转得到的数字
     */
    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    /**
     * 枚举 status 通过一次旋转得到的数字
     */
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char tmp = array[i];
            array[i] = numPrev(tmp);
            ret.add(new String(array));
            array[i] = numSucc(tmp);
            ret.add(new String(array));
            //重置为不旋转的数字
            array[i] = tmp;
        }
        return ret;
    }
}
