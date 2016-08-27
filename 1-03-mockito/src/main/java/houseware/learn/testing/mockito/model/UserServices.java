package houseware.learn.testing.mockito.model;

import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class UserServices {
    private UserDAO userDAO;

    public UserServices(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User findAndUpper(Long id){
       User u =  userDAO.findById(id);
        if(u!=null){
            if(u.getId()>5) {
                u.setFirstName(u.getFirstName().toUpperCase());

            }  else {
                if(u.getId()<2) {
                 u.setLastName(u.getLastName().toUpperCase());
                }
            }
        }
        return u;
    }

    public List<User> list() {
        return userDAO.list();
    }
}
