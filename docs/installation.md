# Installation & Setup

## Installing TestNG in Eclipse
1. Open **Eclipse** and go to `Help > Eclipse Marketplace`.
2. Search for **TestNG**.
3. Click **Install** and restart Eclipse.
4. Verify the installation by creating a new TestNG test class.

## Installing TestNG using Maven
If you're using **Maven**, add the following dependency to your `pom.xml` file:
```xml
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.7.0</version>
    <scope>test</scope>
</dependency>
```
Run the following command to ensure the dependencies are installed:
```sh
mvn clean install
```

## Installing TestNG using Gradle
For **Gradle** projects, add this to your `build.gradle` file:
```gradle
dependencies {
    testImplementation 'org.testng:testng:7.7.0'
}
```
Run:
```sh
gradle build
```

## Setting Up TestNG in IntelliJ IDEA
1. Open **IntelliJ IDEA**.
2. Navigate to `File > Project Structure > Modules > Dependencies`.
3. Click `+` and search for **TestNG**.
4. Apply changes and restart IntelliJ.

## Running a TestNG Test
### Create a Simple TestNG Class
```java
import org.testng.annotations.Test;
public class SampleTest {
    @Test
    public void testMethod() {
        System.out.println("Hello, TestNG!");
    }
}
```
### Running the Test
- **Eclipse/IntelliJ**: Right-click on the class and select `Run As > TestNG Test`.
- **Maven**: Run `mvn test`.
- **Command Line**: Use `java -cp "bin;lib/*" org.testng.TestNG testng.xml`.

[Next: TestNG Annotations](annotations.md)

