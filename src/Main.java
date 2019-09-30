import java.sql.SQLOutput;

public class Main {

    static class A {
        //Necessary constructor!
        public A() {
            System.out.println("Constructor A without params");
        }

        public A(String s) {
            System.out.println("Constructor A with params (" + s + ")");
        }

        public void doSmth() {
            System.out.println("Do something in A");
        }

        public void doSmthOtherFromA() {
            System.out.println("Do something other from A");
        }
    }

    static class B extends A {
        public B() {
            System.out.println("Constructor B without params");
        }

        public B(String s) {
            System.out.println("Constructor B with params (" + s + ")");
        }

        public void doSmth() {
            System.out.println("Do something in B");
        }

        public void doSmthOtherFromB() {
            System.out.println("Do something other from B");
        }
    }

    public static void main(String[] args) {

        System.out.println("\nInheritance Tests - 1! A a = new B(\"b\");");
        A a = new B("b");
        a.doSmth();
        /* Output
        Constructor A without params
        Constructor B with params (b)
        Do something in B
        */

        System.out.println("\nInheritance Tests - 2! A aaa = new A(\"a\");");
        A aaa = new A("a");
        aaa.doSmth();
        /* Output
        Constructor A with params (a)
        Do something in A
        */

        //Impossible to cast A to B
        System.out.println("\nInheritance Tests - 3! B a2 = (B) new A (\"b\"); - Not POSSIBLE");
        //B a2 = (B) new A ("b"); // It is possible to compile but not possible to run!!!
        //a2.doSmth();


        System.out.println("\nInheritance Tests - 4! B b = new B(\"b\"); ");
        B b = new B("b");
        b.doSmth();
        /* Output
        Constructor A without params
        Constructor B with params (b)
        Do something in B
        */

        ////////////////////////////////////////////////////////
        System.out.println("\nInheritance Tests - 5! A b1 = new B();");
        A b1 = new B();
        b1.doSmthOtherFromA();           //We can use methods from class A
        //b1.doSmthOtherFromB();        //doSmthOtherFromB() is not accessible for the object of type A
        ((B) b1).doSmthOtherFromB();    //but it is possible to cast it to type B
        /* Output
        Constructor A without params
        Constructor B without params
        Do something other from A
        Do something other from B
        */



        ////////////////////////////////////////////////////////
        /* ANOTHER CHECK */
        System.out.println("\n************* ANOTHER CHECK!*************\n");


        System.out.println("\n**** A aa = new A();");
        A aa = new A();
        aa.doSmth();
        aa.doSmthOtherFromA();
        //aa.doSmthOtherFromB(); //It is not possible
        /* Output
        Constructor A without params
        Do something in A
        Do something other from A
        */

        System.out.println("\n**** B bb = new B();");
        B bb = new B();
        bb.doSmth();
        bb.doSmthOtherFromA();
        bb.doSmthOtherFromB();
        /* Output
        Constructor A without params
        Constructor B without params
        Do something in B
        Do something other from A
        Do something other from B
        */

        System.out.println("\n**** A ab = new B();");
        A ab = new B();
        ab.doSmth();
        ab.doSmthOtherFromA();
        //ab.doSmthOtherFromB(); //It is not possible
        /* Output
        Constructor A without params
        Constructor B without params
        Do something in B
        Do something other from A
        */

        //It is not possible
        //B ba = new A();
/////////////////////////////////////////////////////////
    }
}

