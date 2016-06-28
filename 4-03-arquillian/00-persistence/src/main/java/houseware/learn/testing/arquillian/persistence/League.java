package houseware.learn.testing.arquillian.persistence;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author fphilip@houseware.es
 */
@Data
@Entity(name="PEPE")
public class League {
    @Id
    @Column
    private String id;

    @Column(unique = true)
    private String name;

}
