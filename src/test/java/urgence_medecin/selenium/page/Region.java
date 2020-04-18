package urgence_medecin.selenium.page;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urgence_medecin.selenium.driver.DriverManager;

public class Region {

	private Region() {
	}

	public static Region getPage() {
		return new Region();
	}

	public List<String> getDepartementsHref() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "//div[contains(@class,'et_pb_text_9')]//td/a";
		webDriverWait.withTimeout(Duration.ofSeconds(10)).until(d -> d.findElements(By.xpath(xpathExpression)));
		return chromeDriver.findElements(By.xpath(xpathExpression)).stream().map(e -> e.getAttribute("href"))
				.collect(Collectors.toList());
	}

	public String getDepartementAriegeText() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "//div[contains(@class,'et_pb_text_9')]//td/a";
		webDriverWait.withTimeout(Duration.ofSeconds(10)).until(d -> d.findElements(By.xpath(xpathExpression)));
		return chromeDriver.findElements(By.xpath(xpathExpression)).stream().map(e -> e.getAttribute("innerText"))
				.filter(e -> e.contains("Ariège")).findAny().get();
	}

	public String getAltLogoRegion() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "//div[contains(@class,\"et_pb_text_6\")]//img[contains(@class,\"wp-image-696\")]";
		webDriverWait.withTimeout(Duration.ofSeconds(10)).until(d -> d.findElements(By.xpath(xpathExpression)));
		return chromeDriver.findElement(By.xpath(xpathExpression)).getAttribute("alt");
	}

	public List<String> getMedecinParDepartementsHyperLink(String attribute) {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "//div[contains(@class,'et_pb_text_9')]//td/a";
		webDriverWait.withTimeout(Duration.ofSeconds(10))
				.until(d -> chromeDriver.findElements(By.xpath(xpathExpression)));
		return chromeDriver.findElements(By.xpath(xpathExpression)).stream().map(e -> e.getAttribute(attribute))
				.collect(Collectors.toList());
	}
}
