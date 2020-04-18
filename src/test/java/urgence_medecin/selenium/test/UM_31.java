package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.Ville;

public class UM_31 {

	@Test
	public void test_alt_sur_logo_de_ville_loubers() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/occitanie/tarn-81/loubers-81170/");
		Ville ville = Ville.getPage();
		assertThat(ville.getAltLogoVille()).isEqualTo(
				"Trouver les coordonnées du médecin de garde à LOUBERS (81170) 24H24 7 jours sur 7 la nuit, un jour férié, le dimanche ou week-end.");
	}

	@Test
	public void test_alt_sur_logo_de_ville_saint_eugene_71() {
		TestSuiteSelenium.getWebDriver().get(
				"https://www.urgence-medecin-garde.fr/bourgogne-franche-comte/saone-et-loire-71/saint-eugene-71190/");
		Ville ville = Ville.getPage();
		assertThat(ville.getAltLogoVille()).isEqualTo(
				"Trouver le médecin de garde à SAINT-EUGENE (17520) 24H sur 24 7 jours sur 7 un dimanche, pendant le week-end, un jour férié le soir et la nuit.");
	}

}
