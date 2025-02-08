import org.testng.annotations.*;

public class SampleTest2 {

    @Test(groups = {"smoke"})
    public void testMethod1(){
        System.out.println("SampleTest2.testMethod1");
    }

    @Test
    public void testMethod2() throws InterruptedException {
        System.out.println("testMethod2");
    }

    @Test(dependsOnMethods = {"testMethod2"})
    public void testMethod3(){
        System.out.println("testMethod3");
    }
}
