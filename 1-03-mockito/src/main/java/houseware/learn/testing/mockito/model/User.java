package houseware.learn.testing.mockito.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 * @author fphilip@houseware.es
 */
@Entity
@NamedQuery(name="userByname",query="from User")
public class User {
    @Column
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;


    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
