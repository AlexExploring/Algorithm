package Math.NumberTheory;

public class Prime {
    public static void main(String[] args) {
        System.out.println(ESieve1(100));
        for (int i = 0; i < ESieve1(100); i++) {
            System.out.print(prime[i]+" ");
        }
    }

    public static void isprime(int n){
        int p = 0;
        for (int j = 2;j <= Math.sqrt(n);j++){  //j <= Math.sqrt(n)等号很重要
            if (n%j == 0){
                System.out.println("No");
                p = 1;
                break;
            }
        }
        if (p == 0){
            System.out.println("Yes");
        }
    }

    public static Boolean isPrime1(int n){
        if(n <= 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;//能被2~i之间某一个数整除，所以不是素数
            }
        }
        return true;
    }

    static int maxSize = (int)(Math.pow(10,7));//根据题目要求来定
    static int [] prime = new int[maxSize+1];
    static int [] book = new int[maxSize+1];
    public static int ESieve(int n){
        int k = 0;
        for (int i = 2; i <= n; i++) {
            if (book[i]!=1){
                prime[k++] = i;
                for (int j = 2*i; j <= n; j+=i) {
                    book[j] = 1;
                }
            }
        }
        return k;
    }

    public static int ESieve1(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (book[i]!=1){
                for (int j = i*i; j <= n; j+=i) {
                    book[j] = 1;
                }
            }
        }
        int k = 0;
        for (int i = 2; i <= n; i++) {
            if (book[i]!=1)
                prime[k++] = i;
        }
        return k;
    }

}
