import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Class mt = MyTest.class;

        //Получение всех методов
      ArrayList<Method> declMethod = new ArrayList<>(Arrays.asList(mt.getMethods()));

        //Сортировка
       int countBefore = 0;
       int countAfter = 0;
       int count = 1;
       int maxProperty = Integer.MIN_VALUE;

       ArrayList<Method> sortedArr = new ArrayList<>(5);

       for (Method method : declMethod) {
           if (method.isAnnotationPresent(BeforeSuite.class)) {
               sortedArr.add(0, method);
               countBefore++;
           } else if (countBefore > 1) {
               throw new RuntimeException("Больше одного Before");
           }
           if (method.isAnnotationPresent(Test.class)) {
               if (method.getAnnotation(Test.class).property() > maxProperty) {
                   maxProperty = method.getAnnotation(Test.class).property();
                   sortedArr.add(1, method);
               } else {
                   sortedArr.add(sortedArr.size()- count, method);
                   count++;
               }
           }
           if (method.isAnnotationPresent(AfterSuite.class)) {
               sortedArr.add(sortedArr.size(), method);
               countAfter++;
           } else if (countAfter > 1) {
               throw new RuntimeException("Больше одного After");
           }
       }

       for (Method m : sortedArr) {
           m.invoke(null);
       }
    }
}
