package houseware.learn.testing.junit.categories;

import houseware.learn.testing.junit.categories.utils.CategoryTwo;
import houseware.learn.testing.junit.categories.utils.TestCategoryA;
import houseware.learn.testing.junit.categories.utils.TestCategoryB;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(CategoryTwo.class)
@Suite.SuiteClasses({TestCategoryA.class, TestCategoryB.class})
public class CategoriesTestCategoryOne {
}
