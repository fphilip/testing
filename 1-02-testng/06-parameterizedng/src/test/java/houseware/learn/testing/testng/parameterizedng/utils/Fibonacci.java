package houseware.learn.testing.testng.parameterizedng.utils;

public class Fibonacci {

    public static int fibonacci(int n) {
        int result = 0;

        if (n <= 1) {
            result = n;
        } else {
            result = fibonacci(n - 1) + fibonacci(n - 2);
        }

        return result;
    }

}