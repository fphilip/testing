package houseware.learn.testing.jee;

import javax.ejb.Stateless;

/**
 * @author fphilip@houseware.es
 */
@Stateless
public class MyServiceBean {


    public void tic(){
        System.err.println("TIC");
    }
}
