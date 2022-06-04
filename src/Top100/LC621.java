package Top100;

/**
 * ���������
 *
 * ���Ѷ�
 *
 * https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
 */
public class LC621 {
    public int leastInterval(char[] tasks, int n) {
        int [] temp = new int[26];
        int countMaxTask = 0;
        int maxTask = 0;

        //�õ����������������������
        for (char c : tasks) {
            temp[c - 'A']++;
            maxTask = Math.max(temp[c-'A'],maxTask);
        }

        // ͳ��ÿһ�У������һ���Ƿ������񣬽��ͳ�����һ�е���������
        for (int i = 0; i < 26; i++) {
             if (temp[i] == maxTask){
                 countMaxTask++;
             }
        }

        return Math.max(tasks.length,(maxTask-1)*(n+1)+countMaxTask);
    }
}
