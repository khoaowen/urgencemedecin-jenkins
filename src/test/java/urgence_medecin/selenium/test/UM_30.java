package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.Departement;

public class UM_30 {

	@Test
	public void test_alt_sur_logo_de_departement_aube() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/grand-est/aube-10/");
		Departement dep = Departement.getPage();
		assertThat(dep.getAltLogoDepartement()).isEqualTo(
				"Trouver les coordonnées du médecin de garde Aube (10) 24H24 7 jours sur 7 la nuit, un jour férié, le dimanche ou week-end.");
	}

	@Test
	public void test_alt_sur_logo_de_departement_isere() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/auvergne-rhone-alpes/isere-38/");
		Departement dep = Departement.getPage();
		assertThat(dep.getAltLogoDepartement()).isEqualTo(
				"Trouver le médecin de garde Isère (38) 24H sur 24 7 jours sur 7 à toute heure de la journée même le week-end, les jours fériés, la nuit.");
	}

}
