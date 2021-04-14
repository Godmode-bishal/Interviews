package morganstanley;

 class MyThread extends Thread {
     MyThread(){}
     MyThread(Runnable r) {
         super(r);
     }
     @Override
     public void run() {
         System.out.print("Inside thread");
     }
 }

 class MyRunnable implements Runnable {

     @Override
     public void run() {
         System.out.print("Inside Runnable");
     }
 }
 class Test {
     public static void main(String[] args) {
         new MyThread().start();
         new MyThread(new MyRunnable()).start();
     }
 }
