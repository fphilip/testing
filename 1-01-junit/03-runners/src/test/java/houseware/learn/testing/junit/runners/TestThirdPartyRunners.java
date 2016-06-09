package houseware.learn.testing.junit.runners;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "/context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestThirdPartyRunners {

    @Autowired
    MyBean bean;

    @Test
    public void autowired_ok() {
        Assert.assertNotNull("contexto ok", bean);
    }


}
