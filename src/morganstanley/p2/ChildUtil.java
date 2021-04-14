package morganstanley.p2;
import morganstanley.p1.JavaBasics1;
public class ChildUtil extends JavaBasics1 {
    public static void main(String[] args) {
        new ChildUtil().callStuff();
    }
    void callStuff() {
        System.out.println("this" + this.doStuff());
        JavaBasics1 javaBasics1 = new JavaBasics1();
        //System.out.println(javaBasics1.doStuff());
    }
}