package javapractice.locksAPI.reentrantreadWritelock;

import java.util.Random;

public class Writer extends Thread {
    private ReadWriteList<Integer> sharedList;
    public Writer(ReadWriteList<Integer> sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        Random random = new Random();
        int number = random.nextInt();
        sharedList.add(number);
        try {
            Thread.sleep(100);
            System.out.println("-> put: " + number);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
