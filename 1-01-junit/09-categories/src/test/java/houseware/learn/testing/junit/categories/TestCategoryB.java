package houseware.learn.testing.junit.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestCategoryB {

    @Test
    @Category(CategoryTwo.class)
    public void testA() {
        System.out.println("TestCategoryB testA");
    }

    @Test
    @Category(CategoryOne.class)
    public void testB() {
        System.out.println("TestCategoryB testB");
    }

    @Test
    @Category(CategoryTwo.class)
    public void testC() {
        System.out.println("TestCategoryB testC");
    }

}
