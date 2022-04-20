package JZOFII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 所有路径 （和LC797相同）
 */
public class JZ110 {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int dest) {
        //x == dest 说明找到了一条路径
        if (x == dest) {
            ans.add(new ArrayList<>(stack));
            return;
        }

        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph,y,dest);
            stack.pollLast();
        }
    }
}
