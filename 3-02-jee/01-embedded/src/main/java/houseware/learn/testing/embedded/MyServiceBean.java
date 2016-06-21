package houseware.learn.testing.embedded;

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
