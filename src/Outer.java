public class Outer {
    private int age = 12;

    class Inner {
        private int age = 13;
        
        public void print() {
            int age = 14;
            System.out.println("局部变量"+age);
            System.out.println("内部类变量"+this.age);
            System.out.println("外部类变量"+Outer.this.age);
        }
    }

    public static void main(String[] args) {
        Outer.Inner in = new Outer().new Inner();
        in.print();
    }
}
