package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.Departement;

public class UM_2 {

	@Test
	public void test_ville_arrondissement_sans_tirets_pour_villes_principales() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/ile-de-france/paris-75");
		Departement departement = Departement.getPage();
		assertThat(departement.getVillesPrincipalesATelephoner()).anyMatch(e -> e.contains("PARIS 15E ARRONDISSEMENT"));
	}

	@Test
	public void test_ville_arrondissement_sans_tirets_pour_medecin_par_villes() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/ile-de-france/paris-75");
		Departement departement = Departement.getPage();
		assertThat(departement.getMedecinParVillesHyperLink("innerText"))
				.anyMatch(e -> e.contains("PARIS 15E ARRONDISSEMENT"));
	}

	@Test
	public void test_ville_arrondissement_sans_tirets_pour_hyperlink_description() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/ile-de-france/paris-75");
		Departement departement = Departement.getPage();
		assertThat(departement.getAllMedecinHyperLinkInDescription("innerText"))
				.anyMatch(e -> e.contains("PARIS 15E ARRONDISSEMENT"));
	}

	@Test
	public void test_ville_arrondissement_sans_tirets_pour_villes_principales_mobile() {
		TestSuiteSelenium.getWebMobileDriver().get("https://www.urgence-medecin-garde.fr/ile-de-france/paris-75");
		Departement departement = Departement.getPage();
		assertThat(departement.getVillesPrincipalesATelephoner()).anyMatch(e -> e.contains("PARIS 15E ARRONDISSEMENT"));
	}

	@Test
	public void test_ville_arrondissement_sans_tirets_pour_medecin_par_villes_mobile() {
		TestSuiteSelenium.getWebMobileDriver().get("https://www.urgence-medecin-garde.fr/ile-de-france/paris-75");
		Departement departement = Departement.getPage();
		assertThat(departement.getMedecinParVillesHyperLink("innerText"))
				.anyMatch(e -> e.contains("PARIS 15E ARRONDISSEMENT"));
	}

	@Test
	public void test_ville_arrondissement_sans_tirets_pour_hyperlink_description_mobile() {
		TestSuiteSelenium.getWebMobileDriver().get("https://www.urgence-medecin-garde.fr/ile-de-france/paris-75");
		Departement departement = Departement.getPage();
		assertThat(departement.getAllMedecinHyperLinkInDescription("innerText"))
				.anyMatch(e -> e.contains("PARIS 15E ARRONDISSEMENT"));
	}

}
