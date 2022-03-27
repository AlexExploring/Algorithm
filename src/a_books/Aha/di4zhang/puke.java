package a_books.Aha.di4zhang;

import java.util.Scanner;

//理解深度优先的关键在于解决“当下该如何做”
public class puke {
    static int n,total=0;
    static int [] a = new int[10000];
    static int [] book = new int[10000];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        dfs(1);  //返回之前的一步，最近一次调用dfs的地方
        System.out.println(total);
    }

    public static void dfs(int step){
        if (step == n+1){   //如果站在第n+1个盒子面前，表示前n个盒子已经放好
            for (int i = 1;i <= n;i++){
                System.out.print(a[i]+" ");
            }
            System.out.println();
            total++;
            return;
        }


        //此时站在第step个盒子面前，应该放那张牌呢？
        //按照约定好的顺序一一尝试
        for (int i = 1;i <= n;i++){
            if (book[i] == 0){ //判断扑克牌是否在手上,book[i]等于0表示i号扑克牌在手上
                a[step] = i;  //将i号扑克牌放入到第step个盒子中
                book[i] = 1;  //表示i号扑克牌已经不在手上
                //第step个盒子已经放好，接下来需要走到下一个盒子面前
                dfs(step+1);
                book[i] = 0;//为了尝试下一种可能
            }
        }
        return;   //返回上一次调用dfs的地方
    }
}
