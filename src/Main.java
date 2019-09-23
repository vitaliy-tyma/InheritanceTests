import java.sql.SQLOutput;

public class Main {

    static class A {
        public A(String s) {
            System.out.println("A " + s);
        }

        //Necessary constructor!
        public A() {
        }

        public void doSmth() {
            System.out.println("A");
        }

        public void doSmthOtherFromA() {
            System.out.println("Do something other from A");
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

        public void doSmthOtherFromB() {
            System.out.println("Do something other from B");
        }
    }

    public static void main(String[] args) {


        System.out.println("\nInheritance Tests - 1!");
        A a = new B("b"); // B b
        a.doSmth();         // B


        System.out.println("\nInheritance Tests - 2!");
        A aaa = new A("a"); // A a
        aaa.doSmth();          // A

        //Impossible to cast A to B
//        System.out.println("\nInheritance Tests - 3!");
//        B a2 = (B) new A ("b");
//        a2.doSmth();

        System.out.println("\nInheritance Tests - 4!");
        B b = new B("b"); // B b
        b.doSmth();          // B


        ////////////////////////////////////////////////////////
        A b1 = new B();
        b.doSmthOtherFromA();           //We can use methods from class A
        //b1.doSmthOtherFromB();        //doSmthOtherFromB() is not accessible for the object of type A
        ((B) b1).doSmthOtherFromB();  //but it is possible to cast it to type B




////////////////////////////////////////////////////////
        /* ANOTHER CHECK */
        System.out.println("\n************* ANOTHER CHECK!*************\n");


        System.out.println("\n**** A aa = new A();");
        A aa = new A();
        aa.doSmth();
        aa.doSmthOtherFromA();
        //aa.doSmthOtherFromB();

        System.out.println("\n**** A ab = new B();");
        A ab = new B();
        ab.doSmth();
        ab.doSmthOtherFromA();
        //ab.doSmthOtherFromB();


        System.out.println("\n**** B bb = new B();");
        B bb = new B();
        bb.doSmth();
        bb.doSmthOtherFromA();
        bb.doSmthOtherFromB();

        //B ba = new A();     //Is not possible
/////////////////////////////////////////////////////////
    }
/*




Inheritance Tests - 1!

B b

B

Inheritance Tests - 2!

A a

A

Inheritance Tests - 4!

B b

B

B

Do something other from A

Do something other from B

************* ANOTHER CHECK!*************

**** A aa = new A();

A

Do something other from A

**** A ab = new B();

B

B

Do something other from A

**** B bb = new B();

B

B

Do something other from A

Do something other from B



*/
}

