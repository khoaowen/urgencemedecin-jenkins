package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.CommonPageHelper;

public class UM_5 {

	@Test
	public void testTitreDeLaRegionDansMetaDonnee() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes");
		String title = CommonPageHelper.getHeaderTitle();
		assertThat(title).contains("Auvergne-rhone-alpes");
	}

	@Test
	public void testTitreDeDepartementDansMetaDonnee() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes/rhone-69/");
		String title = CommonPageHelper.getHeaderTitle();
		assertThat(title).contains("Rhone");
	}

	@Test
	public void testTitreDeVilleDansMetaDonnee() {
		TestSuiteSelenium.getWebDriver().get(
				"https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes/rhone-69/villefranche-sur-saone-69400/");
		String title = CommonPageHelper.getHeaderTitle();
		assertThat(title).contains("Villefranche-sur-saone");
	}

}
