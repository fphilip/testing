package houseware.learn.testing.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author fphilip@houseware.es
 */


@Entity
@SuppressWarnings("unused")
public class Club {
    @Id
    @Column
    private String id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    private League league;

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

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
