package houseware.learn.testing.powermock.test;


import houseware.learn.testing.powermock.BetaBean;
import org.junit.Test;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BetaBeanTest {
    @Test
    public void testIncrementFoo() {
        Map<String, Object> session = new HashMap<String, Object>();
        ExternalContext ext = mock(ExternalContext.class);
        when(ext.getSessionMap()).thenReturn(session);
        FacesContext context = mock(FacesContext.class);
        when(context.getExternalContext()).thenReturn(ext);

        BetaBean bean = new BetaBean();
        bean.setContext(context);
        bean.incrementFoo();
        assertEquals(1, session.get("foo"));
        bean.incrementFoo();
        assertEquals(2, session.get("foo"));
    }
}