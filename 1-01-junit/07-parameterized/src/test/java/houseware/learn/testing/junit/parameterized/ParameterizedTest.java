package houseware.learn.testing.junit.parameterized;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 },{ 6, 8 }
        });
    }

    private int number;
    private int result;

    public ParameterizedTest(int parameterizedNumber, int parameterizedResult) {
        number = parameterizedNumber;
        result = parameterizedResult;
    }

    @Test
    public void shorTArrayTest(){
        assertEquals(result, Fibonacci.fibonacci(number));
    }
}
