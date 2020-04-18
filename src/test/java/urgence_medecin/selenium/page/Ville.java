package urgence_medecin.selenium.page;

import java.time.Duration;

import org.assertj.core.util.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import urgence_medecin.selenium.driver.DriverManager;

public class Ville {

	private Ville() {
	}

	public static Ville getPage() {
		return new Ville();
	}

	public String getDescriptionElement() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "//div[@class='et_pb_row et_pb_row_1']//p//b";
		webDriverWait.withTimeout(Duration.ofSeconds(10)).until(d -> d.findElement(By.xpath(xpathExpression)));
		return chromeDriver.findElement(By.xpath(xpathExpression)).getText();
	}

	public String getQuestionsPhraseH2() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "//div[contains(@class,\"et_pb_text_3\")]//h2";
		webDriverWait.withTimeout(Duration.ofSeconds(10)).until(d -> d.findElement(By.xpath(xpathExpression)));
		return chromeDriver.findElements(By.xpath(xpathExpression)).stream().map(e -> e.getAttribute("innerText"))
				.reduce((x, y) -> Strings.concat(x, "\n", y)).get();
	}

	public String getAllTextDescriptions() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "//div[contains(@class,\"et_pb_text_3\")]//div";
		webDriverWait.withTimeout(Duration.ofSeconds(10)).until(d -> d.findElement(By.xpath(xpathExpression)));
		return chromeDriver.findElements(By.xpath(xpathExpression)).stream().map(e -> e.getAttribute("innerText"))
				.reduce((x, y) -> Strings.concat(x, "\n", y)).get();
	}

	public String getAllDescriptionTextsInPage() {
		StringBuilder bd = new StringBuilder();
		bd.append(getDescriptionElement());
		bd.append("\n");
		bd.append(getQuestionsPhraseH2());
		bd.append("\n");
		bd.append(getAllTextDescriptions());
		bd.append("\n");
		return bd.toString();
	}

	public String getAltLogoVille() {
		WebDriver chromeDriver = DriverManager.getChromeDriver();
		WebDriverWait webDriverWait = DriverManager.getWebDriverWait();
		String xpathExpression = "//div[contains(@class,\"et_pb_text_4\")]//img[contains(@class,\"wp-image-696\")]";
		webDriverWait.withTimeout(Duration.ofSeconds(10)).until(d -> d.findElements(By.xpath(xpathExpression)));
		return chromeDriver.findElement(By.xpath(xpathExpression)).getAttribute("alt");
	}

}
