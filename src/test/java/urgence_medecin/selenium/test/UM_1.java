package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.CommonPageHelper;

public class UM_1 {

	@Test
	public void test_departement_code_fin_du_titre_et_canonical() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/hauts-de-france/pas-de-calais-62/");
		assertThat(CommonPageHelper.getHeaderTitle()).contains("(62)");
		assertThat(CommonPageHelper.getHeaderCanonical()).contains("62");
	}

	@Test
	public void test_ville_code_fin_du_titre_et_canonical() {
		TestSuiteSelenium.getWebDriver()
				.get("https://www.urgence-medecin-garde.fr/provence-alpes-cote-dazur/alpes-maritimes-06/grasse-06130/");
		assertThat(CommonPageHelper.getHeaderTitle()).contains("(06130)");
		assertThat(CommonPageHelper.getHeaderCanonical()).contains("06130");
	}

}
