package houseware.learn.testing.testng.parameterizedng;

import houseware.learn.testing.testng.parameterizedng.utils.Fibonacci;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class TestNGParameterizedXml {


    @Test
    @Parameters({"number", "result"})
    public void shorTArrayTest(int number, int result){
        assertEquals(result, Fibonacci.fibonacci(number));
    }
}
