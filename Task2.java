package J3_Lesson1_Generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task2 {

    public static <T> ArrayList<T> alternativeStream(T[] sourceArr) {
        ArrayList<T> result = new ArrayList<>();
        Arrays.stream(sourceArr).forEach(result::add);
        return result;
    }

    public static <T> ArrayList<T> alternativeCycle(T[] sourceArr) {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < sourceArr.length; i++) {
            result.add(sourceArr[i]);
        }
        return result;
    }
}
