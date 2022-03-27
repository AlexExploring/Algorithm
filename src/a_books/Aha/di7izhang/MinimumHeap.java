package a_books.Aha.di7izhang;

import java.util.Scanner;

public class MinimumHeap {
    static int num; //堆的大小
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        num = n;
        int [] a = new int[n+1];
        int [] h = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }
        create2(h,a);
        heapSort(h);
        for (int i = 1; i <= n; i++) {
            System.out.print(h[i]+" ");
        }
    }

    /**
     *从最后一个节点开始，依次判断以这个节点为根的子树是否符合最大堆或最小堆的特性，如果所有子树都符合最大
     * 堆或最小堆的特性.那么整棵树就是最大堆了。因为所有叶节点都没有子节点，即，所有叶节点已经满足最大堆或
     * 最小堆特性，可以直接跳过。
     *
     * 建立堆的时间复杂度为O(N)
     */
    public static void create1(int [] h){
        //从最后一个非叶节点到第一个节点依次向上进行调整
        for (int i = num/2; i >= 1; i--) {
            siftdown(i,h);
        }
    }

    /**
     *从空堆开始，然后依次往堆中插入每一个元素  然后将其维护为最大堆或最小堆
     */
    public static void create2(int [] h,int [] a){
        for (int i = 1; i <= num; i++) {
            h[i] = a[i];
            System.out.println("a[i]="+a[i]);
            siftup(i,h);
            for (int j = 1; j <= i; j++) {
                System.out.println("h["+j+"]="+h[j]);
            }
        }
    }

    /**
     *每次返回堆顶的值，并将该项从堆中删除。
     *
     * 也可以每一次将堆顶的值放入一个数组中，最后再集中输出
     *
     * 当堆是最小堆时，就是从小到大排序，若是最大堆，就是从大到小排序
     */
    public static int deletePeek(int [] h){
        int t = h[1];
        h[1] = h[num];
        num--;
        siftdown(1,h);//在这里维护为最小堆
        return t;
    }

    /**
     *当堆是最小堆时，即为从大到小排序，当堆是最大堆时，即为从小到大排序
     */
    public static void heapSort(int [] h){
        while (num > 1){
            swap(1,num,h);
            num--;
            siftdown(1,h);//维护堆为最小堆
        }
    }


    //建立最小堆
    //从上向下调整
    public static void siftdown(int i,int [] h){//传入一个需要向下调整的节点编号i，这里传入1，即从堆的顶点开始调整
        int t,flag=0;//flag用来标记是否需要继续向下调整
        while (i*2 <= num && flag == 0){
            if (h[i] > h[i*2])//先比较左节点
                t = i*2;
            else
                t = i;
            if (i*2+1 <= num){//是否有右节点
                if (h[t] > h[i*2+1])
                    t = i*2+1;
            }
            if (t!=i){//如果发现最小的节点的编号不是自己，说明子节点中有比父节点更小的
                swap(t,i,h);
                i = t;
            }
            else flag = 1;
        }
    }

    /**
     * 新增一个值
     * 维护最小堆*/
    public static void siftup(int i,int [] h){//传入一个需要向上调整的节点编号i
        int flag = 0;
        if (i == 1) return;  //

        while (i != 1 && flag == 0){
            if (h[i] < h[i/2])
                swap(i,i/2,h);
            else
                flag = 1;
            i = i/2;//更新编号i为它父节点的编号，从而便于下一次继续向上调整
        }
    }

    public static void swap(int t,int i,int [] h){
        int temp = h[i];
        h[i] = h[t];
        h[t] = temp;
    }
}
