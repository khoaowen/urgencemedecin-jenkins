package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.Departement;

public class UM_32 {

	@Test
	public void test_departements_de_la_region_filtres() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/grand-est/meuse-55/");
		Departement departement = Departement.getPage();
		assertThat(departement.getDepartementsDeLaRegion("href")).allMatch(e -> e.contains("grand-est"));
	}

}
