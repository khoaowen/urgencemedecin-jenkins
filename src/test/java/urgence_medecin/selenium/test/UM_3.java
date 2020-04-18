package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.Departement;
import urgence_medecin.selenium.page.Ville;

public class UM_3 {

	@Test
	public void test_departement_code_sous_parentheses() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/grand-est/meuse-55/");
		Departement departement = Departement.getPage();
		assertThat(departement.getMedecinDeGardeDepartementTitle()).contains("(55)");
		assertThat(departement.getMedecinParVillesHyperLink("innerText"))
				.allSatisfy(e -> assertThat(e).contains("(").contains(")"));
	}

	@Test
	public void test_ville_code_fin_du_titre_et_canonical() {
		TestSuiteSelenium.getWebDriver()
				.get("https://www.urgence-medecin-garde.fr/grand-est/meuse-55/thierville-sur-meuse-55840/");
		Ville ville = Ville.getPage();
		assertThat(ville.getDescriptionElement()).contains("(55840)");
	}

}
