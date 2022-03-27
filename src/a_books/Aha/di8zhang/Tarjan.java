package a_books.Aha.di8zhang;
/**
 * 割点算法*/
import java.util.Scanner;

//对一个图进行深度优先遍历将会得到这个图的一个生成树（并不一定是最小生成树）
/**
 *时间复杂度O(n2);因为边的处理就需要N2的时间,应该使用邻接表来存储，这样整个算法的时间复杂度O（N+M）
 */
public class Tarjan {
    static int n,m,root;
    static int [][] e = new int[9][9];
    static int [] num = new int[9];
    static int [] low = new int[9];
    static int [] flag = new int[9];
    static int index;//index用来进行时间戳的递增

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x,y;
        n = scan.nextInt();
        m = scan.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                e[i][j]=0;
            }
        }

        for (int i = 1; i <= m; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            e[x][y] = 1;
            e[y][x] = 1;
        }

        root = 1;
        dfs(1,root);

        for (int i = 1; i <= n; i++) {
            if (flag[i] == 1)
                System.out.print(i);
        }

    }


    public static void dfs(int cur,int father){//传入当前顶点编号和父顶点的编号
        int child = 0;//用来记录在生成树中当前顶点cur的儿子个数
        index++;
        num[cur] = index;//当前顶点cur的时间戳
        low[cur] = index;//当前顶点cur能访问到最早顶点的时间戳，刚开始是自己
        for (int i = 1; i <= n; i++) {//枚举与当前顶点cur有边相连的顶点i
            if (e[cur][i] == 1){
                if (num[i] == 0){//说明i点还没有被访问过，就对该点进行dfs
                    child++;
                    dfs(i,cur);

                    low[cur] = Math.min(low[cur],low[i]);//检测以cur进为父节点进行dfs时，cur是否绕过父顶点回到之前的点
                    //即，

                    if (cur != root && low[i] >= num[cur])
                        flag[cur]=1;

                    if (cur == root && child == 2)  //如果与起始点连通的点有两个，则该起始点也肯定是一个割点
                        flag[cur] = 1;
                }
                else if (i != father){//i点曾经被访问过，并且这个顶点不是当前顶点cur的父亲，则需要更新
                    //当前节点cur能否访问到更早顶点的时间戳
                    low[cur] = Math.min(low[cur],num[i]);
                }
            }
        }
    }
}
