package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import urgence_medecin.selenium.TestSuiteSelenium;

public class UM_28 {

	@Test
	public void test_supprimer_la_redirection_301() {
		TestSuiteSelenium.getWebDriver().get(
				"https://www.urgence-medecin-garde.fr/get-region/get-departement/get-ville/?regionparam=$1&departementparam=$2&codeparam=$3&villeparam=$4&postalparam=$5");
		assertThat(TestSuiteSelenium.getWebDriver().getCurrentUrl())
				.contains("https://www.urgence-medecin-garde.fr/annuaire");
	}
}
