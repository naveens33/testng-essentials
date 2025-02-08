# Retry Failed Tests in TestNG

TestNG provides mechanisms to automatically retry failed tests, which is useful for handling transient issues like network failures, UI flakiness, or environment instability.

## 1. Using `IRetryAnalyzer`
TestNG allows retrying failed tests by implementing `IRetryAnalyzer`.

### Step 1: Create a Retry Class
```java
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 3; // Set max retry limit

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
```

### Step 2: Apply Retry to Test Cases
```java
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

public class SampleTest {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testMethod() {
        System.out.println("Executing test method");
        assert false; // Force failure for retry demonstration
    }
}
```

## 2. Using TestNG Listeners for Retry
We can use `IAnnotationTransformer` to apply retry logic dynamically.

### Step 1: Create a Retry Listener
```java
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (annotation.getRetryAnalyzer() == null) {
            annotation.setRetryAnalyzer(RetryAnalyzer.class);
        }
    }
}
```

### Step 2: Register the Listener in `testng.xml`
```xml
<suite name="Test Suite">
    <listeners>
        <listener class-name="com.example.RetryListener"/>
    </listeners>
    <test name="Retry Test">
        <classes>
            <class name="com.example.SampleTest"/>
        </classes>
    </test>
</suite>
```

## 3. Controlling Retry Attempts
- Set `maxRetryCount` in `RetryAnalyzer`.
- Apply retry only for specific failures using `result.getThrowable()` in `retry()` method.

## Next Steps
Learn about **TestNG Data Providers** for parameterized testing.

[Next: Selenium Integration with TestNG](selenium-integration.md)

