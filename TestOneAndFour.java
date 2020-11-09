import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestOneAndFour {

    static HomeWork homeWork;

    @BeforeAll
    public static void create() {
        homeWork = new HomeWork();
    }

    @Test
    public void test1And4() {
        int [] src = new int[]{1, 4, 1, 4};
        boolean actual = homeWork.onlyOneAndFour(src);
        Assertions.assertTrue(actual);
    }

    @Test
    public void testOnly4() {
        int[] src = new int[]{4, 4, 4};
        boolean actual = homeWork.onlyOneAndFour(src);
        Assertions.assertFalse(actual);
    }

    @Test
    public void testOnly1() {
        int[] src = new int[]{1, 1, 1};
        boolean actual = homeWork.onlyOneAndFour(src);
        Assertions.assertFalse(actual);
    }

    @Test
    public void testNot1And4() {
        int[] src = new int[]{5, 6, 7};
        boolean actual = homeWork.onlyOneAndFour(src);
        Assertions.assertFalse(actual);
    }
}
