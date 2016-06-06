package houseware.learn.testing.junit.rules;

import houseware.learn.testing.junit.rules.utils.CustomRule;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomRuleTest {

    private List<Integer> array;

    @Rule
    public CustomRule customRule = new CustomRule();

    @After
    public void tearsDown(){
        System.out.println();
    }


    @Test
    public void customRulesArrayList() throws IOException {
        String path = System.getProperty("user.home") + File.separator + "test.txt";
        File file = customRule.fileManager(path);
        assertEquals(file.getAbsolutePath(), path);
    }
}
