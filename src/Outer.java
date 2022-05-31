
public class Outer {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println((1f-0.9f) == (0.9f-0.8f));

    }

    public static int f(int value) {
        try {
            return value * value;
        } finally {
            if (value == 2) {
                return 0;
            }
        }
    }
}
