package org.example;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

public class App {
    public static WindowsDriver driver;

    public static WebElement element(String x) {
        return driver.findElementByAccessibilityId(x);
    }
    public static void main(String[] args) {
        
        try {
            System.out.println("Task 3 (Java)");
            
            System.out.println("\nDriver initialization and Application launch");
            System.out.println("    setting capabilities");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
            capabilities.setCapability("platformName", "Windows");
            capabilities.setCapability("deviceName", "WindowsPC");
            
            System.out.println("    Lauching app with connection to WinAppDriver");
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            Thread.sleep(2000);
            
            System.out.println("\nUI element identification");
            System.out.println("    indentifying");
            WebElement btn5 = element("num5Button"),
                btnPlus = element("plusButton"),
                btn3 = element("num3Button"),
                btnEquals = element("equalButton"),
                display = element("CalculatorResults");
            
            Thread.sleep(500);
            System.out.println("\nUser interaction");
            System.out.println("    Clicking 5");
            btn5.click();
            Thread.sleep(500);

            System.out.println("    Clicking +");
            btnPlus.click();
            Thread.sleep(500);
            
            System.out.println("    Clicking 3");            
            btn3.click();
            Thread.sleep(500);
            
            System.out.println("    Clicking equal");
            btnEquals.click();
            Thread.sleep(1000); 
            
            System.out.println("\nValidation of output");
            String displayText = display.getAttribute("Name");  
            System.out.println("    Got display text: \"" + displayText + "\"");
            
            System.out.println("    Extracting result");
            
            String resultStr = displayText.replace("Display is ", "").trim();
            System.out.println("    Comparing result " + resultStr+ " with expected value 8");
            
            if (resultStr.equals("8")) {
                System.out.println("    PASSED");
            } else {
                System.out.println("    FAILED");
            }
            Thread.sleep(2000); 

        } catch (Exception e) {
            System.err.println("\nGot an error during execution!");
            System.err.println("Error message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                System.out.println("\nClean session termination");
                System.out.println("    Quitting driver");
                driver.quit();
                System.out.println("\nAll done");
            }
        }
    }
}