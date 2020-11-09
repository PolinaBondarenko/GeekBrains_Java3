import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class HomeWork {

    public int[] afterLastFour(int [] src) {
        if (src.length == 0) {
            return src;
        }

        int lastFour = -1;

        for (int i = 0; i < src.length; i++) {
            if (src[i] == 4) {
                lastFour = i;
            }
        }
        if (lastFour == -1) {
            throw new RuntimeException("Нет четверок");
        } else {
         int[] result = new int[src.length-lastFour-1];
         int j = 0;
            for (int i = lastFour+1; i < src.length; i++) {
                result[j] = src[i];
                j++;
            }
            return result;
        }
    }

    public boolean onlyOneAndFour(int[] src) {
        if (src.length == 0) {
            return false;
        }

        boolean one = false;
        boolean four = false;

        for (int j : src) {
            if (j == 1) {
                one = true;
            } else if (j == 4) {
                four = true;
            } else return false;
        }
        return one && four;
    }
}
