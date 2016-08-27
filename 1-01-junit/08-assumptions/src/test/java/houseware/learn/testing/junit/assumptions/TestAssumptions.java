package houseware.learn.testing.junit.assumptions;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assume.assumeThat;

public class TestAssumptions {

    @Test
    public void case_with_right_separator() {
        assumeThat(File.separatorChar, is('/'));
    }

    @Test
    public void case_with_left_separator() {
        assumeThat(File.separatorChar, is('\\'));
    }

}
