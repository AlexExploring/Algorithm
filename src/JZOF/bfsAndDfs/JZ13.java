package JZOF.bfsAndDfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *机器人的运动范围
 *
 * 使用BFS
 *
 * 耗时5 ms
 */
public class JZ13 {

    public static void main(String[] args) {
        System.out.println(movingCount(2,3,1));
    }

    public static int movingCount(int m, int n, int k) {
        if (k==0) return 1;
        boolean [][] used = new boolean[m][n];
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,0));
        used[0][0] = true;
        int ans = 1; //用来记录能访问到的点的个数
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            int tx,ty;
            for (int i = 0; i < 2; i++) {
                tx = temp.x+next[i][0];
                ty = temp.y+next[i][1];

                if (tx<0 || tx > m-1 || ty<0 || ty>n-1) continue;

                if (!used[tx][ty]&&util(tx,ty)<=k){
                    used[tx][ty] = true;
                    queue.add(new Node(tx,ty));
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int util(int x,int y){
        int sum = 0;
        while (x!=0){
            sum += (x%10);x/=10;
        }
        while (y!=0){
            sum += (y%10);y/=10;
        }
        return sum;
    }

    // 向右和向下移动
    static int next[][] = {{0,1},{1,0}};

    static class Node{
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
