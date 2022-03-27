package a_books.Aha.di5zhang;

import java.util.Scanner;

class bfsDemo {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int next[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][] book = new int[51][51];
        int[][] map = new int[51][51];
        int m = 5,n = 4;

        for (int i = 1;i <= m; i++)
            for (int j = 1;j <= n;j++)
                map[i][j] = scan.nextInt();
        int startx = 1,starty = 1;

        int p = 4,q = 3;  //目标位置

        BfsQueue queue = new BfsQueue(1,1);
        BfsNode startNode = new BfsNode();
        startNode.x = startx;
        startNode.y = starty;
        startNode.s = 0;
        queue.data[queue.tail] = startNode;   //给队列写入第一个值，队列扩展
        queue.tail++;
        int flag = 0;

        while (queue.head < queue.tail){
            int tx,ty;

            for (int k = 0;k < 4; k++){
                tx = queue.data[queue.head].x+next[k][0];
                ty = queue.data[queue.head].y+next[k][1];

                //判断是否越界
                if (tx < 1 || tx > m || ty < 1 || ty > n)
                    continue;

                //判断是否是障碍物或者已经在路径中
                if (map[tx][ty] == 0 && book[tx][ty] == 0){
                    book[tx][ty] = 1;
                    BfsNode newNode = new BfsNode();
                    newNode.x = tx;
                    newNode.y = ty;
                    newNode.s = queue.data[queue.head].s + 1;//步数是父亲的步数加一
                    queue.data[queue.tail] = newNode;
                    queue.tail++;
                }

                //如果到目标点了，停止扩展，任务结束，退出循环
                if(tx == p && ty == q) {
                    // 标记为已结束
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                break;
            queue.head++;
        }
        System.out.println(String.format("解救小哈最少需要%d步。", queue.data[queue.tail - 1].s));
    }
}

class BfsNode{
    //自定义节点，表示地图上某个点及其相关信息
    int x,y,s;
    //f是父节点在队列中的编号，输出路径时使用
}

//自定义队列，用来记录探索点位的步骤  这里使用数组来模拟队列
class BfsQueue{
    BfsNode[] data = new BfsNode[2501];
    int head,tail;

    public BfsQueue(int head,int tail){
        this.head = head;
        this.tail = tail;
    }
}