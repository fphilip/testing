package houseware.learn.testing.junit.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.LinkedList;
import java.util.List;

public class TestExceptionWithCaseRule {


    ExpectedException thrown;

    @Rule
    public ExpectedException my_rule(){
        thrown = ExpectedException.none();
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 1, Size: 0");

        return thrown;
    }



    @Test
    public void nullPointerExceptionInRule(){
        List<Object> objects = new LinkedList<>();
        objects.get(1);
    }



}
