package houseware.learn.testing.mockito;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 * @author fphilip@houseware.es
 */
public class TestMockito {


    // tests

    @Test
    public final void list_whenMockReturnBehaviorIsConfigured_thenBehaviorIsVerified() {
        final List listMock = Mockito.mock(List.class);
        when(listMock.add(anyString())).thenReturn(false);

        final boolean added = listMock.add(HelloMyList.timestampString());
        assertThat(added, is(false));
    }
    // tests

    @Test
    public final void whenMockReturnBehaviorIsConfigured_thenBehaviorIsVerified() {
        final HelloMyList listMock = Mockito.mock(HelloMyList.class);
        when(listMock.add(anyString())).thenReturn(false);

        final boolean added = listMock.add(HelloMyList.timestampString());
        assertThat(added, is(false));
    }

    @Test
    public final void whenMockReturnBehaviorIsConfigured2_thenBehaviorIsVerified() {
        final HelloMyList listMock = Mockito.mock(HelloMyList.class);
        doReturn(false).when(listMock).add(anyString());

        final boolean added = listMock.add(HelloMyList.timestampString());
        assertThat(added, is(false));
    }

    @Test(expected = IllegalStateException.class)
    public final void givenMethodIsConfiguredToThrowException_whenCallingMethod_thenExceptionIsThrown() {
        final HelloMyList listMock = Mockito.mock(HelloMyList.class);
        when(listMock.add(anyString())).thenThrow(IllegalStateException.class);

        listMock.add(HelloMyList.timestampString());
    }

    @Test(expected = NullPointerException.class)
    public final void whenMethodHasNoReturnType_whenConfiguringBehaviorOfMethod_thenPossible() {
        final HelloMyList listMock = Mockito.mock(HelloMyList.class);
        doThrow(NullPointerException.class).when(listMock).clear();
        doThrow(NullPointerException.class).when(listMock).size();

        listMock.size();
    }

    @Test
    public final void givenBehaviorIsConfiguredToThrowExceptionOnSecondCall_whenCallingOnlyOnce_thenNoExceptionIsThrown() {
        final HelloMyList listMock = Mockito.mock(HelloMyList.class);
        when(listMock.add(anyString())).thenReturn(false).thenThrow(IllegalStateException.class);

        listMock.add(HelloMyList.timestampString());
    }

    @Test(expected = IllegalStateException.class)
    public final void givenBehaviorIsConfiguredToThrowExceptionOnSecondCall_whenCallingTwice_thenExceptionIsThrown() {
        final HelloMyList listMock = Mockito.mock(HelloMyList.class);
        when(listMock.add(anyString())).thenReturn(false).thenThrow(IllegalStateException.class);

        listMock.add(HelloMyList.timestampString());
        listMock.add(HelloMyList.timestampString());
    }

    @Test
    public final void whenMockMethodCallIsConfiguredToCallTheRealMethod_thenRealMetehodIsCalled() {
        final HelloMyList listMock = Mockito.mock(HelloMyList.class);
        when(listMock.size()).thenCallRealMethod();
        listMock.add("A");
        listMock.add("B");
        listMock.add("C");
        assertThat(listMock.size(), equalTo(1));
    }


    @Test
    public final void whenMockMethodCallIsConfiguredWithCustomAnswer_thenRealMetehodIsCalled() {
        final HelloMyList listMock = Mockito.mock(HelloMyList.class);
        doAnswer(new Answer<String>() {
            @Override
            public final String answer(final InvocationOnMock invocation) {
                return "Always the same";
            }
        }).when(listMock).get(anyInt());

        assertThat(listMock.get(1), is(equalTo("Always the same")));
        assertThat(listMock.get(-1), is(equalTo("Always the same")));
        assertThat(listMock.get(9999), is(equalTo("Always the same")));
        assertThat(listMock.get(0), is(equalTo("Always the same")));
    }

    @Test(expected = NullPointerException.class)
    public final void givenSpy_whenConfiguringBehaviorOfSpy_thenCorrectlyConfigured() {
        final HelloMyList instance = new HelloMyList();
        final HelloMyList spy = Mockito.spy(instance);
        assertEquals(spy.size(),1);
        doThrow(NullPointerException.class).when(spy).size();
        assertEquals(instance.size(),1);
        spy.size();
    }


    /**
     * This example creates a mock iterator and makes it return “Hello” the first time method next() is called.
     * Calls after that return “World”. Then we can run normal assertions.
     * Stubs can also return different values depending on arguments passed into the method.
     */
    @Test(expected = IllegalArgumentException.class)
    public void iterator_will_return_hello_world() {

        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello").thenReturn("World").thenThrow(IllegalArgumentException.class);

        String result = i.next() + " " + i.next();
        assertEquals("Hello World", result);
        assertEquals("World", i.next());
    }


    /**
     * This creates a stub Comparable object and returns 1 if it is compared to a particular String value (“Test” in
     * this case). If the method has arguments but you really don’t care what gets passed or cannot predict it,
     * use anyInt() (and alternative values for other types).
     */

    @Test
    public void with_arguments() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo("Test")).thenReturn(1);
        when(c.compareTo("Unit")).thenReturn(2);
        assertEquals(1, c.compareTo("Test"));
        assertEquals(2, c.compareTo("Unit"));
    }

    /**
     * This stub comparable returns -1 regardless of the actual method argument. With void methods, this gets a bit
     * tricky as you can’t use them in the when() call. The alternative syntax is doReturn(result).when(mock_object).
     * void_method_call(); Instead of returning, you can also use .thenThrow() or doThrow() for void methods.
     *
     * @throws IOException
     */
    @Test
    public void with_unspecified_arguments() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        when(c.compareTo(7)).thenReturn(-1);
        when(c.compareTo(7)).thenReturn(-10);
        assertEquals(-10, c.compareTo(7));
        assertEquals(-1, c.compareTo(5));
    }


    /**
     * This example throws an IOException when the mock OutputStream close method is called. We verify easily that the
     * OutputStreamWriter rethrows the exception of the wrapped output stream. To verify actual calls to underlying
     * objects (typical mock object usage), we can use verify(mock_object).method_call;
     *
     * @throws IOException
     */
    @Test(expected = IOException.class)
    public void OutputStreamWriter_rethrows_an_exception_from_OutputStream()
            throws IOException {
        //
        OutputStream mock = mock(OutputStream.class);
        doThrow(new IOException()).when(mock).close();
        //
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        osw.close();
    }


    /**
     * This example will verify that OutputStreamWriter propagates the close method call to the wrapped output stream.
     *
     * @throws IOException
     */
    @Test
    public void OutputStreamWriter_Closes_OutputStream_on_Close()
            throws IOException {
        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        osw.close();
        verify(mock).close();
    }

    /**
     * You can use arguments on methods and matchers such as anyInt() similar to the previous example.
     * Note that you can’t mix literals and matchers, so if you have multiple arguments they all have to be either
     * literals or matchers. use eq(value) matcher to convert a literal into a matcher that compares on value.
     * Mockito comes with lots of matchers already built in, but sometimes you need a bit more flexibility.
     * For example, OutputStreamWriter will buffer output and then send it to the wrapped object when flushed,
     * but we don’t know how big the buffer is upfront. So we can’t use equality matching. However, we can supply our
     * own matcher
     *
     * @throws IOException
     */

    @Test
    public void OutputStreamWriter_Buffers_And_Forwards_To_OutputStream()
            throws IOException {
        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        osw.write('a');
        osw.flush();
        osw.write('b');
        osw.flush();


        // can't do this as we don't know how long the array is going to be
        // verify(mock).write(new byte[]{'a'},0,1);

        BaseMatcher<byte[]> arrayStartingWithA = new BaseMatcher<byte[]>() {
            @Override
            public void describeTo(Description description) {
                // nothing
            }

            // check that first character is A
            @Override
            public boolean matches(Object item) {
                byte[] actual = (byte[]) item;
                return actual[0] == 'a' || actual[0]=='b';
            }
        };
        // check that first character of the array is A,
        // and that the other two arguments are 0 and 1
        verify(mock, times(2)).write(argThat(arrayStartingWithA), eq(0), eq(1));
        verify(mock, never()).write(argThat(arrayStartingWithA), eq(1), eq(2));
    }

}
