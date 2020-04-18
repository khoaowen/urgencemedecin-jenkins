package urgence_medecin.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import urgence_medecin.selenium.driver.DriverManager;
import urgence_medecin.selenium.test.UM_1;
import urgence_medecin.selenium.test.UM_10;
import urgence_medecin.selenium.test.UM_11;
import urgence_medecin.selenium.test.UM_2;
import urgence_medecin.selenium.test.UM_21;
import urgence_medecin.selenium.test.UM_27;
import urgence_medecin.selenium.test.UM_28;
import urgence_medecin.selenium.test.UM_29;
import urgence_medecin.selenium.test.UM_3;
import urgence_medecin.selenium.test.UM_30;
import urgence_medecin.selenium.test.UM_31;
import urgence_medecin.selenium.test.UM_32;
import urgence_medecin.selenium.test.UM_4;
import urgence_medecin.selenium.test.UM_5;
import urgence_medecin.selenium.test.UM_9;

@RunWith(Suite.class)
// @formatter:off
@Suite.SuiteClasses({ 
	UM_1.class, 
	UM_2.class, 
	UM_4.class, 
	UM_3.class, 
	UM_5.class, 
	UM_9.class, 
	UM_10.class, 
	UM_11.class,
	UM_21.class, 
	UM_27.class, 
	UM_28.class, 
	UM_29.class, 
	UM_30.class, 
	UM_31.class, 
	UM_32.class/*, 
	UM_26.class,
	UM_33.class*/
	})
//@formatter:on
public class TestSuiteSelenium {

	protected static WebDriver webDriver;
	protected static WebDriverWait webDriverWait;
	protected static WebDriver webMobileDriver;
	protected static WebDriverWait webMobileDriverWait;

	@BeforeClass
	public static void initalize() {
		webDriver = DriverManager.getChromeDriver();
		webDriverWait = DriverManager.getWebDriverWait();
		webMobileDriver = DriverManager.getChromeMobileDriver();
		webMobileDriverWait = DriverManager.getWebMobileDriverWait();
	}

	@AfterClass
	public static void tearDown() {
		webDriver.close();
		try {
			webMobileDriver.close();
		} catch (WebDriverException e) {
			// the driver is already close, just ignore
		}
	}

	public static WebDriver getWebDriver() {
		if (webDriver == null) {
			initalize();
		}
		return webDriver;
	}

	public static WebDriverWait getWebDriverWait() {
		if (webDriverWait == null) {
			initalize();
		}
		return webDriverWait;
	}

	public static WebDriver getWebMobileDriver() {
		if (webMobileDriver == null) {
			initalize();
		}
		return webMobileDriver;
	}

	public static WebDriverWait getWebMobileDriverWait() {
		if (webMobileDriverWait == null) {
			initalize();
		}
		return webMobileDriverWait;
	}

}
