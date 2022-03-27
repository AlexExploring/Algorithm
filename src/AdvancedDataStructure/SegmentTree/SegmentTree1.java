package AdvancedDataStructure.SegmentTree;

import java.util.Scanner;
/**
 *线段树也是一个二叉树
 */
public class SegmentTree1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            data[i] = scan.nextInt();
        }
        build(1,n,1);
        System.out.println("..............");
        while(m--!=0){
            int opt = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            if (opt==1){
                update(x,y,1,12);
            }else if (opt==2){
                System.out.println(query(x,y,1));
            }
        }
    }

    static int MAX = 1000;
    static Node [] tree = new Node[4*MAX];
    static int [] data = new int[MAX];

    /**
     * @param p 代表的是树节点在tree中存储的位置
     * @param l 代表tree中一个节点的左区间
     * @param r 代表tree中一个节点的右区间
     * 该函数用于建立线段树
     */
    public static void build(int l,int r,int p) {
        tree[p]= new Node(l,r,0,0);
        if (l == r){// 到达叶子节点
            tree[p].sum = data[l]; //用数组中的数据赋值
            System.out.println(tree[p]);
        }
        else {
            //int mid = (l + r) / 2;
            int mid = (l + r) >> 1;
            //build(l, mid, p * 2);
            build(l, mid, p<<1);//左子树
            //build(mid + 1, r, p * 2 + 1);
            build(mid + 1, r, p<<1|1);//右子树
            update(p);
        }
    }

    /**
     *用于计算某一结点的左右子树的和
     */
    public static void update(int p){
        tree[p].sum=tree[p<<1].sum+tree[p<<1|1].sum;
    }

    /**
     *区间查询-查询最值
     */

    /**
     *区间查询-查询区间和
     */
    public static int query(int l,int r,int p){
        if (l<=tree[p].l&&tree[p].r<=r){
            return tree[p].sum;
        }
        int mid = tree[p].l+tree[p].r >> 1;
        pushDown(p);
        int res = 0;
        if (l<=mid)
            res+=query(l,r,p<<1);
        if (r>=mid+1)
            res+=query(l,r,p<<1|1);
        return res;
    }

    /**
     *区间修改
     */
    public static void update(int l, int r, int p, int k){
        if (l<=tree[p].l&&tree[p].r<=r){
            brush(p,k);
            return;
        }
        pushDown(p);
        int mid = tree[p].l+tree[p].r >> 1;
        if (l<=mid)
            update(l,r,p<<1,k);
        if (r>=mid+1)
            update(l,r,p<<1|1,k);
        update(p);
    }

    /**
     *单节点值的修改
     */
    public static void updateOne(int p, int idx, int k){
        //tree[p].l==tree[p].r 表示找到存储源数据的节点，
        //tree[p].l==idx 表示找到目标节点
        if (tree[p].l==tree[p].r&&tree[p].l==idx){
            tree[p].sum+=k;
            return;
        }
        int mid = tree[p].l+tree[p].r>>1;//除2
        if (idx<=mid)//查询左子树
            updateOne(p<<1,idx,k);
        else //查询右子树
            updateOne(p<<1|1,idx,k);
        update(p);
    }

    // lazy tag 技术
    /**
     *区间长度
     */
    public static int len(int p){
        return tree[p].r-tree[p].l+1;
    }

    /**
     *将p的区间中所有元素加上k
     */
    public static void brush(int p,int k){
        tree[p].lazy+=k;
        tree[p].sum+=len(p)*k;
    }

    /**
     *下传懒标记
     */
    public static void pushDown(int p){
        brush(p<<1,tree[p].lazy);
        brush(p<<1|1,tree[p].lazy);
        tree[p].lazy = 0;
    }

    private static class Node{
        int l;
        int r;
        int sum;
        int lazy;

        public Node(int l, int r, int sum, int lazy) {
            this.l = l;
            this.r = r;
            this.sum = sum;
            this.lazy = lazy;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "l=" + l +
                    ", r=" + r +
                    ", sum=" + sum +
                    ", lazy=" + lazy +
                    '}';
        }
    }
}
