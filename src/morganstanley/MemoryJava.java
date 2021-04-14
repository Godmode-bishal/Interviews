package morganstanley;

public class MemoryJava {
    public static void main(String[] args) {
        decreaseNumberByOne(2);
    }
    public static void decreaseNumberByOne(int num) {
        if(num>=0) {
            decreaseNumberByOne(num-1);
        }
        System.out.println("Number:" + num);
    }
}
