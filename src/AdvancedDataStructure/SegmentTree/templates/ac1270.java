package AdvancedDataStructure.SegmentTree.templates;

import java.io.*;
import java.util.Scanner;

/**
 * 数列区间最大值
 *https://www.acwing.com/problem/content/1272/
 *
 * 涉及的操作，建立线段树，求区间最大值
 */
public class ac1270 {
    static int MAX = 100010,n,m;
    static Node[] tree = new Node[4*MAX];
    static int [] data = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String s1[]=sc.readLine().split(" ");
        n=Integer.parseInt(s1[0]);
        m=Integer.parseInt(s1[1]);
        String s[]=sc.readLine().split(" ");
        for(int i=1;i<=n;i++){
            data[i]=Integer.parseInt(s[i-1]);
        }
        build(1,n,1);
        while(m--!=0){
            String s2[]=sc.readLine().split(" ");
            int a=Integer.parseInt(s2[0]);
            int b=Integer.parseInt(s2[1]);
            System.out.println(query(a,b,1));
        }
    }

    static void pushup(int p)
    {
        tree[p].max=Math.max(tree[p<<1].max,tree[p<<1|1].max);
        return;
    }

    static void build(int l, int r,int p)
    {
        if(l==r) tree[p]=new Node(l,r, data[l]);
        else
        {
            tree[p]=new Node(l,r,0);
            int mid=l+r>>1;
            build(l,mid,p<<1);
            build(mid+1,r,p<<1|1);
            pushup(p);
        }
    }

    static int query(int l, int r,int p)
    {
        if(tree[p].l>=l&&tree[p].r<=r) return tree[p].max;///某一区间的权值为该区间最大值
        int mid=tree[p].l+tree[p].r>>1;
        int ans=Integer.MIN_VALUE;
        if(l<=mid) ans=Math.max(ans,query(l,r,p<<1));
        if(r>mid) ans=Math.max(ans,query(l,r,p<<1|1));
        return ans;
    }

    private static class Node{
        int l,r,max;
        public Node(int l, int r, int max) {
            this.l = l;
            this.r = r;
            this.max = max;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "l=" + l +
                    ", r=" + r +
                    ", max=" + max +
                    '}';
        }
    }
}
