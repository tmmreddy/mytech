package mytech;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyLinks {
	static WebDriver driver;
	VerifyLinks(WebDriver driver){
		driver=VerifyLinks.driver;
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
