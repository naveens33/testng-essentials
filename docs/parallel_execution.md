# Parallel Execution in TestNG

Parallel Execution in TestNG allows running multiple test cases simultaneously, reducing execution time and improving efficiency. TestNG supports parallel execution at different levels: methods, classes, tests, and suites.

## 1. Enabling Parallel Execution
To enable parallel execution, modify `testng.xml` and set the `parallel` attribute with `methods`, `classes`, `tests`, or `suites`.

### Example:
```xml
<suite name="Parallel Suite" parallel="methods" thread-count="3">
    <test name="Test1">
        <classes>
            <class name="com.example.TestClass1"/>
            <class name="com.example.TestClass2"/>
        </classes>
    </test>
</suite>
```

## 2. Parallel Execution at Different Levels

### a) Parallel Methods Execution
Runs test methods in the same class concurrently.
```xml
<suite name="Parallel Methods" parallel="methods" thread-count="2">
    <test name="ParallelTest">
        <classes>
            <class name="com.example.TestClass"/>
        </classes>
    </test>
</suite>
```

### b) Parallel Classes Execution
Executes test classes in parallel.
```xml
<suite name="Parallel Classes" parallel="classes" thread-count="2">
    <test name="ClassLevelTest">
        <classes>
            <class name="com.example.TestClass1"/>
            <class name="com.example.TestClass2"/>
        </classes>
    </test>
</suite>
```

### c) Parallel Tests Execution
Runs multiple test cases simultaneously.
```xml
<suite name="Parallel Tests" parallel="tests" thread-count="2">
    <test name="TestOne">
        <classes>
            <class name="com.example.TestClass1"/>
        </classes>
    </test>
    <test name="TestTwo">
        <classes>
            <class name="com.example.TestClass2"/>
        </classes>
    </test>
</suite>
```

## 3. Running Parallel Execution with Data Providers
Use `@DataProvider` with `parallel=true` to execute tests in parallel with multiple data sets.
```java
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelDataTest {
    @DataProvider(name = "testData", parallel = true)
    public Object[][] getData() {
        return new Object[][] {
            {"user1", "pass1"},
            {"user2", "pass2"},
            {"user3", "pass3"}
        };
    }
    
    @Test(dataProvider = "testData")
    public void testLogin(String username, String password) {
        System.out.println("Testing login with: " + username + " / " + password);
    }
}
```

## 4. Parallel Execution with Selenium WebDriver
Ensure thread safety by using `ThreadLocal` for WebDriver instances in parallel execution.
```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(new ChromeDriver());
        }
        return driver.get();
    }
    
    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}
```

## Next Steps
Learn about **Retry Failed Tests in TestNG** to understand the mechanisms of retry failed tests.

[Next: Retry Failed Tests in TestNG](retry-failed-tests.md)

