package houseware.learn.testing.jee;

import javax.ejb.Local;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */

@Local
@SuppressWarnings("unused")
public interface MyService {

    void tic();

    void addEntity(MyEntity entity);

    void deleteEntity(MyEntity entity);

    List<MyEntity> getEntities();

}
