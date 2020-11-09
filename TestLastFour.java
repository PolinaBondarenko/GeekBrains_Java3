import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestLastFour {

    static HomeWork homeWork;

    @BeforeAll
    public static void create() {
        homeWork = new HomeWork();
    }

    @Test
    public void test1(){
        int[] src = new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] exp = new int[] {1, 7};
        int[] actual = homeWork.afterLastFour(src);
        Assertions.assertEquals(Arrays.toString(exp), Arrays.toString(actual));
    }

    @Test
    public void test2(){
        int[] src = new int[] {1, 2, 4, 4, 2, 4, 5, 1, 7};
        int[] exp = new int[] {5, 1, 7};
        int[] actual = homeWork.afterLastFour(src);
        Assertions.assertEquals(Arrays.toString(exp), Arrays.toString(actual));
    }

    @Test
    public void test3(){
        int[] src = new int[]{1, 2, 3, 4, 2, 3, 5, 1, 7};
        int[] exp = new int[]{2, 3, 5, 1, 7};
        int[] actual = homeWork.afterLastFour(src);
        Assertions.assertEquals(Arrays.toString(exp), Arrays.toString(actual));
    }

    @Test
    public void testThrow(){
        int[] src = new int[] {1, 2, 3, 0, 2, 3, 5, 1, 7};
        Throwable throwable = Assertions.assertThrows(RuntimeException.class, () -> {
           homeWork.afterLastFour(src);
        });
        Assertions.assertNotNull(throwable.getMessage());
    }
}
