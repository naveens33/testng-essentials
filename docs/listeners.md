# Listeners & Reporting in TestNG

Listeners in TestNG allow custom actions before, during, or after test execution. They help in logging, reporting, taking screenshots, and handling test failures.

## 1. Types of Listeners in TestNG

TestNG provides multiple listeners to extend test functionality:

| Listener Interface | Purpose |
|--------------------|---------|
| `ITestListener` | Listens to test execution events. |
| `ISuiteListener` | Tracks test suite execution. |
| `IInvokedMethodListener` | Monitors method invocation. |
| `IAnnotationTransformer` | Modifies test annotations at runtime. |

## 2. Implementing `ITestListener`

### Steps to Create a TestNG Listener:
1. Implement the `ITestListener` interface.
2. Override required methods.
3. Register the listener in `testng.xml`.

### Example:
```java
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
    }
}
```

### Register Listener in `testng.xml`
```xml
<listeners>
    <listener class-name="com.example.TestListener"/>
</listeners>
```

## 3. Generating TestNG Reports
TestNG provides built-in and custom reporting mechanisms.

### Default Reports
TestNG generates HTML and XML reports in the `test-output` directory.

### Creating a Custom Reporter
Implement `IReporter` to customize reports.
```java
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;
import java.util.List;

public class CustomReport implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        System.out.println("Generating custom report...");
    }
}
```

### Registering the Custom Reporter
```xml
<listeners>
    <listener class-name="com.example.CustomReport"/>
</listeners>
```

## 4. Capturing Screenshots on Failure (Selenium Example)
```java
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ScreenshotListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = new ChromeDriver();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        screenshot.renameTo(new File("failed_test.png"));
    }
}
```

## Next Steps
Explore **Data-Driven Testing** to enhance automation test coverage.

[Next: Data-Driven Testing](data_driven_testing.md)

