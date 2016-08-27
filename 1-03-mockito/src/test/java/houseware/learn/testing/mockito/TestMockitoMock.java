package houseware.learn.testing.mockito;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockSettings;
import org.mockito.exceptions.verification.TooLittleActualInvocations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class TestMockitoMock {

    private static class CustomAnswer implements Answer<Boolean> {
        @Override
        public Boolean answer(InvocationOnMock invocation) throws Throwable {
            return false;
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void whenUsingSimpleMock_thenCorrect() {
        HelloMyList listMock = mock(HelloMyList.class);
        when(listMock.add(anyString())).thenReturn(false);
        boolean added = listMock.add(HelloMyList.timestampString());

        verify(listMock).add(anyString());
        assertThat(added, is(false));
    }

    @Test
    public void whenUsingMockWithName_thenCorrect() {
        HelloMyList listMock = mock(HelloMyList.class, "myMock");
        when(listMock.add(anyString())).thenReturn(false);
        listMock.add(HelloMyList.timestampString());

        thrown.expect(TooLittleActualInvocations.class);
        thrown.expectMessage(containsString("myMock.add"));

        verify(listMock, times(2)).add(anyString());
    }

    @Test
    public void whenUsingMockWithAnswer_thenCorrect() {
        HelloMyList listMock = mock(HelloMyList.class, new CustomAnswer());
        boolean added = listMock.add(HelloMyList.timestampString());

        verify(listMock).add(anyString());
        assertThat(added, is(false));
    }

    @Test
    public void whenUsingMockWithSettings_thenCorrect() {
        MockSettings customSettings = withSettings().defaultAnswer(new CustomAnswer());
        HelloMyList listMock = mock(HelloMyList.class, customSettings);
        boolean added = listMock.add(HelloMyList.timestampString());

        verify(listMock).add(anyString());
        assertThat(added, is(false));
    }
}