package mytech;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationAnywhereLinksVerification {
	public static void main(String[] args) throws InterruptedException {
		String driver_dir = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", driver_dir + "\\src\\test\\resources\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.automationanywhere.com/");

		Thread.sleep(30000);

		acceptCookies(driver);

		verifyAndClickLink(driver, "Products");
		verifyAndClickLink(driver, "Solutions");
		verifyAndClickLink(driver, "Resources");
		verifyAndClickLink(driver, "Beyond RPA");
		verifyAndClickLink(driver, "Company");

		driver.quit();
	}

	private static void acceptCookies(WebDriver driver) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
			WebElement overlay = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
			if (overlay.isDisplayed()) {
				overlay.click();
				System.out.println("Clicked 'Accept All Cookies' button.");
			}
		} catch (Exception e) {

			System.out.println("Cookies overlay or button not found.");
		}
	}

	private static void verifyAndClickLink(WebDriver driver, String linkText) {
		try {
			WebElement link = driver.findElement(By.xpath("//a[text()='" + linkText + "']"));

			if (link.isDisplayed()) {
				System.out.println(linkText + " link is present.");

				link.click();

				String expectedTitle = linkText;
				
				if (driver.getTitle().contains(expectedTitle)) {
					System.out.println("Successfully navigated to " + expectedTitle + " page.");
				} else {
					System.out.println("Navigation to " + expectedTitle + " page failed.");
				}

				driver.navigate().back();
			} else {
				System.out.println(linkText + " link is not present.");
			}
		} catch (Exception e) {
			System.out.println("element not found: " + linkText);

		}
	}
}
