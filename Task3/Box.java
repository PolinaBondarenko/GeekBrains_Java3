package J3_Lesson1_Generic.Task3;

import java.util.ArrayList;
import java.util.Collections;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitBox = new ArrayList<>();

    public float getWeight(){
        float result = 0.0f;
        for (int i = 0; i < fruitBox.size(); i++) {
            result += fruitBox.get(i).getWeight();
        }
        return result;
    }

    public void addOneFruitInBox(T fruit) {
        fruitBox.add(fruit);
    }

    public boolean compare(Box<? extends Fruit> someBox) {
        return Math.abs(this.getWeight() - someBox.getWeight()) < 0.00001;
    }

    public static <T extends Fruit> void reposition(Box<? extends Fruit> sourceBox, Box<? extends Fruit> secondBox) {
        if (sourceBox.compare(secondBox)) {
            ArrayList<? extends Fruit> tmpSourceBoxArr = new ArrayList<>(sourceBox.fruitBox);
            ArrayList<? extends Fruit> tmpSecondBoxArr = new ArrayList<>(secondBox.fruitBox);
            secondBox.fruitBox.clear();
            sourceBox.fruitBox.clear();
            secondBox.fruitBox = new ArrayList<>(tmpSourceBoxArr);
            sourceBox.fruitBox = new ArrayList<>(tmpSecondBoxArr);
        }
    }
}
