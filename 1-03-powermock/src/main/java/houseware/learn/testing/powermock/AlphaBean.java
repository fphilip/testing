package houseware.learn.testing.powermock;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

@ManagedBean
@RequestScoped
public class AlphaBean {
    public String incrementFoo() {
        Map<String, Object> session = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSessionMap();
        Integer foo = (Integer) session.get("foo");
        foo = (foo == null) ? 1 : foo + 1;
        session.put("foo", foo);
        return null;
    }
}