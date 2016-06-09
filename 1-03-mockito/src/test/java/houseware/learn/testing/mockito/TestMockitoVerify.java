package houseware.learn.testing.mockito;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * @author fphilip@houseware.es
 */
public class TestMockitoVerify {

    @Test
    public void verify_my_list() {
        List<String> mockedList = mock(HelloMyList.class);
        mockedList.size();
        verify(mockedList).size();
    }

    @Test
    public void verify_iteractions() {
        List<String> mockedList = mock(HelloMyList.class);
        mockedList.size();
        verify(mockedList, times(1)).size();
    }

    @Test
    public void verify_no_iteractions() {
        List<String> mockedList = mock(HelloMyList.class);
        verifyZeroInteractions(mockedList);
    }

    @Test
    public void verify_no_method_iteractions() {
        List<String> mockedList = mock(HelloMyList.class);
        verify(mockedList, times(0)).size();
    }

    @Test
    public void verify_no_more_iteractions_ok() {
        List<String> mockedList = mock(HelloMyList.class);
        mockedList.size();
        mockedList.clear();
        verify(mockedList).size();
        verifyNoMoreInteractions(mockedList);
    }

    @Test
    public void verify_no_more_iteractions_exception() {
        List<String> mockedList = mock(HelloMyList.class);
        mockedList.size();
        mockedList.clear();
        verify(mockedList).size();
        verifyNoMoreInteractions(mockedList);
    }

    @Test
    public void verify_order() {
        List<String> mockedList = mock(HelloMyList.class);
        mockedList.size();
        mockedList.add("a parameter");
        mockedList.clear();

        InOrder inOrder = Mockito.inOrder(mockedList);
        inOrder.verify(mockedList).size();
        inOrder.verify(mockedList).add("a parameter");
        inOrder.verify(mockedList).clear();
    }


    @Test
    public void verify_no_order() {
        List<String> mockedList = mock(HelloMyList.class);
        mockedList.size();
        verify(mockedList, never()).clear();
    }

    @Test
    public void verify_occurred_atleat_atmost() {
        List<String> mockedList = mock(HelloMyList.class);
        mockedList.clear();
        mockedList.clear();
        mockedList.clear();

        verify(mockedList, atLeast(1)).clear();
        verify(mockedList, atMost(10)).clear();
    }

    @Test
    public void verify_exact_argument() {
        List<String> mockedList = mock(HelloMyList.class);
        mockedList.add("test");
        verify(mockedList).add("test");
    }

    @Test
    public void verify_any_argument() {
        List<String> mockedList = mock(HelloMyList.class);
        mockedList.add("test");
        verify(mockedList).add(anyString());
    }

    @Test
    public void verify_using_argument_capture() {
        List<String> mockedList = mock(HelloMyList.class);
        mockedList.addAll(Arrays.<String>asList("someElement"));
        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(mockedList).addAll(argumentCaptor.capture());
        List<String> capturedArgument = argumentCaptor.<List<String>>getValue();
        assertThat(capturedArgument, hasItem("someElement"));
        ;
    }
}
