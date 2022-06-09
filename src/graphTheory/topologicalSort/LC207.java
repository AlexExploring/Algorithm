package graphTheory.topologicalSort;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程表 相关题目（LC210 课程表II）
 */
public class LC207 {

    // 存储有向图
    List<List<Integer>> edges;
    // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
    int[] visited;
    // 判断有向图是否为无环图,为true表示无环
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //数据初始化 使用edges来存储所有的边
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];

        //已知：0 <= 已知课程编号 < numCourses;
        //如果prerequisites = [[1,0],[2,0],[3,1],[3,2]],numCourses = 4,那么edges中存储的将是
        //[[1,2],[3],[3]];  由 0 -> 1,0 -> 2,1 -> 3,2 -> 3;
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }

        // 每次挑选一个「未搜索」的节点，并且图中没有环,开始进行深度优先搜索
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        return valid;
    }

    /**
     * 使用dfs逆序生成拓扑排序
     */
    public void dfs(int u) {
        // 将节点标记为「搜索中」
        visited[u] = 1;
        // 搜索其相邻节点,只要发现有环，立刻停止搜索
        for (int v: edges.get(u)) {
            // 如果「未搜索」那么搜索相邻节点
            if (visited[v] == 0) {
                dfs(v);
                //剪枝操作，也可不写
                if (!valid) {
                    return;
                }
                // 如果「搜索中」说明找到了环,即尝试搜索正在搜索中的点
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        // 将节点标记为「已完成」
        visited[u] = 2;
    }
}
