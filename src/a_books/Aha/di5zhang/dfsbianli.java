package a_books.Aha.di5zhang;

public class dfsbianli {
    public static void main(String[] args) {

    }
    int sum;
    int n;
    int [][] e;
    int [] book;
    void dfs(int cur) {
        System.out.println(cur + " ");
        sum++;
        if (sum == n) return;//所有的顶点都已经访问过则直接退出
        for (int i = 0; i < n; i++) {
            if (e[cur][i] == 1 && book[i] == 0) {
                book[i] = 1;
                dfs(i);
            }
        }
    }
}
