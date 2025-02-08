# Assertions in TestNG

Assertions in TestNG are used to validate test conditions and ensure expected outcomes. TestNG provides two types of assertions:

- **Hard Assertions**: Stop execution if the assertion fails.
- **Soft Assertions**: Continue execution even if assertions fail.

## 1. Hard Assertions (Assert Class)

Hard assertions immediately halt test execution upon failure.

### Common Hard Assertion Methods:
```java
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionsExample {
    @Test
    public void testEqualStrings() {
        String actual = "TestNG";
        String expected = "TestNG";
        Assert.assertEquals(actual, expected, "Strings do not match!");
    }

    @Test
    public void testBooleanCondition() {
        boolean isDisplayed = true;
        Assert.assertTrue(isDisplayed, "Element is not displayed!");
    }
}
```

### Common Methods in `Assert` Class

| Method | Description |
|--------|------------|
| `assertEquals(actual, expected)` | Checks if values are equal. |
| `assertNotEquals(actual, expected)` | Checks if values are not equal. |
| `assertTrue(condition)` | Passes if condition is true. |
| `assertFalse(condition)` | Passes if condition is false. |
| `assertNull(object)` | Passes if object is null. |
| `assertNotNull(object)` | Passes if object is not null. |

## 2. Soft Assertions (SoftAssert Class)

Soft assertions allow multiple assertions in a test method without stopping execution immediately.

### Using `SoftAssert`:
```java
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsExample {
    @Test
    public void testMultipleConditions() {
        SoftAssert softAssert = new SoftAssert();
        
        softAssert.assertEquals("TestNG", "JUnit", "Names do not match!");
        softAssert.assertTrue(false, "Condition is false!");
        
        System.out.println("Test execution continues...");
        
        softAssert.assertAll(); // Must be called at the end
    }
}
```

### Key Points about `SoftAssert`
- Soft assertions **do not stop** execution immediately.
- Call `assertAll()` at the end to collect all failures.

## 3. Using Assertions in Real Test Scenarios

Assertions are widely used in **Selenium WebDriver** for validating UI elements.
```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumAssertionsTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://example.com");
    }

    @Test
    public void verifyTitle() {
        String expectedTitle = "Example Domain";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
    }

    @Test
    public void verifyElementDisplayed() {
        WebElement element = driver.findElement(By.id("someElement"));
        Assert.assertTrue(element.isDisplayed(), "Element is not visible!");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
```

## Next Steps
Learn about **Listeners & Reporting** to enhance test execution tracking.

[Next: Listeners & Reporting](listeners.md)

