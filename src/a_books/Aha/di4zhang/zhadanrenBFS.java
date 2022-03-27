package a_books.Aha.di4zhang;
//#############
//#GG.GGG#GGG.#
//###.#G#G#G#G#
//#.......#..G#
//#G#.###.#G#G#
//#GG.GGG.#.GG#
//#G#.#G#.#.#.#
//##G...G.....#
//#G#.#G###.#G#
//#...G#GGG.GG#
//#G#.#G#G#.#G#
//#GG.GGG#G.GG#
//#############

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//炸弹人
public class zhadanrenBFS {
    static char [][] a = new char[20][21];
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int [][] book = new int[20][20];
        int next[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int m = 13,n = 13,startx = 3,starty = 3,tx,ty,sum;

        File f = new File("C:\\Users\\ZhangHaixia\\IdeaProjects\\Suanfa\\src\\sousuo\\zdrSJ");
        FileReader fre = new FileReader(f);
        BufferedReader bre = new BufferedReader(fre);
        String str = "";
        int i = 0;
        while ((str = bre.readLine()) != null){
            a[i] = str.toCharArray();
            i++;
        }

        bfsQueue queue = new bfsQueue(1,1);
        bfsnode startNode = new bfsnode();
        startNode.x = startx;
        startNode.y = starty;
        queue.data[queue.tail] = startNode;
        queue.tail++;

        book[startx][starty] = 1;
        int max = getNum(startx,starty);
        int mx = startx;
        int my = starty;

        while (queue.head < queue.tail){
            for (i = 0; i <= 3; i++) {
                tx = queue.data[queue.head].x+next[i][0];
                ty = queue.data[queue.head].y+next[i][1];

                //判断是否越界
                if (tx < 0 || tx > m-1 || ty < 0 || ty > n-1)
                    continue;
                if (a[tx][ty] == '.'&&book[tx][ty]==0){
                    book[tx][ty] = 1;
                    bfsnode newNode = new bfsnode();
                    newNode.x = tx;
                    newNode.y = ty;
                    queue.data[queue.tail] = newNode;
                    queue.tail++;

                    sum = getNum(tx,ty);
                    if (sum > max){
                        max = sum;
                        mx = tx;
                        my = ty;
                    }
                }
            }
            queue.head++;
        }
        System.out.println(String.format("将炸弹放置在(%d,%d)处，可以消灭%d个敌人\n",mx,my,max));
    }

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

class bfsnode{
    int x;
    int y;
}

class bfsQueue{
    bfsnode [] data = new bfsnode[401];
    int head,tail;

    public bfsQueue(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }
}