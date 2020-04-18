package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.CommonPageHelper;

public class UM_27 {

	@Test
	public void test_canonical_genere_en_minuscule() {
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/bretagne/");
		String title = CommonPageHelper.getHeaderCanonical();
		assertThat(title).isEqualTo("https://www.urgence-medecin-garde.fr/bretagne/");
		assertThat(title).isNotEqualTo("https://www.urgence-medecin-garde.fr/Bretagne/");
	}

}
