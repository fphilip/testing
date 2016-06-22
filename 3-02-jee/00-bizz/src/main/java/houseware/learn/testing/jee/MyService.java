package houseware.learn.testing.jee;

import java.util.List;

/**
 * @author fphilip@houseware.es
 */

public interface MyService {

    void tic();

    void addEntity(MyEntity entity);

    void deleteEntity(MyEntity entity);

    List<MyEntity> getEntities();

}
