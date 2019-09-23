import java.sql.SQLOutput;

public class Main {

    static class A {
        public A(String s) {
            System.out.println("Constructor A with params (" + s + ")");
        }

        //Necessary constructor!
        public A() {
            System.out.println("Constructor A without params");
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


        System.out.println("\nInheritance Tests - 1!");
        A a = new B("b"); // B b
        a.doSmth();         // B
/* Output *
Constructor A without params
Constructor B with params (b)
Do something in B
*/

        System.out.println("\nInheritance Tests - 2!");
        A aaa = new A("a"); // A a
        aaa.doSmth();          // A
/* Output *
Constructor A with params (a)
Do something in A
*/

        //Impossible to cast A to B
//        System.out.println("\nInheritance Tests - 3!");
//        B a2 = (B) new A ("b");
//        a2.doSmth();

        System.out.println("\nInheritance Tests - 4!");
        B b = new B("b"); // B b
        b.doSmth();          // B
/* Output *
Constructor A without params
Constructor B with params (b)
Do something in B
*/

        ////////////////////////////////////////////////////////
        System.out.println("\nInheritance Tests - 5!");
        A b1 = new B();
        b.doSmthOtherFromA();           //We can use methods from class A
        //b1.doSmthOtherFromB();        //doSmthOtherFromB() is not accessible for the object of type A
        ((B) b1).doSmthOtherFromB();  //but it is possible to cast it to type B
/* Output *
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
        //aa.doSmthOtherFromB();
/* Output *
Constructor A without params
Do something in A
Do something other from A
*/
        System.out.println("\n**** A ab = new B();");
        A ab = new B();
        ab.doSmth();
        ab.doSmthOtherFromA();
        //ab.doSmthOtherFromB();
/* Output *
Constructor A without params
Constructor B without params
Do something in B
Do something other from A
*/


        System.out.println("\n**** B bb = new B();");
        B bb = new B();
        bb.doSmth();
        bb.doSmthOtherFromA();
        bb.doSmthOtherFromB();
/* Output *
Constructor A without params
Constructor B without params
Do something in B
Do something other from A
Do something other from B
*/

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

