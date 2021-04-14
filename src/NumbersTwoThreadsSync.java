public class NumbersTwoThreadsSync {
        // Starting counter
        int counter = 1;
        static int N;
        public void printOddNumber()
        {
            synchronized (this)
            {
                while (counter < N) {
                    while (counter % 2 == 0) {
                        try {
                            wait();
                        }
                        catch (
                                InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(counter + " ");
                    counter++;
                    notify();
                }
            }
        }
        public void printEvenNumber()
        {
            synchronized (this)
            {
                while (counter < N) {
                    while (counter % 2 == 1) {
                        try {
                            wait();
                        }
                        catch (
                                InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(counter + " ");
                    counter++;
                    notify();
                }
            }
        }
        public static void main(String[] args)
        {
            N = 10;
            NumbersTwoThreadsSync mt = new NumbersTwoThreadsSync();
            Thread t1 = new Thread(new Runnable() {
                public void run()
                {
                    mt.printEvenNumber();
                }
            });

            // Create thread t2
            Thread t2 = new Thread(new Runnable() {
                public void run()
                {
                    mt.printOddNumber();
                }
            });

            // Start both threads
            t1.start();
            t2.start();
        }
}
