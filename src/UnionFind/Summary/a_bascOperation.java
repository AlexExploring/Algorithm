package UnionFind.Summary;

/**
 *https://blog.csdn.net/weixin_43914593/article/details/104108049
 */
public class a_bascOperation {
    static int maxn = 1050;
    static int s[] = new int[maxn];
    //1
    public static void init(){//初始化 并查集
        for(int i = 1; i <= maxn; i++)
            s[i] = i;
    }
    public static int find(int x){  //查找
        return x==s[x]? x:find(s[x]);
    }

    public static void merge(int x, int y){//合并
        x = find(x);
        y = find(y);
        if(x != y) s[x] = s[y];     //把x合并到y上，y的根成为x的根
    }

    //2
    static int [] height = new int[maxn];
    public static void init1(){//初始化 并查集
        for(int i = 1; i <= maxn; i++)
            s[i] = i;
    }

    //在上面的查询程序find_set()中，查询元素i所属的集，需要搜索路径找到
    // 根结点，返回的结果是根结点。这条搜索路径可能很长。如果在返回的时候，
    // 顺便把i所属的集改成根结点，那么下次再搜的时候，就能在O(1)的时间内得到结果。
    public static int find1(int x){
        if(x != s[x])
            s[x] = find1(s[x]);   //路径压缩
        return s[x];
    }

    //面代码用递归实现，如果数据规模太大，担心爆栈，可以用下面的非递归代码：
    public static int find1_1(int x){
        int r = x;
        while ( s[r] != r ) r=s[r];  //找到根结点
        int i = x, j;
        while(i != r){
            j = s[i];     //用临时变量j记录
            s[i]= r ;     //把路径上元素的集改为根结点
            i = j;
        }
        return r;
    }

    //合并元素x和y时，先搜到它们的根结点，
    // 然后再合并这两个根结点，即把一个根结点的集
    // 改成另一个根结点。这两个根结点的高度不同，如果把高度较小的集合并
    // 到较大的集上，能减少树的高度。下面是优化后的代码，在初始化时用height[i]定
    // 义元素i的高度，在合并时更改。
    public static void merge1(int x,int y){
        x = find1(x);
        y = find1(y);
        if (height[x] == height[y]) {
            height[x] = height[x] + 1;      //合并，树的高度加一
            s[y] = x;
        }
        else{                            //把矮树并到高树上，高树的高度保持不变
            if (height[x] < height[y])  s[x] = y;
            else   s[y] = x;
        }
    }

    //3.带权并查集
    //如果读者联想到树这种数据结构，会发现，并查集实际上是在维护若干棵树。并查集的合并和查询
    // 优化，实际上是在改变树的形状，把原来“细长”的、操作低效的大量“小树”，变成了“粗短”的
    // 、操作高效的少量“大树”。如果在原来的“小树”上，点之间有权值，那么经过并查集的优化之变
    // 成“大树”后，这些权值的操作也变得高效了。
    static int [] d = new int[1050];//权值数组
    //带权值的路径压缩
    public static int find3(int x){
        if(x != s[x]) {
            int t = s[x];            //记录父结点
            s[x] = find3(s[x]);   //路径压缩。递归最后返回的是根结点
            d[x] += d[t];            //权值更新为x到根节点的权值
        }
        return s[x];
    }
    //注意代码中的细节。原来的d[x]是点x到它的父结点的权值，经过路径压缩后，x直接指向根节
    // 点，d[x]也更新为x到根结点的权值。这是通过递归实现的。

    //带权值的合并
    //在合并操作中，把点x与到点y合并，就是把x的根结点fx合并到y的根结点fy。在fx和fy之间增加权值，这个权值要符合题目的要求。

}
