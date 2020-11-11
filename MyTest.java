public class MyTest {

    @BeforeSuite
    public static void start(){
        System.out.println("Тест стартовал");
    }

    @Test(property = 1)
    public static void test1(){
        System.out.println("test1");
    }

    @Test
    public static void test2(){
        System.out.println("test2");
    }

    @Test(property = 10)
    public static void test3(){
        System.out.println("test3");
    }

    @AfterSuite
    public static void end() {
        System.out.println("Конец теста");
    }

}
