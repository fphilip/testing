package houseware.learn.testing.junit.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(CategoryTwo.class)
@Categories.ExcludeCategory(CategoryOne.class)
@Suite.SuiteClasses({TestCategoryA.class, TestCategoryB.class})
public class TestCategoryTwo {

}
