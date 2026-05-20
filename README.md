# Windows Calculator Automation Test with WinAppDriver

Desktop automation project using WinAppDriver, Java 21, and Gradle. Automates Calculator to demonstrate Windows UI interaction.

## Setup Steps

**Create the project:**

Run `gradle init` and choose: Application → Java → version 21 → single application project → Groovy → JUnit Jupiter

**Add dependencies:**

Edit `app/build.gradle` and add these dependencies:

```gradle
implementation 'io.appium:java-client:7.3.0'
implementation 'org.seleniumhq.selenium:selenium-java:3.141.59'
```

Then run:
```bash
gradle build
```

## Project Structure

```
app/
├── src/main/java/org/example/
│   └── App.java                    # Calculator automation code
├── src/test/java/org/example/
│   └── AppTest.java
└── build.gradle                    # Dependencies added here
```

## Execution Process

**Start WinAppDriver first:**
```bash
"C:\Program Files (x86)\Windows Application Driver\WinAppDriver.exe"
```
Leave it running.
Suggestion: You can also add this folder in "path" of environment variables for quick starting.

**Run automation:**
```bash
gradle run
```

## Automation Workflow

1. **Driver Initialization** - Create DesiredCapabilities and connect to WinAppDriver (localhost:4723)

2. **Application Launch** - WinAppDriver starts target app

3. **UI Element Identification** - Use AutomationId to find elements
   - `created element function`
   - `Used element function to create app object connecting variables`

4. **User Interaction** - Click buttons, fetch display data
   - `btn.click() to click a button`
   - `display.getAttribute("Name") to fetch calculator display data`

5. **Validation** - Read display values and compare with expected results

6. **Exception Handling** - try-catch wraps all automation, errors are printed

7. **Clean Session Termination** - finally block ensures `driver.quit()` always runs

## Technology Stack

- Java 21.x
- Gradle 9.x
- WinAppDriver 1.2.1
- Appium Java Client 7.3.0
- Selenium 3.141.59