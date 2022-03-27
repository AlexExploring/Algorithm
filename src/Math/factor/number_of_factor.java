package Math.factor;

public class number_of_factor {
    public static void main(String[] args) {
        System.out.println(getNumOfFactor(21));
    }

    /**
     *输出一个数的所有因数，并返回因数的个数
     */
    public static int getNumOfFactor(int n) {
        int count = 0;

        if (n == 0)
            return count;
        else {
            System.out.print(1 + " ");
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    System.out.print(i + " ");
                    System.out.print(n / i + " ");
                    count += 2;
                }
            }
            return ++count;
        }
    }
}
