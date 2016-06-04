package houseware.learn.testing.junit.exceptions;

import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.LinkedList;
import java.util.List;

public class ExceptionTest {

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionInAnnotationTest(){
        throw new NullPointerException();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void nullPointerExceptionInRule(){
        List<Object> objects = new LinkedList<>();
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 1, Size: 0");
        objects.get(1);
    }

}
