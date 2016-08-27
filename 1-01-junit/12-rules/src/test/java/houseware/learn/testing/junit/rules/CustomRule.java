package houseware.learn.testing.junit.rules;


import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.File;
import java.io.IOException;


public class CustomRule implements TestRule {

    private File file;

    @Override
    public Statement apply(Statement statement, Description description) {
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                clearfile();
                try {
                    statement.evaluate();
                } finally {
                    deleteFile();
                }
            }
        };
    }

    public File fileManager(String path) throws IOException {
        file = new File(path);
        if (!file.createNewFile()){
            throw new IllegalArgumentException("File already exists.");
        }
        return file;
    }

    public void clearfile(){
        this.file = null;
    }

    public void deleteFile() throws IOException {
        if(!file.delete()){
            throw new IOException("Delete operation is failed.");
        }
    }
}
