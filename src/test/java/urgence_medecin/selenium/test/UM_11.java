package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.Departement;

public class UM_11 {

	@Test
	public void test_garder_uniquement_premier_ville_code() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes/loire-42/");
		Departement departement = Departement.getPage();
		assertThat(departement.getVilleSaintEtienneText()).contains("SAINT-ETIENNE (42000)");
	}

}
