package houseware.learn.testing.powermock.test;

import houseware.learn.testing.powermock.AlphaBean;
import org.junit.Test;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlphaBeanTest {
    @Test
    public void testIncrementFoo() {
        FacesContext context = ContextMocker.mockFacesContext();
        try {
            Map<String, Object> session = new HashMap<>();
            ExternalContext ext = mock(ExternalContext.class);
            when(ext.getSessionMap()).thenReturn(session);
            when(context.getExternalContext()).thenReturn(ext);

            AlphaBean bean = new AlphaBean();
            bean.incrementFoo();
            assertEquals(1, session.get("foo"));
            bean.incrementFoo();
            assertEquals(2, session.get("foo"));
        } finally {
            context.release();
        }
    }
}