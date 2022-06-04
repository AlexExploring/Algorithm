package Top100;

/**
 * 任务调度器
 *
 * 有难度
 *
 * https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
 */
public class LC621 {
    public int leastInterval(char[] tasks, int n) {
        int [] temp = new int[26];
        int countMaxTask = 0;
        int maxTask = 0;

        //拿到任务数量最多的任务的数量
        for (char c : tasks) {
            temp[c - 'A']++;
            maxTask = Math.max(temp[c-'A'],maxTask);
        }

        // 统计每一列，在最后一行是否有任务，借此统计最后一行的任务数量
        for (int i = 0; i < 26; i++) {
             if (temp[i] == maxTask){
                 countMaxTask++;
             }
        }

        return Math.max(tasks.length,(maxTask-1)*(n+1)+countMaxTask);
    }
}
