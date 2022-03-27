package AdvancedDataStructure.SegmentTree.templates;

import java.util.Scanner;

/**
 * 动态连续区间和
 *https://www.acwing.com/problem/content/1266/
 *
 * 涉及操作右建立线段树，区间求和，单节点的值的修改
 */
public class ac1264 {

    static int MAX = 1000;
    static Node[] tree = new Node[4*MAX];
    static int [] data = new int[MAX];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            data[i] = scan.nextInt();
        }
        build(1,n,1);
        System.out.println(".......................");
        while (m--!=0){
            int k = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();
            if (k==0)
                System.out.println(query(a, b, 1));
            if (k==1)
                updateOne(1,a,b);
        }
    }

    public static void build(int l,int r,int p) {
        tree[p]= new Node(l,r,0);
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

    //一个节点的sum值等于它两个子节点的sum值之和
    public static void update(int p){
        tree[p].sum=tree[p<<1].sum+tree[p<<1|1].sum;
    }

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

    public static int query(int l,int r,int p){
        System.out.println(tree[p]);
        if (l<=tree[p].l&&tree[p].r<=r){
            return tree[p].sum;
        }
        int mid = tree[p].l+tree[p].r >> 1;
        int res = 0;
        if (l<=mid)
            res+=query(l,r,p<<1);
        if (r>=mid+1)
            res+=query(l,r,p<<1|1);
        return res;
    }

    private static class Node{
        int l;
        int r;
        int sum=0;

        public Node(int l, int r, int sum) {
            this.l = l;
            this.r = r;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "l=" + l +
                    ", r=" + r +
                    ", sum=" + sum +
                    '}';
        }
    }
}
