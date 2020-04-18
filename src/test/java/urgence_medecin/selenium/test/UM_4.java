package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;

public class UM_4 {

	@Test
	public void test_supprimer_les_pages_get_ville() {
		TestSuiteSelenium.getWebDriver()
				.get("https://www.urgence-medecin-garde.fr/get-region/get-departement/get-ville/");
		assertThat(TestSuiteSelenium.getWebDriver().getCurrentUrl())
				.contains("https://www.urgence-medecin-garde.fr/annuaire");
	}

	@Test
	public void test_supprimer_les_pages_get_departement() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/get-region/get-departement/");
		assertThat(TestSuiteSelenium.getWebDriver().getCurrentUrl())
				.contains("https://www.urgence-medecin-garde.fr/annuaire");
	}

	@Test
	public void test_supprimer_les_pages_get_region() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/get-region/");
		assertThat(TestSuiteSelenium.getWebDriver().getCurrentUrl())
				.contains("https://www.urgence-medecin-garde.fr/annuaire");
	}
}
