package houseware.learn.testing.jee;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author fphilip@houseware.es
 */

@Entity
public class MyEntity {
    @Id
    private String id;
    @Column
    private String name;

    public MyEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public MyEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

