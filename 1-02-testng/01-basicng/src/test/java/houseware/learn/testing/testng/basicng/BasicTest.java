package houseware.learn.testing.testng.basicng;

import org.testng.annotations.*;

public class BasicTest {

    @BeforeGroups("beforeGroups")
    public void beforeGroups() {
        System.out.println("@BeforeGroups");
    }

    @AfterGroups("afterGroups")
    public void afterGroups() {
        System.out.println("@AfterGroups");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod");
    }

    @Test
    public void basicTest(){
        //asserts
    }
}
