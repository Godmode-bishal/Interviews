package javapractice.locksAPI.reentrantreadWritelock;

import java.util.Random;

public class Reader extends Thread {

    private ReadWriteList<Integer> sharedList;
    public Reader(ReadWriteList<Integer> sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        Random random = new Random();
        int index = random.nextInt(sharedList.size());
        Integer number = sharedList.get(index);
        System.out.println("Get::" + number);
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
