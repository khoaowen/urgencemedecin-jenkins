package urgence_medecin.selenium.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urgence_medecin.selenium.driver.DriverManager;

public class CommonPageHelper {

	private CommonPageHelper() {

	}

	public static String getHeaderTitle() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathTitle = "//head/title";
		webDriverWait.withTimeout(Duration.ofSeconds(10)).until(e -> {
			return e.findElement(By.xpath(xpathTitle));
		});
		return chromeDriver.findElement(By.xpath(xpathTitle)).getAttribute("innerText");
	}

	public static String getHeaderCanonical() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathTitle = "//head//link[@rel=\"canonical\"]";
		webDriverWait.withTimeout(Duration.ofSeconds(10)).until(e -> {
			return e.findElement(By.xpath(xpathTitle));
		});
		return chromeDriver.findElement(By.xpath(xpathTitle)).getAttribute("href");
	}

	public static String getBlocAppelInMobileMode() {
		WebDriver chromeMobileDriver = DriverManager.getChromeMobileDriver();
		WebDriverWait webMobileDriverWait = DriverManager.getWebMobileDriverWait();
		String xpathTitle = "//div[@id=\"blocappel\"]//a[@href=\"tel:118018\"]";
		webMobileDriverWait.withTimeout(Duration.ofSeconds(10)).until(e -> {
			return e.findElement(By.xpath(xpathTitle));
		});
		return chromeMobileDriver.findElement(By.xpath(xpathTitle)).getAttribute("innerText");
	}
}
