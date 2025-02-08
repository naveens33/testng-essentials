# TestNG Reporting & Logging

TestNG provides built-in reporting features and allows integration with logging frameworks for better test insights.

## 1. Default TestNG Reports
TestNG generates HTML and XML reports after execution.

### a) HTML Report Location
After running tests, reports are stored in:
```
/test-output/index.html
```

### b) XML Report
Contains detailed test execution results at:
```
/test-output/testng-results.xml
```

## 2. Customizing TestNG Reports
Use `IReporter` to generate custom reports.

```java
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;
import java.util.List;

public class CustomReporter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        System.out.println("Generating Custom Report...");
    }
}
```

### Register in `testng.xml`
```xml
<suite name="Suite">
    <listeners>
        <listener class-name="com.example.CustomReporter"/>
    </listeners>
</suite>
```

## 3. Using Logs in TestNG
TestNG supports logging using `Reporter.log()`.
```java
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoggingTest {
    @Test
    public void testMethod() {
        Reporter.log("This is a log message", true);
    }
}
```

## 4. Integrating with Log4j
Use Log4j for better log management.

### a) Add Log4j Dependency (Maven)
```xml
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.17.1</version>
</dependency>
```

### b) Log4j Configuration (`log4j2.xml`)
```xml
<Configuration status="WARN">
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers>
</Configuration>
```

### c) Using Log4j in TestNG Tests
```java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jTest {
    private static final Logger logger = LogManager.getLogger(Log4jTest.class);

    @Test
    public void testLogging() {
        logger.info("This is an info message");
        logger.error("This is an error message");
    }
}
```

## Next Steps
Learn about **TestNG Assertions & Soft Assertions** to improve test validation.

[Next: TestNG Assertions & Soft Assertions](testng_assertions.md)

