package houseware.learn.testing.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class TestMockitoCaptorExample {

    @Mock
    Stack<String> stack;
    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() throws Exception {
        stack.add("Java Code Geeks");
        Mockito.verify(stack).add(argumentCaptor.capture());
        assertEquals("Java Code Geeks", argumentCaptor.getValue());
    }
}