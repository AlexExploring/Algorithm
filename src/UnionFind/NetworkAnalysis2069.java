package UnionFind;

import java.util.Arrays;
import java.util.Scanner;

public class NetworkAnalysis2069 {
    static int[] ans;
    static int[][] map;
    static int[] book;
    public static void main(String[] args) {
        /**
         * @param len 表示节点数量
         * @param m 表示数据的组数
         *@param ans 存储了最终结果
         * @param map 根据输入的数据建立的图
         * @param book
         */
        Scanner scan = new Scanner(System.in);
        int m = 0;
        int len = scan.nextInt();
        m = scan.nextInt();
        map = new int[len+1][len+1];
        book = new int[len+1];
        ans = new int[len+1];
//        初始化地图
//        map[i][j]==1表示两点是连通的
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (i == j) map[i][j] = 1;
            }
        }

        int a = 0,b = 0,c = 0;
        for (int i = 0; i < m; i++) {
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();
            if (a == 1){
                if (b == c) {
                    continue;
                }
                else {
                    map[b][c] = 1;map[c][b] = 1;
                }
            }else{
                Arrays.fill(book,0);
                dfs(b,c);
            }
        }

        System.out.println();
        for (int i = 1; i <= len; i++) {
            if(i!=len){
                System.out.print(ans[i]+" ");
            }else{
                System.out.print(ans[i]);
            }
        }
    }

    public static void dfs(int b,int c){
        for (int i = 1; i < ans.length; i++) {//一共只有ans.length个点
            if (map[b][i] == 1 && book[i] == 0){//如果在该轮搜索中该点没有被访问过并且b到i是连通的
                ans[i]+=c;
                book[i] = 1;
                if (b != i){//判断i点是否与其他点连通
                    dfs(i,c);
                }
            }
        }
    }
}
