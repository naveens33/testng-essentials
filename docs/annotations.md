# TestNG Annotations

TestNG provides a set of powerful annotations to control the execution flow of test methods. These annotations help in organizing and managing test cases efficiently.

## Commonly Used TestNG Annotations

### 1. `@Test`
Defines a test method that will be executed by TestNG.
```java
import org.testng.annotations.Test;
public class TestExample {
    @Test
    public void testMethod() {
        System.out.println("Executing Test Method");
    }
}
```

### 2. `@BeforeSuite` & `@AfterSuite`
Executed once before and after the entire test suite.
```java
import org.testng.annotations.*;
public class SuiteSetup {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite Execution");
    }
    
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite Execution");
    }
}
```

### 3. `@BeforeTest` & `@AfterTest`
Executed before and after any `<test>` tag in `testng.xml`.
```java
public class TestSetup {
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test Execution");
    }
    
    @AfterTest
    public void afterTest() {
        System.out.println("After Test Execution");
    }
}
```

### 4. `@BeforeClass` & `@AfterClass`
Executed before and after any test class runs.
```java
public class ClassSetup {
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class Execution");
    }
    
    @AfterClass
    public void afterClass() {
        System.out.println("After Class Execution");
    }
}
```

### 5. `@BeforeMethod` & `@AfterMethod`
Executed before and after every test method in a class.
```java
public class MethodSetup {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Each Test Method");
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Each Test Method");
    }
}
```

### 6. `@DataProvider`
Provides test data to test methods.
```java
import org.testng.annotations.*;
public class DataProviderExample {
    @DataProvider(name = "data-set")
    public Object[][] dataProviderMethod() {
        return new Object[][] { {"data1"}, {"data2"} };
    }
    
    @Test(dataProvider = "data-set")
    public void testMethod(String data) {
        System.out.println("Test Data: " + data);
    }
}
```

### 7. `@Parameters`
Passes parameters from `testng.xml`.
```java
import org.testng.annotations.*;
public class ParameterExample {
    @Test
    @Parameters({"username"})
    public void testMethod(String username) {
        System.out.println("Username: " + username);
    }
}
```
XML Example:
```xml
<suite name="Suite">
    <test name="Test">
        <parameter name="username" value="testUser"/>
        <classes>
            <class name="ParameterExample"/>
        </classes>
    </test>
</suite>
```

## `@Test` Annotation & Attributes

The `@Test` annotation is the primary annotation in TestNG, marking a method as a test case. It provides multiple attributes to control test execution behavior.

### Attributes:

1. **`priority`** - Defines the execution order of test methods.
   ```java
   @Test(priority = 1)
   public void firstTest() {
       System.out.println("First Test");
   }

   @Test(priority = 2)
   public void secondTest() {
       System.out.println("Second Test");
   }
   ```

2. **`dependsOnMethods`** - Specifies dependency on other test methods.
   ```java
   @Test
   public void loginTest() {
       System.out.println("Login Test");
   }

   @Test(dependsOnMethods = "loginTest")
   public void dashboardTest() {
       System.out.println("Dashboard Test");
   }
   ```

3. **`enabled`** - Controls whether a test runs or is ignored.
   ```java
   @Test(enabled = false)
   public void skippedTest() {
       System.out.println("This test will not execute");
   }
   ```

4. **`invocationCount`** - Runs a test multiple times.
   ```java
   @Test(invocationCount = 3)
   public void repeatTest() {
       System.out.println("Repeated Test");
   }
   ```

5. **`timeOut`** - Fails a test if it exceeds a specified duration.
   ```java
   @Test(timeOut = 2000) // 2 seconds
   public void timeSensitiveTest() throws InterruptedException {
       Thread.sleep(1000);
       System.out.println("Test Completed");
   }
   ```

6. **`expectedExceptions`** - Specifies expected exceptions for validation.
   ```java
   @Test(expectedExceptions = ArithmeticException.class)
   public void exceptionTest() {
       int result = 1 / 0; // This will throw ArithmeticException
   }
   ```

7. **`groups`** - Categorizes tests into groups for selective execution.
   ```java
   @Test(groups = "smoke")
   public void smokeTest() {
       System.out.println("Smoke Test");
   }
   ```

## Next Steps
Explore how to configure **TestNG XML** for better test execution and management.

[Next: TestNG XML Configuration](testng-xml.md)

