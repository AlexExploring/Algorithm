package a_books.Aha.di8zhang;
/**
 * 割边算法*/

/**
 *实际应用中应该使用邻接表来存储图
 */
import java.util.Scanner;

public class Tarjan1 {
    static int n,m,root;
    static int [][] e = new int[9][9];
    static int [] num = new int[9];
    static int [] low = new int[9];
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

                    low[cur] = Math.min(low[cur],low[i]);//检测对cur进行dfs时，cur是否绕过父顶点回到之前的点
                    if (low[i] > num[cur])//low[i]>=num[cur]表示的是点i不可能在不经过父节点u而回到祖先(包括父亲)的，
                        //而low[i] > num[cur]表示连父亲都回不到了。倘若顶点i不能回到祖先，也没有另外一条路能回到父亲，那么
                        //i-cur这条边就是割边
                        System.out.println(String.format("%d-%d",cur,i));
                }
                else if (i != father){//i点曾经被访问过，并且这个顶点不是当前顶点cur的父亲，则需要更新
                    //当前节点cur能否访问到更早顶点的时间戳
                    low[cur] = Math.min(low[cur],num[i]);
                }
            }
        }
    }
}
