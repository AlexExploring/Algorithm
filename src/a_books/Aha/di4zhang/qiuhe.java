package a_books.Aha.di4zhang;

public class qiuhe {
    static int [] a = new int[10];
    static int [] book = new int[10];
    static int n = 9,total=0;
    public static void main(String[] args) {

        dfs(1);
    }

    public static void dfs(int step){
        if (step == n+1){
            if (a[1]*100+a[2]*10+a[3] + a[4]*100+a[5]*10+a[6] == a[7]*100+a[8]*10+a[9]){
                total++;
                System.out.println(String.format("%d%d%d+%d%d%d=%d%d%d",a[1],a[2],a[3],
                        a[4],a[5],a[6],a[7],a[8],a[9]));
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (book[i] == 0){
                a[step] = i;
                book[i] = 1;
                dfs(step+1);
                book[i] = 0;
            }
        }
        return;
    }
}
