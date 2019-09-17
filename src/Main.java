public class Main {

    static class A {
        public A(String s) {
            System.out.println("A " + s);
        }

        //Necessary constructor
        public A() {
        }

        public void doSmth() {
            System.out.println("A");
        }
    }

    static class B extends A {
        public B() {
            System.out.println("B");
        }
        public B(String s) {
            System.out.println("B " + s);
        }
        public void doSmth() {
            System.out.println("B");
        }
    }

    public static void main(String[] args) {

        System.out.println("Inheritance Tests - 1!");
        A a = new B("b");
        a.doSmth();


        System.out.println("Inheritance Tests - 2!");
        A a1 = new A ("b");
        a1.doSmth();

        //Impossible to cast A to B
//        System.out.println("Inheritance Tests - 3!");
//        B a2 = (B) new A ("b");
//        a2.doSmth();

        System.out.println("Inheritance Tests - 4!");
        B a3 = new B ("c");
        a3.doSmth();

    }
}

