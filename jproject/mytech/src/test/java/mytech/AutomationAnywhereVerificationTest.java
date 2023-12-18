package mytech;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AutomationAnywhereLinksVerificationTest {

    private AutomationAnywhereVerification linkVerifier;

    private ReadAndWriteData reader;

    @BeforeClass
    public void setUp() {
        // Initialize your file path
        String filePath = "path/to/your/csv/file.csv";
        reader = new ReadAndWriteData(filePath);
    }

    @Test(priority = 1, enabled = true, timeOut = 5000)
    public void testVerifyLogo() {
        Assert.assertTrue(reader.isLogoPresent(), "Automation Anywhere logo is not present.");
    }

    @Test(priority = 2, enabled = true, timeOut = 5000)
    public void testVerifyRequestDemoButton() {
        Assert.assertTrue(reader.isRequestDemoButtonClickable(), "Request Demo button is not clickable.");
    }

    @AfterClass
    public void tearDown() {
        // Clean up or finalize any resources if needed
    }
}
