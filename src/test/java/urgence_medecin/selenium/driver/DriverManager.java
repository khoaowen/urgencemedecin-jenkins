package urgence_medecin.selenium.driver;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static WebDriver driver = null;
	private static WebDriver mobileDriver = null;
	private static WebDriverWait driverWait = null;
	private static WebDriverWait mobileDriverWait = null;

	private DriverManager() {
	}

	public static WebDriver getChromeDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation");
			options.addArguments("--disable-gpu");
			driver = new ChromeDriver(options);
		}
		return driver;
	}

	public static WebDriver getChromeMobileDriver() {
		if (mobileDriver == null) {
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "Nexus 5");
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			mobileDriver = new ChromeDriver(chromeOptions);
		}
		return mobileDriver;

	}

	public static WebDriverWait getWebDriverWait() {
		if (driverWait == null) {
			driverWait = new WebDriverWait(getChromeDriver(), 10);
		}
		return driverWait;
	}

	public static WebDriverWait getWebMobileDriverWait() {
		if (mobileDriverWait == null) {
			mobileDriverWait = new WebDriverWait(getChromeMobileDriver(), 10);
		}
		return mobileDriverWait;
	}

}
