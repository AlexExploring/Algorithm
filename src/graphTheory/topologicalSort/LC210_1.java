package graphTheory.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 课程顺序
 *
 * 题目类型：拓扑排序
 */
public class LC210_1 {
    // 存储有向图
    List<List<Integer>> edges;
    // 存储每个节点的入度
    int[] inDegree;
    // 存储答案
    int[] result;
    // 答案下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //数据初始化
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        inDegree = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        //已知：0 <= 已知课程编号 < numCourses;
        //如果prerequisites = [[1,0],[2,0],[3,1],[3,2]],numCourses = 4,那么edges中存储的将是
        //[[1,2],[3],[3]];  由 0 -> 1,0 -> 2,1 -> 3,2 -> 3;
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            //累加每个节点的入度
            ++inDegree[prerequisite[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        // 将所有入度为 0 的节点放入队列中
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        //从入读为0的节点开始遍历
        while (!queue.isEmpty()) {
            // 从队首取出一个节点
            int u = queue.poll();
            // 将入度为0的节点放入答案中
            result[index++] = u;
            //处理相邻的节点
            for (int v: edges.get(u)) {
                //遍历到的节点的入度减一
                --inDegree[v];
                // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}
