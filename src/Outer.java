public class Outer {
    private int age = 12;

    class Inner {
        private int age = 13;
        
        public void print() {
            int age = 14;
            System.out.println("�ֲ�����"+age);
            System.out.println("�ڲ������"+this.age);
            System.out.println("�ⲿ�����"+Outer.this.age);
        }
    }

    public static void main(String[] args) {
        Outer.Inner in = new Outer().new Inner();
        in.print();
    }
}
