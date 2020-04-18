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

public class UM_33 {

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
			"Bonjour, vous voilà bien sur l'annuaire",
			"Bonjour, vous êtes arrivés sur l'annuaire",
			"Bonjour et bienvenu sur notre annuaire",
			"Bonjour, vous êtes bien sur l'annuaire",
			"Vous êtes à présent sur la page de notre annuaire"
			);
	private final List<String> phrase3Variables = Arrays.asList(
			"dès que vous en ressentez la nécessité",
			"dès que le besoin se fait ressentir",
			"à tout moment de la journée",
			"lorsque vous avez besoin d'une consultation",
			"si vous avez un besoin médical en dehors des horaires habituels",
			"dès que le besoin demande un conseil médical",
			"dès que vous ressentez l'envie de parler à un spécialiste",
			"dés que le moment vous parait opportun",
			"lorsque vous pensez avoir besoin d'un conseil médical",
			"si vous pensez que c'est le moment d'avoir un conseil d'un spécialiste",
			"dès qu'un besoin urgent se fait ressentir",
			"dès lors que le besoin d'un conseil médical se fait ressentir",
			"dès que vous en éprouvez le besoin",
			"qui pourra répondre à vos demandes médicales",
			"qui pourra vous aider dans vos demandes médicales",
			"qui pourra vous rassurer sur vos problèmes d'ordre médicaux",
			"qui pourra vous rassurer sur vos symptômes",
			"qui pourra analyser vos symptômes",
			"qui vous aidera afin d'analyser vos symptômes",
			"à tout moment de la semaine",
			"qui sera à même de répondre à toutes vos questions",
			"qui sera capable de répondre à vos questions et analyser vos symptômes",
			"qui sera dans la capacité de vous aider et répondre à vos questions médicales",
			"qui vous répondra sur les questions et symptômes que vous ressentez",
			"qui écoutera les symptômes que vous ressentez",
			"qui pourra vous donner des élements de réponses sur vos symptômes",
			"qui vous dira ce qu'il faut faire selon votre situation médicale",
			"qui vous écoutera afin de trouver une solution à vos problèmes",
			"qui donnera des élements de réponses à vos questions",
			"qui sera à l'écoute de vos demandes afin de trouver une solution"
			);
	private final List<String> variables2= Arrays.asList(
			"Par cet annuaire, ou en nous contactant au 118018, vous trouverez les informations utiles à votre besoin de",
			"En nous contactant sur notre numéro le 118018, vous pourrez récupérer les informations pour votre besoin de",
			"En passant par notre service 118018, nous vous donnons la possiblilité de trouver les informations de",
			"Lorsque vous passez par notre annuaire, en appelant le 118018, nos conseillers vous donneront les informations utiles si vous cherchez à joindre un",
			"Si vous passez par notre équipe de conseillers au 118018, nos consultants vous accompagnent afin de trouver et récupérer les informations de",
			"En utilisant notre service de mise en relation médicale au 118018, vous aurez les renseignements nécessaires pour trouver un",
			"Le meilleur moyen est d'appeler le 118018, nos équipes vous accompagnent afin de récupérer et trouver les renseignements de",
			"Il y a différentes solutions, en nous appelant sur notre numéro de téléphone, 118018, vous aurez l'occasion de récupérer toutes les informations afin de répondre à votre besoin de",
			"Une manière simple et efficace est de nous contacter au 118018, nos téléconseillers vous donneront les éléments pour que vous puissiez trouver rapidement",
			"Une solution rapide et simple est de nous appeler au 118018, nos équipes vous donne les solutions afin de récupérer facilement le numéro d'un",
			"Une réponse infaillible, c'est de nous joindre au 118018, vous pourrez facilement chercher et trouver un",
			"La clé pour trouver rapidement est de nous contacter via notre numéro de téléphone le 118018, nos consultants vous accompagnent et trouvent un",
			"La solution la plus simple est de nous appeler sur notre ligne le 118018, notre personnel vous trouvera une réponse adaptée afin de trouver un",
			"Lorsque vous utilisez notre service le 118018, notre personnel cherche dans notre base de donnée, afin de vous proposer et trouver un"
			);
	
	// @formatter:on

	private static Map<String, List<String>> allDepartementsOfRegionDescriptionCache = new HashedMap<>();

	private List<String> getAllDepartementsDescription(String regionUrl) {
		if (allDepartementsOfRegionDescriptionCache.containsKey(regionUrl)) {
			return allDepartementsOfRegionDescriptionCache.get(regionUrl);
		}
		TestSuiteSelenium.getWebDriver().get(regionUrl);
		final Region region = Region.getPage();
		List<String> departementDescriptions = new ArrayList<>();

		for (String departementLink : region.getMedecinParDepartementsHyperLink("href")) {
			// go to each ville and collect its description
			// need to be in departement page to get the correct link
			TestSuiteSelenium.getWebDriver().get(departementLink);
			final Departement departement = Departement.getPage();
			departementDescriptions.add(departement.getAllDescriptionTextsInPage());
		}
		allDepartementsOfRegionDescriptionCache.put(regionUrl, departementDescriptions);
		return departementDescriptions;
	}

	private List<Integer> getCounterOfEachVariable(String regionUrl, List<String> variableList) {

		List<String> allDepartementsPrincipalesDescription = getAllDepartementsDescription(regionUrl);
		Map<String, Integer> variableCounter = variableList.stream()
				.collect(Collectors.toMap(Functions.identity(), (e) -> 0));

		for (String desc : allDepartementsPrincipalesDescription) {
			for (String variable : variableList) {
				if (desc.contains(variable)) {
					variableCounter.computeIfPresent(variable, (k, v) -> v + 1);
				}
			}
		}
		return new ArrayList<>(variableCounter.values());
	}

	@Test
	public void test_departements_de_region_phrases_variables_doivent_etre_differentes_pour_tous() {
		Annuaire annuaire = Annuaire.getPage();
		TestSuiteSelenium.getWebDriver().get("https://www.urgence-medecin-garde.fr/annuaire/");
		List<String> regions = annuaire.getRegionsHref();
		SoftAssertions softly = new SoftAssertions();
		for (String r : regions) {
			List<Integer> counter = getCounterOfEachVariable(r, phrase1Variables);
			softly.assertThat(counter).as("Phrase1 pour " + r).allSatisfy(value -> assertThat(value).isLessThan(2));
			counter = getCounterOfEachVariable(r, phrase3Variables);
			softly.assertThat(counter).as("Phrase3 pour " + r).allSatisfy(value -> assertThat(value).isLessThan(2));
			counter = getCounterOfEachVariable(r, variables2);
			softly.assertThat(counter).as("Variable2 pour " + r).allSatisfy(value -> assertThat(value).isLessThan(5));
		}
		softly.assertAll();
	}
}
