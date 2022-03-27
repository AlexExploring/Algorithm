package a_books.Aha.di4zhang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//炸弹人
public class zhadanrenDFS {
    static char [][] a = new char[20][21];
    static int m=13,n=13,max,mx,my;
    static int [][] book = new int[20][20];
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int startx=3,starty=3;

        File f = new File("C:\\Users\\ZhangHaixia\\IdeaProjects\\Suanfa\\src\\sousuo\\zdrSJ");
        FileReader fre = new FileReader(f);
        BufferedReader bre = new BufferedReader(fre);
        String str = "";
        int i = 0;
        while ((str = bre.readLine()) != null){
            a[i] = str.toCharArray();
            i++;
        }

        book[startx][starty] = 1;
        max = getNum(startx,starty);

        dfs(startx,starty);

        System.out.println(String.format("将炸弹放置在(%d,%d)处，可以消灭%d个敌人\n",mx,my,max));
    }

    public static void dfs(int x,int y){
        int next[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int tx=0,ty=0,sum;
        sum = getNum(x,y);
        if (sum > max){
            max = sum;
            mx = x;
            my = y;
        }

        for (int i = 0; i <= 3; i++) {
            tx = x+next[i][0];
            ty = y+next[i][1];
            if (tx < 0 || tx > n-1 || ty < 0 || ty > m-1)
                continue;
            if (a[tx][ty] == '.'&& book[tx][ty] == 0){
                book[tx][ty] = 1;
                dfs(tx,ty);
            }
        }
        return;
    }

    /**
     * 计算每个方向能杀死的敌人
     */
    public static int getNum(int i,int j){
        int sum,x,y;
        sum = 0;
        x = i;y = j;
        while (a[x][y] != '#'){
            if (a[x][y] == 'G')
                sum++;
            x--;
        }

        x = i;y = j;
        while (a[x][y] != '#'){
            if (a[x][y] == 'G')
                sum++;
            x++;
        }

        x = i;y = j;
        while (a[x][y] != '#'){
            if (a[x][y] == 'G')
                sum++;
            y--;
        }

        x = i;y = j;
        while (a[x][y] != '#'){
            if (a[x][y] == 'G')
                sum++;
            y++;
        }
        return sum;
    }
}
