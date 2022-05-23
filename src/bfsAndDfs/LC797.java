package bfsAndDfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * ���п��ܵ�·��
 *
 * graph�洢����һ�������޻�ͼ
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
        //x == dest ˵���ҵ���һ��·��
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