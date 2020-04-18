package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.Region;

public class UM_29 {

	@Test
	public void test_alt_sur_logo_de_la_region_bretagne() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/bretagne");
		Region region = Region.getPage();
		assertThat(region.getAltLogoRegion()).isEqualTo(
				"Trouver les informations d'un médecin de garde en Bretagne 24H24 7 jours sur 7 ouvert la nuit, le week-end, les jours fériés, et le dimanche.");
	}

	@Test
	public void test_alt_sur_logo_de_la_region_ile_de_france() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/ile-de-france");
		Region region = Region.getPage();
		assertThat(region.getAltLogoRegion()).isEqualTo(
				"Trouver le numéro d'un médecin de garde en Île-de-France 24H24 7 jours sur 7 la nuit, un jour férié, le dimanche ou week-end.");
	}

}
