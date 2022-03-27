package a_books.Aha.di4zhang;

import java.util.Scanner;

//种子填充法，求有多少个独立的小岛
public class FloodFill {

    static int[][] map,book;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int row = scan.nextInt(),column = scan.nextInt();
        map = new int[row][column];
        book = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                map[i][j] = scan.nextInt();
            }
        }


        //对地图上的每一点尝试进行着色
        int color = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j]>0){
                    color--;
                    book[i][j]=1;
                    DFS(row,column,i,j,color);
                }
            }
        }

        System.out.println();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(map[i][j]+"        ");
            }
            System.out.println();
        }
    }

    public static void DFS(int row,int column,int x,int y,int color){
        int [][] next = {{-1,0},{0,1},{0,-1},{1,0}};
        map[x][y]=color;
        for (int i = 0; i < 4; i++) {
            int tx = x + next[i][0];
            int ty = y + next[i][1];

            if (tx < 0 || ty < 0 || tx > row - 1 || ty > column - 1) continue;

            if (book[tx][ty] == 0 && map[tx][ty] > 0) {
                book[tx][ty] = 1;
                DFS(row, column, tx, ty,color);
            }
        }
    }
}
