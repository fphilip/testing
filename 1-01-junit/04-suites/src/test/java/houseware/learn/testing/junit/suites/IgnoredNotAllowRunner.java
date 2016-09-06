package houseware.learn.testing.junit.suites;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class IgnoredNotAllowRunner extends BlockJUnit4ClassRunner {

    public IgnoredNotAllowRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected boolean isIgnored(FrameworkMethod child) {
        return false;
    }
}
