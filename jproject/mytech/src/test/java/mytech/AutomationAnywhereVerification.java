package mytech;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationAnywhereVerification {
	public static void main(String[] args) {

		String driver_dir = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", driver_dir + "\\src\\test\\resources\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.automationanywhere.com/");

		WebElement logo = driver.findElement(By.xpath("//img[@alt='Automation Anywhere']"));
		if (logo.isDisplayed()) {
			System.out.println("Automation Anywhere logo is present.");
		} else {
			System.out.println("Automation Anywhere logo is not present.");
		}

		WebElement requestDemoButton = driver.findElement(By.xpath("//a[text()='Request demo']"));
		if (requestDemoButton.isDisplayed()) {
			System.out.println("Request Demo button is present.");

			if (requestDemoButton.isEnabled()) {
				System.out.println("Request Demo button is clickable.");
			} else {
				System.out.println("Request Demo button is not clickable.");
			}
		} else {
			System.out.println("Request Demo button is not present.");
		}

		driver.quit();
	}
}
