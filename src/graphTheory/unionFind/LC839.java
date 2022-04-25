package graphTheory.unionFind;

import java.util.Arrays;

/**
 * ���Ƶ��ַ���
 */
public class LC839 {

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int[] parent = new int[n];
        //��ʼ��parent����
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int ans = n;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isSimilar(strs[i],strs[j])) {
                    if (union(parent,i,j)) ans--;
                }
            }
        }

        System.out.println(Arrays.toString(parent));

        return ans;
    }

    public int find(int [] parent,int x) {
        if (parent[x] != x) parent[x] = find(parent,parent[x]);
        return parent[x];
    }

    public boolean union(int [] parent,int x,int y) {
        int px = find(parent,x);
        int py = find(parent,y);
        parent[px] = py;
        return px!=py;
    }

    /**
     * �ж������ַ����Ƿ�����
     */
    public boolean isSimilar(String a,String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0,count = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 2) return false;
            }
        }
        return true;
    }
}
