package houseware.learn.testing.testng.exceptionsng;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class ExceptionTest {

    @Test(expectedExceptions = NullPointerException.class)
    public void nullPointerExceptionInAnnotationTest(){
        throw new NullPointerException();
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class, expectedExceptionsMessageRegExp = "Index: 1, Size: 0")
    public void nullPointerExceptionInRule(){
        List<Object> objects = new LinkedList<>();
        objects.get(1);
    }

}
