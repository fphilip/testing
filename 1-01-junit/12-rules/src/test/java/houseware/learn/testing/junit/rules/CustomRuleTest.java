package houseware.learn.testing.junit.rules;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CustomRuleTest {

    @Rule
    public CustomRule customRule = new CustomRule();

    @After
    public void tears_down(){
        System.out.println();
    }


    @Test
    public void custom_rules_arrayList() throws IOException {
        String path = System.getProperty("user.home") + File.separator + "test.txt";
        File file = customRule.fileManager(path);
        assertEquals(file.getAbsolutePath(), path);
    }
}
