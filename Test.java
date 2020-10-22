package J3_Lesson1_Generic;

import J3_Lesson1_Generic.Task3.Apple;
import J3_Lesson1_Generic.Task3.Box;
import J3_Lesson1_Generic.Task3.Orange;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        String[] arrOfString = {"first", "second", "third", "fourth"};
        for (int i = 0; i < arrOfString.length; i++) {
            System.out.println(arrOfString[i]);
        }
        System.out.println("-----------------");

        Task1.switchElement(0, 2, arrOfString);

        for (int i = 0; i < arrOfString.length; i++) {
            System.out.println(arrOfString[i]);
        }
        System.out.println("-----------------");
        System.out.println("-----------------");

        String[] forTask2Stream = {"1", "2", "3", "4", "5"};
        String[] forTask2Cycle = {"1", "2", "3", "4", "5"};
        ArrayList<String> resultStream = Task2.alternativeStream(forTask2Stream);
        ArrayList<String> resultCycle = Task2.alternativeCycle(forTask2Cycle);
        System.out.println(resultStream);
        System.out.println(resultCycle);

        System.out.println("-----------------");
        System.out.println("-----------------");


        Orange myOrange1 = new Orange();
        Orange myOrange2 = new Orange();
        Orange myOrange3 = new Orange();
        Orange myOrange4 = new Orange();
        Orange myOrange5 = new Orange();
        Orange myOrange6 = new Orange();
        Orange myOrange7 = new Orange();
        Orange myOrange8 = new Orange();
        Orange myOrange9 = new Orange();

        Apple myApple1 = new Apple();
        Apple myApple2 = new Apple();
        Apple myApple3 = new Apple();
        Apple myApple4 = new Apple();
        Apple myApple5 = new Apple();
        Apple myApple6 = new Apple();

        Box<Orange> boxForOrange = new Box<>();

        boxForOrange.addOneFruitInBox(myOrange1);
        boxForOrange.addOneFruitInBox(myOrange2);
        boxForOrange.addOneFruitInBox(myOrange3);
        boxForOrange.addOneFruitInBox(myOrange4);
        boxForOrange.addOneFruitInBox(myOrange5);
        boxForOrange.addOneFruitInBox(myOrange6);
        boxForOrange.addOneFruitInBox(myOrange7);
        boxForOrange.addOneFruitInBox(myOrange8);
        boxForOrange.addOneFruitInBox(myOrange9);

        Box<Apple> boxForApple = new Box<>();

        boxForApple.addOneFruitInBox(myApple1);
        boxForApple.addOneFruitInBox(myApple2);
        boxForApple.addOneFruitInBox(myApple3);
        boxForApple.addOneFruitInBox(myApple4);
        boxForApple.addOneFruitInBox(myApple5);
        boxForApple.addOneFruitInBox(myApple6);

        System.out.println(boxForApple.getWeight());
        System.out.println(boxForOrange.getWeight());
        System.out.println(boxForApple.compare(boxForOrange));
    }
}
