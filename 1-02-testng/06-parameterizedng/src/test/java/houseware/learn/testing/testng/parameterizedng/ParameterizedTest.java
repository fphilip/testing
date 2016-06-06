package houseware.learn.testing.testng.parameterizedng;

import houseware.learn.testing.testng.parameterizedng.utils.Fibonacci;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ParameterizedTest {

    @Test(dataProvider =  "numberProvider")
    public void shorTArrayTest(int number, int result){
        assertEquals(result, Fibonacci.fibonacci(number));
    }

    @DataProvider(name = "numberProvider")
    public Object[][] provideData() {
        return new Object[][]{
                { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 },{ 6, 8 }
        };

    }

}
