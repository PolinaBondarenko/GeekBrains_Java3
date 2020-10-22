package J3_Lesson1_Generic;

public class Task1 {

    public static <T> T[] switchElement(int firstID, int secondID, T[] sourceArr){
        T[] resultArr = sourceArr;
        T firstElement = sourceArr[firstID];
        T secondElement = sourceArr[secondID];
        resultArr[firstID] = secondElement;
        resultArr[secondID] = firstElement;
        return resultArr;
    }
}
