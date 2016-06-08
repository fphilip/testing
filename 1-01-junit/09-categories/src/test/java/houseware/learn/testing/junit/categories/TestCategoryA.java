package houseware.learn.testing.junit.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestCategoryA {

    @Test
    @Category(CategoryOne.class)
    public void testA() {
        System.out.println("TestCategoryA testA");
    }

    @Test
    @Category(CategoryTwo.class)
    public void testB() {
        System.out.println("TestCategoryA testB");
    }

    @Test
    @Category({CategoryOne.class, CategoryTwo.class})
    public void testC() {
        System.out.println("TestCategoryA testC");
    }
}
