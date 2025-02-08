import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class SampleTest1 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("----BeforeSuite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("----AfterSuite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("---BeforeTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("---AfterTest");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("--BeforeClass");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("--AfterClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("-BeforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("-AfterMethod");
    }

    @BeforeGroups("smoke")
    public void beforeGroupSmoke(){
        System.out.println("------BeforeGroup");
    }
    @AfterGroups("smoke")
    public void afterGroupSmoke(){
        System.out.println("------AfterGroups");
    }

    @Test(priority = 1)
    public void testMethod2(){
        System.out.println("testMethod2");
        Assert.assertEquals(5,6,"Values not same");
    }

    @Test(priority = 2, groups = {"smoke"})
    public void testMethod1(){
        System.out.println("SampleTest1.testMethod1");
        Assert.assertEquals(5,4,"Values not same");
    }

    @Test(dependsOnGroups = {"smoke"})
    public void testMethod3(){
        System.out.println("testMethod3");
    }

    @Test(dataProvider = "dp1")
    public void testMethod4(Integer item){
        System.out.println(item);
        Assert.assertTrue(item>50);
    }

    @DataProvider
    public Integer[] dp1(){
        Integer[] arr = new Integer[]{56,89,19,78,10,88};
        return arr;
    }

    @Test(dataProvider = "dp2")
    public void testMethod6(String uname, String pwd){
        System.out.println(uname+" "+pwd);
    }

    @DataProvider
    public String[][] dp2(){
        String[][] arr = new String[][]{
                {"testuser1","testpassword"},
                {"testuser2","testpassword"},
        };
        return arr;
    }

    @Test(dataProvider = "dp3")
    public void testMethod7(String name, String regNum){
        System.out.println(name+" "+regNum);
    }

    @DataProvider
    public String[][] dp3() throws IOException {
        String[][] arr = ReadExcelData.getData();
        return arr;
    }

    @Test
    @Parameters({"username","password"})
    public void testMethod5(@Optional("mike") String user,@Optional("test12345")  String pass){
        System.out.println(user+" "+pass);
    }
}
