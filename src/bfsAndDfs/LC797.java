package bfsAndDfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 所有可能的路径
 *
 * graph存储的是一个有向无环图
 */
public class LC797 {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> queue = new ArrayDeque<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        queue.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int dest) {
        //x == dest 说明找到了一条路径
        if (x == dest) {
            ans.add(new ArrayList<>(queue));
            return;
        }

        for (int y : graph[x]) {
            queue.offerLast(y);
            dfs(graph,y,dest);
            queue.pollLast();
        }
    }
}