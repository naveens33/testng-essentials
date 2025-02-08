# Data-Driven Testing in TestNG

Data-Driven Testing (DDT) allows testers to execute test cases with multiple sets of data without modifying test scripts. TestNG provides built-in support for DDT using `@DataProvider` and integrating with external sources like Excel and CSV.

## 1. Using `@DataProvider`
`@DataProvider` is a built-in TestNG annotation that supplies test data from a method.

### Example:
```java
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
    
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"user1", "pass1"},
            {"user2", "pass2"},
            {"user3", "pass3"}
        };
    }
    
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        System.out.println("Testing login with: " + username + " / " + password);
    }
}
```

## 2. Using Excel as a Data Source
We can use **Apache POI** to fetch data from Excel files.

### Example:
```java
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataProvider {
    @DataProvider(name = "excelData")
    public Object[][] readExcelData() throws IOException {
        FileInputStream file = new FileInputStream(new File("testdata.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        
        Object[][] data = new Object[rowCount - 1][colCount];
        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = row.getCell(j).toString();
            }
        }
        workbook.close();
        return data;
    }
}
```

## 3. Using CSV as a Data Source
```java
import org.testng.annotations.DataProvider;
import java.io.*;
import java.util.*;

public class CSVDataProvider {
    @DataProvider(name = "csvData")
    public Object[][] readCSV() throws IOException {
        List<String[]> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("testdata.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            data.add(line.split(","));
        }
        br.close();
        return data.toArray(new Object[0][]);
    }
}
```

## 4. Passing Data from `testng.xml`
TestNG allows passing parameters from `testng.xml` using `@Parameters`.

### Example:
**testng.xml**
```xml
<suite name="Suite">
    <test name="ParameterTest">
        <parameter name="username" value="admin"/>
        <parameter name="password" value="password123"/>
        <classes>
            <class name="com.example.ParameterTest"/>
        </classes>
    </test>
</suite>
```

**Test Class:**
```java
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
    @Test
    @Parameters({"username", "password"})
    public void testLogin(String username, String password) {
        System.out.println("Login test with: " + username + " / " + password);
    }
}
```

## Next Steps
Learn about **TestNG Parallel Execution** to speed up test execution.

[Next: Parallel Execution](parallel_execution.md)

