import java.util.concurrent.*;

public class MainClass {

    public static final int CARS_COUNT = 4;
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
    public static CountDownLatch cdl = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (Car car : cars) {
            new Thread(car).start();
        }

/*        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }*/
        // Если расскоменитровать код выше, то один экземпляр Car "выпадет" из гонки и программа повиснет.
        // Не смогла решить эту проблему.
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}