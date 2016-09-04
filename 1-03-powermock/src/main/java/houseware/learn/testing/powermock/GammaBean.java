package houseware.learn.testing.powermock;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.Map;

@ManagedBean
@ApplicationScoped
@SuppressWarnings("unused")
public class GammaBean {
    @ManagedProperty("#{facesBroker}")
    private FacesBroker broker;

    public FacesBroker getBroker() {
        return broker;
    }

    public void setBroker(FacesBroker broker) {
        this.broker = broker;
    }

    public String incrementFoo() {
        Map<String, Object> session = broker.getContext()
                .getExternalContext()
                .getSessionMap();
        Integer foo = (Integer) session.get("foo");
        foo = (foo == null) ? 1 : foo + 1;
        session.put("foo", foo);
        return null;
    }
}
