package houseware.learn.testing.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author fphilip@houseware.es
 */
@Data
@Entity
public class Player {
    @Id
    @Column
    private String id;
    @Column
    private String name;
    @ManyToOne
    private Club club;
}
