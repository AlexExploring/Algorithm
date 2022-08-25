package bfsAndDfs;

import java.util.*;

/**
 * 所有可能的路径
 *
 * graph存储的是一个有向无环图
 */
public class LC797 {

    public static void main(String[] args) {
        int[][] map = new int[][]{{1,2,3},{3},{3},{4},{}};
        for (int[] ints : map) {
            
        }
    }

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        list.addLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int dest) {
        //x == dest 说明找到了一条路径
        if (x == dest) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int y : graph[x]) {
            list.addLast(y);
            System.out.println(y);
            dfs(graph,y,dest);
            list.removeLast();
        }
    }
}