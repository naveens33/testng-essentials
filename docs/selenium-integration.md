# Selenium Integration with TestNG

Integrating Selenium WebDriver with TestNG allows efficient test automation with structured execution and reporting.

## 1. Setting Up Selenium with TestNG

### a) Add Dependencies (Maven)
```xml
<dependencies>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.7.0</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.6.0</version>
    </dependency>
</dependencies>
```

## 2. Writing a Basic Selenium Test with TestNG

```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openGoogle() {
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
```

## 3. Parallel Execution of Selenium Tests

Modify `testng.xml` to run tests in parallel.
```xml
<suite name="Parallel Suite" parallel="methods" thread-count="2">
    <test name="ChromeTest">
        <classes>
            <class name="com.example.SeleniumTest"/>
        </classes>
    </test>
</suite>
```

## 4. Using WebDriver Manager
Avoid manual driver setup using `WebDriverManager`.
```java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class SeleniumTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
```

## 5. Integrating with Reports & Logs
Use TestNG listeners and reports to track execution.

## Next Steps
Learn about **TestNG Reporting & Logging** to enhance test visibility.

[Next: TestNG Reporting & Logging](testng_reporting.md)

