package houseware.learn.testing.mockito;

import java.util.AbstractList;

public class HelloMyList extends AbstractList<String> {

    @Override
    public String get(final int index) {
        return null;
    }

    @Override
    public int size() {
        return 1;
    }

    public static String timestampString(){
        return "[" + System.currentTimeMillis() + "]";
    }
}