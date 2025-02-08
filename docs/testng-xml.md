# TestNG XML Configuration

TestNG uses an XML file (`testng.xml`) to configure and control test execution. This file allows testers to define test suites, groups, parallel execution, and dependencies efficiently.

## Basic Structure of `testng.xml`

A simple `testng.xml` file:
```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="TestSuite">
    <test name="TestCase1">
        <classes>
            <class name="com.example.TestClass"/>
        </classes>
    </test>
</suite>
```

## Key Elements in `testng.xml`

### 1. `<suite>`
Defines a test suite containing multiple tests.
```xml
<suite name="MySuite">
    ...
</suite>
```

### 2. `<test>`
Represents a test containing multiple classes.
```xml
<test name="LoginTests">
    <classes>
        <class name="com.example.LoginTest"/>
    </classes>
</test>
```

### 3. `<classes>` & `<class>`
Used to specify test classes.
```xml
<classes>
    <class name="com.example.TestClass"/>
</classes>
```

### 4. `<methods>`
Used to include/exclude specific test methods.
```xml
<methods>
    <include name="testLogin"/>
    <exclude name="testLogout"/>
</methods>
```

### 5. `<groups>`
Allows execution of specific groups of tests.
```xml
<groups>
    <run>
        <include name="sanity"/>
    </run>
</groups>
```

## Running Tests Using `testng.xml`
Execute the TestNG suite via command line:
```sh
java -cp "bin;lib/*" org.testng.TestNG testng.xml
```

Using **Maven**:
```sh
mvn test -Dsurefire.suiteXmlFiles=testng.xml
```

## Advanced Configurations
- **Parallel Execution**:
  ```xml
  <suite name="ParallelSuite" parallel="tests" thread-count="2">
  ```
- **Listeners Integration**:
  ```xml
  <listeners>
      <listener class-name="com.example.CustomListener"/>
  </listeners>
  ```

## Next Steps
Explore **Assertions in TestNG** to enhance validation in test scripts.

[Next: Assertions in TestNG](assertions.md)

