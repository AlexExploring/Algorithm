package a_books.Aha.di4zhang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *相当于是一种扩散
 */
//BFS版本
public class baodaotanxian {

    //节点类
    static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int row = scan.nextInt(),column = scan.nextInt();
        int start_x = scan.nextInt(),start_y = scan.nextInt();
        int [][] map = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        System.out.println(BFS(map,row,column,start_x,start_y));

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(map[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public static int BFS(int [][] map,int row,int column,int start_x,int start_y){
        int ans = 0;
        int [][] next = {{-1,0},{0,1},{0,-1},{1,0}};
        int [][] book = new int[row][column];
        Node node = new Node(start_x,start_y);
        book[start_x][start_y] = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        ans=1;
        while (!queue.isEmpty()){
            Node head = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = head.x + next[i][0];
                int y = head.y + next[i][1];

                if (x<0||y<0||x>row-1||y>column-1) continue;

                if (book[x][y]==0&&map[x][y]>0){
                    book[x][y]=1;
                    map[x][y]=-1;
                    Node newNode = new Node(x,y);
                    queue.offer(newNode);
                    ans++;
                    System.out.println("x="+x+" "+"y="+y+"ans="+ans);
                }
            }
        }
        return ans;
    }
}
