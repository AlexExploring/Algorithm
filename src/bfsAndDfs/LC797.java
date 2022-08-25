package bfsAndDfs;

import java.util.*;

/**
 * ���п��ܵ�·��
 *
 * graph�洢����һ�������޻�ͼ
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
        //x == dest ˵���ҵ���һ��·��
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