package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.Region;

public class UM_10 {

	@Test
	public void test_departement_code_commence_par_zero() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/occitanie/");
		Region region = Region.getPage();
		region.getDepartementAriegeText();
		assertThat(region.getDepartementAriegeText()).contains("09");
	}

}
