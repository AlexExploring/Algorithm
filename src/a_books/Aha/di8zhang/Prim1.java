package a_books.Aha.di8zhang;

import java.util.Arrays;

//使用堆优化，适用于稀疏图
//使用堆优化时间复杂度
public class Prim1 {
    static int [] h = new int[7];//用来保存堆
    static int [] pos = new int[7];//pos用来存储每个顶点在堆中的位置
    static int [] dis = new int[7];
    static int [] book = new int[7];
    static int size;//堆的大小
    public static void main(String[] args) {
        Arrays.fill(book,0);


    }

    public static void siftdown(int i){//传入一个需要向下调整的节点编号i，这里传入1，即从堆的顶点开始调整
        int t,flag=0;//flag用来标记是否需要继续向下调整
        while (i*2 <= size && flag == 0){
            if (dis[h[i]] > dis[h[i*2]])//先比较左节点
                t = i*2;
            else
                t = i;
            if (i*2+1 <= size){//是否有右节点
                if (h[t] > h[i*2+1])
                    t = i*2+1;
            }
            if (t!=i){//如果发现最小的节点的编号不是自己，说明子节点中有比父节点更小的
                swap(t,i);
                i = t;
            }
            else flag = 1;
        }
    }
    /**
     * 新增一个值*/
    public static void siftup(int i,int [] h){//传入一个需要向上调整的节点编号i
        int flag = 0;
        if (i == 1) return;  //

        while (i != 1 && flag == 0){
            if (h[i] < h[i/2])
                swap(i,i/2);
            else
                flag = 1;
            i = i/2;//更新编号i为它父节点的编号，从而便于下一次继续向上调整
        }
    }

    public static int pop(){
        int t = h[1];
        pos[t] = 0;
        h[1] = h[size];
        pos[h[1]] = 1;
        size--;
        siftdown(1);
        return t;
    }

    public static void swap(int x,int y){
        int temp = h[y];
        h[y] = h[x];
        h[x] = temp;

        temp = pos[h[x]];
        pos[h[x]] = pos[h[y]];
        pos[h[y]] = temp;
    }
}
