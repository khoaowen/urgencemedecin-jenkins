package urgence_medecin.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.map.HashedMap;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import com.google.common.base.Functions;

import urgence_medecin.selenium.TestSuiteSelenium;
import urgence_medecin.selenium.page.Annuaire;
import urgence_medecin.selenium.page.Departement;
import urgence_medecin.selenium.page.Region;
import urgence_medecin.selenium.page.Ville;

public class UM_26 {

	// @formatter:off
	private final List<String> phrase1Variables = Arrays.asList(
			"Vous vous trouvez sur la page de notre annuaire",
			"Bienvenu sur la page de l'annuaire",
			"Vous êtes bien sur l'annuaire",
			"L'accès à l'annuaire de cette page web",
			"L'annuaire de cette page vous donne accès à",
			"Bonjour, nous sommes ravis de vous accueillir sur l'annuaire",
			"Vous êtes bien sur notre annuaire",
			"Bienvenu sur l'annuaire",
			"Bienvenu sur notre page annuaire",
			"Bienvenu sur la page de notre annuaire",
			"Bienvenu sur notre annuaire",
			"Bienvenu sur votre annuaire",
			"Vous êtes bien arrivés sur l'annuaire",
			"Vous êtes bien sur la page annuaire",
			"Vous êtes bien sur la page de l'annuaire",
			"Bonjour, vous voila bien sur l'annuaire",
			"Bonjour, notre annuaire est ravi de vous proposer",
			"Bonjour, vous êtes arrivés sur l'annuaire",
			"Bonjour et bienvenu sur notre annuaire",
			"Bonjour, vous êtes bien sur l'annuaire",
			"Vous êtes à présent sur la page de notre annuaire"
			);
	private final List<String> phrase2Variables = Arrays.asList(
			"Cette page vous permet de trouver",
			"Ce site internet et nos consultants vous aideront à trouver",
			"La page de cet annuaire vous permettra de chercher",
			"Ce service vous permet d'avoir une visibilité sur une liste et de trouver",
			"Ce site vous permet de récupérer et trouver simplement",
			"Notre site vous donne la possiblité de trouver en quelques clics",
			"Ce site internet vous aidera à chercher dans les plus brefs délais",
			"Ce site web vous donnera la possibilité de chercher rapidement",
			"Cette page web vous donnera l'opportunité de trouver",
			"Ce site internet vous donnera un choix afin récupérer",
			"Cette page vous offre un accès complet pour trouver rapidement",
			"Nous vous donnons la possibilité de trouver",
			"Nous vous offrons le choix de récupérer facilement",
			"Nous vous accompagnons afin de trouver dans les plus brefs délais",
			"Nous sommes à vos cotés afin de chercher et trouver",
			"Nous vous accompagnons dans la recherche afin de trouver",
			"Notre service vous aidera à trouver le téléphone et",
			"Notre service téléphonique vous accompagne afin de trouver",
			"Nos équipes vous aideront à trouver et chercher",
			"Nos équipes spécialisées vous accompagnent afin de trouver",
			"Nos équipes vous donne la possibilité de trouver",
			"Nos équipes vous aident à chercher et trouver",
			"Nos équipes vous aideront à trouver et récupérer",
			"Nos équipes spécialisées vous accompagnent afin de récupérer",
			"Nos équipes vous donnent la possibilité de récupérer",
			"Nos équipes vous aident à chercher et récupérer",
			"Nos services web vous assistent pour trouver",
			"Nos services vous assistent afin de récupérer et trouver",
			"Cela vous offre la possibilité de trouver",
			"Cela vous offre la possibilité de récupérer",
			"Cela vous permet d'avoir et de trouver",
			"Cela vous permet de trouver",
			"Cela vous permet de chercher",
			"Cela vous offre un accès complet afin de trouver",
			"Cela vous permet d'avoir un accès complet afin de récupérer",
			"Cela vous donne un accès complet afin de chercher",
			"Cela vous donne un accès complet afin d'avoir",
			"Cette page web vous permet d'avoir",
			"Cette page internet vous permet de récupérer",
			"Cette page vous permet de chercher",
			"Cette page internet vous permet de trouver",
			"Notre service vous offre la possibilité de trouver",
			"Notre service internet vous offre la possibilité de récupérer",
			"Notre service vous offre la possibilité de chercher",
			"Notre service d'assistance vous donne l'opportunité de trouver",
			"Notre service de garde vous offre l'opportunité de récupérer",
			"Notre service vous offre l'opportunité de chercher",
			"Nos équipes vous soumettent une liste afin de trouver",
			"Nos conseillers vous accompagnent afin que puissiez trouver",
			"Nos conseillers vous accompagnent afin de récupérer",
			"Nos conseillers vous accompagnent pour chercher",
			"Nous vous accompagnons pour récupérer",
			"Notre accompagnement vous permettra de trouver",
			"Notre site internet vous donne la possibilité de récupérer",
			"Cette page web vous donne une liste afin de trouver",
			"Nos services sont là pour vous assister afin de trouver",
			"Nos services sont là pour vous assister pour chercher",
			"Nos consultants vous accompagnent dans les démarches afin de trouver",
			"Nos consultants accompagnent vos demandes pour récupérer",
			"Nos consultants spécialisés dans la recherche vous aideront à trouver",
			"Nos consultants spécialisés vous aideront à récupérer et trouver",
			"Découvrez comment trouver facilement",
			"Découvrez comment récupérer très facilement"
			);
	
	private final List<String> variable46 = Arrays.asList(
			"qui vous mettront en relation",
			"qui feront tout pour vous mettre en relation",
			"qui feront tout leur possible afin de vous mettre en relation",
			"qui feront le nécéssaire pour vous mettre en relation",
			"qui feront le maximum afin de vous mettre rapidement en relation",
			"qui activeront leur réseau afin de vous mettre rapidement en contact",
			"qui vous mettront en contact",
			"qui feront tout pour vous mettre en contact",
			"qui feront vraiment tout leur possible afin de vous mettre en contact",
			"qui feront le nécéssaire pour vous mettre en contact",
			"qui feront le maximum afin de vous mettre contact en relation",
			"qui activeront leur réseau afin de vous mettre en quelques minutes en relation"
			);
			
	// @formatter:on

	private static Map<String, List<String>> allVillesPrincipalesDescriptionCache = new HashedMap<>();

	private List<String> getAllVillesPrincipalesDescription(String departementUrl) {
		if (allVillesPrincipalesDescriptionCache.containsKey(departementUrl)) {
			return allVillesPrincipalesDescriptionCache.get(departementUrl);
		}
		TestSuiteSelenium.getWebDriver().get(departementUrl);
		final Departement departement = Departement.getPage();
		List<String> villeDescriptions = new ArrayList<>();

		for (String villeLink : departement.getMedecinParVillesHyperLink("href")) {
			// go to each ville and collect its description
			// need to be in departement page to get the correct link
			TestSuiteSelenium.getWebDriver().get(villeLink);
			final Ville ville = Ville.getPage();
			villeDescriptions.add(ville.getAllDescriptionTextsInPage());
		}
		allVillesPrincipalesDescriptionCache.put(departementUrl, villeDescriptions);
		return villeDescriptions;
	}

	private List<Integer> getCounterOfEachVariable(String departementUrl, List<String> variableList) {

		List<String> allVillesPrincipalesDescription = getAllVillesPrincipalesDescription(departementUrl);
		Map<String, Integer> variableCounter = variableList.stream()
				.collect(Collectors.toMap(Functions.identity(), (e) -> 0));

		for (String desc : allVillesPrincipalesDescription) {
			for (String variable : variableList) {
				if (desc.contains(variable)) {
					variableCounter.computeIfPresent(variable, (k, v) -> v + 1);
				}
			}
		}
		return new ArrayList<>(variableCounter.values());
	}

	@Test
	public void test_villes_principales_phrases_variables_doivent_etre_differentes_pour_tous_departements() {
		Annuaire annuaire = Annuaire.getPage();
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/annuaire/");
		List<String> regions = annuaire.getRegionsHref();
		Region region = Region.getPage();
		SoftAssertions softly = new SoftAssertions();
		for (String r : regions) {
			TestSuiteSelenium.getWebDriver().get(r);
			List<String> departements = region.getDepartementsHref();
			for (String dep : departements) {
				List<Integer> counter = getCounterOfEachVariable(dep, phrase1Variables);
				softly.assertThat(counter).as("Phrase1 pour " + dep)
						.allSatisfy(value -> assertThat(value).isLessThan(5));
				counter = getCounterOfEachVariable(dep, phrase2Variables);
				softly.assertThat(counter).as("Phrase2 pour " + dep)
						.allSatisfy(value -> assertThat(value).isLessThan(4));
				counter = getCounterOfEachVariable(dep, variable46);
				softly.assertThat(counter).as("Variable46 pour " + dep)
						.allSatisfy(value -> assertThat(value).isLessThan(5));
			}
		}
		softly.assertAll();
	}
}
