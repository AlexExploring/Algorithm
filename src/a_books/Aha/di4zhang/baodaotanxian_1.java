package a_books.Aha.di4zhang;

import java.util.Scanner;

//DFS版本
public class baodaotanxian_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int row = scan.nextInt(),column = scan.nextInt();
        int start_x = scan.nextInt(),start_y = scan.nextInt();
        int [][] map = new int[row][column];
        int [][] book = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        DFS(map,book,row,column,start_x,start_y);
        System.out.println(ans);
    }

    static int ans = 0;
    public static void DFS(int [][] map,int [][] book,int row,
                           int column,int start_x,int start_y){
        int [][] next = {{-1,0},{0,1},{0,-1},{1,0}};

        for (int i = 0; i < 4; i++) {
            int tx = start_x + next[i][0];
            int ty = start_y + next[i][1];

            if (tx < 0 || ty < 0 || tx > row - 1 || ty > column - 1) continue;

            if (book[tx][ty] == 0 && map[tx][ty] > 0) {
                ans++;
                System.out.println("ans="+ans);
                book[tx][ty] = 1;
                DFS(map, book, row, column, tx, ty);//和找路径或者某一个解不同，这里
                // 需要得到的是从起点坐标走完所有可以到达的点
            }
        }
    }
}
