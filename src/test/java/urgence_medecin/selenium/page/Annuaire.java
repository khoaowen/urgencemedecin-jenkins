package urgence_medecin.selenium.page;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urgence_medecin.selenium.driver.DriverManager;

public class Annuaire {

	private Annuaire() {
	}

	public static Annuaire getPage() {
		return new Annuaire();
	}

	public List<String> getRegionsHref() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "//div[contains(@class,'col-1-3')]//a";
		webDriverWait.withTimeout(Duration.ofSeconds(10)).until(d -> d.findElements(By.xpath(xpathExpression)));
		return chromeDriver.findElements(By.xpath(xpathExpression)).stream().map(e -> e.getAttribute("href"))
				.collect(Collectors.toList());
	}
}
