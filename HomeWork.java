public class HomeWork {

    private final Object lock = new Object();
    private volatile char currentSymbol = 'A';

    public static void main(String[] args) {

        HomeWork myHomeWork = new HomeWork();

        Thread task1 = new Thread(myHomeWork::printA);
        Thread task2 = new Thread(myHomeWork::printB);
        Thread task3 = new Thread(myHomeWork::printC);

        task1.start();
        task2.start();
        task3.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task1.interrupt();
        task2.interrupt();
        task3.interrupt();

    }

    public void printA() {
        synchronized (lock) {
            try {
                while (!Thread.currentThread().isInterrupted()){
                    while (currentSymbol != 'A') {
                        lock.wait(100);
                    }
                    System.out.print(currentSymbol);
                    currentSymbol = 'B';
                    lock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (lock) {
            try {
                while (!Thread.currentThread().isInterrupted()){
                    while (currentSymbol != 'B') {
                        lock.wait(100);
                    }
                    System.out.print(currentSymbol);
                    currentSymbol = 'C';
                    lock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (lock) {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    while (currentSymbol != 'C') {
                        lock.wait(100);
                    }
                    System.out.print(currentSymbol);
                    currentSymbol = 'A';
                    lock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

