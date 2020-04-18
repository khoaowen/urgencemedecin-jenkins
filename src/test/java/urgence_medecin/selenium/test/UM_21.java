package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.Test;

import urgence_medecin.selenium.driver.DriverManager;
import urgence_medecin.selenium.page.CommonPageHelper;

public class UM_21 {

	@Test
	public void test_bloc_appel_existe_pour_ecran_mobile_region() {
		DriverManager.getChromeMobileDriver().get("https://www.urgence-medecin-garde.fr/corse");
		assertThat(CommonPageHelper.getBlocAppelInMobileMode()).isEqualToIgnoringCase("Appelez le 118018");
	}

	@Test
	public void test_bloc_appel_existe_pour_ecran_mobile_departement() {
		DriverManager.getChromeMobileDriver().get("https://www.urgence-medecin-garde.fr/corse/corse-du-sud-2A/");
		assertThat(CommonPageHelper.getBlocAppelInMobileMode()).isEqualToIgnoringCase("Appelez le 118018");
	}

	@Test
	public void test_bloc_appel_existe_pour_ecran_mobile_ville() {
		DriverManager.getChromeMobileDriver()
				.get("https://www.urgence-medecin-garde.fr/corse/corse-du-sud-2A/zonza-20124/");
		assertThat(CommonPageHelper.getBlocAppelInMobileMode()).isEqualToIgnoringCase("Appelez le 118018");
	}

	@AfterClass
	public static void teardown() {
		DriverManager.getChromeMobileDriver().close();

	}

}
