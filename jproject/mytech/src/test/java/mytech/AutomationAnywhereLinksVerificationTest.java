package mytech;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AutomationAnywhereLinksVerificationTest {

	 WebDriver driver;
    VerifyLinks linkVerifier = new VerifyLinks(driver);
   

    @BeforeClass
    public void setUp() {
    	String driver_dir = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", driver_dir + "\\src\\test\\resources\\driver\\chromedriver.exe");

    }

    @Test(priority = 1, enabled = true, timeOut = 5000)
    public void testVerifyProductsLink() {
        Assert.assertTrue(linkVerifier.verifyAndClickLink("Products"), "Products link verification failed.");
    }

    @Test(priority = 2, enabled = true, timeOut = 5000)
    public void testVerifySolutionsLink() {
        Assert.assertTrue(linkVerifier.verifyAndClickLink("Solutions"), "Solutions link verification failed.");
    }

    @Test(priority = 3, enabled = true, timeOut = 5000)
    public void testVerifyResourcesLink() {
        Assert.assertTrue(linkVerifier.verifyAndClickLink("Resources"), "Resources link verification failed.");
    }

    @Test(priority = 4, enabled = true, timeOut = 5000)
    public void testVerifyBeyondRPALink() {
        Assert.assertTrue(linkVerifier.verifyAndClickLink("Beyond RPA"), "Beyond RPA link verification failed.");
    }

    @Test(priority = 5, enabled = true, timeOut = 5000)
    public void testVerifyCompanyLink() {
        Assert.assertTrue(linkVerifier.verifyAndClickLink("Company"), "Company link verification failed.");
    }

    @AfterClass
    public void tearDown() {
        // Clean up or finalize any resources if needed
    }
}
