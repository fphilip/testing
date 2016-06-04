package houseware.learn.testing.junit.runners.utils;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class OurRunner extends BlockJUnit4ClassRunner {

    public OurRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

}
