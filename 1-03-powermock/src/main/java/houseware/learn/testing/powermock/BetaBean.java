package houseware.learn.testing.powermock;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

@ManagedBean
@RequestScoped
public class BetaBean {
    @ManagedProperty("#{facesContext}")
    private FacesContext context;

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }

    public String incrementFoo() {
        Map<String, Object> session = context.getExternalContext()
                .getSessionMap();
        Integer foo = (Integer) session.get("foo");
        foo = (foo == null) ? 1 : foo + 1;
        session.put("foo", foo);
        return null;
    }
}
