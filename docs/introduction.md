# Introduction to TestNG

## What is TestNG?
TestNG (Test Next Generation) is a testing framework inspired by JUnit and NUnit, designed to simplify the creation of test cases while providing additional powerful features. It supports a variety of test configurations, making it a preferred choice for automation testing, especially with Selenium.

## Why Use TestNG Over JUnit?
- **Annotations**: More powerful and flexible annotations compared to JUnit.
- **Parallel Execution**: Allows running tests in parallel, reducing execution time.
- **Data-Driven Testing**: Supports parameterized tests using `@DataProvider`.
- **Flexible Test Configuration**: Supports test dependencies and groups.
- **Better Reporting**: Generates detailed HTML and XML reports.

## Features of TestNG
- **Test Prioritization & Dependency**: Execute tests in a specific order or define dependencies.
- **Flexible Test Execution**: Run specific tests using `testng.xml`.
- **Assertions & Soft Assertions**: Improve validation mechanisms.
- **Retry Mechanism**: Re-run failed tests automatically.

## Setting Up TestNG in a Selenium Project
### Step 1: Add TestNG Dependency
If using **Maven**, add the following to `pom.xml`:
```xml
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.2</version>
    <scope>test</scope>
</dependency>
```

### Step 2: Create a Simple TestNG Test
```java
import org.testng.annotations.Test;
public class SampleTest {
    @Test
    public void testMethod() {
        System.out.println("Hello, TestNG!");
    }
}
```
Run the test in Eclipse or via Maven:
```sh
mvn test
```

## Next Steps
Now that TestNG is set up, explore its powerful **annotations and configurations** to enhance your test automation framework!

[Next: Installation & Setup](installation.md)

