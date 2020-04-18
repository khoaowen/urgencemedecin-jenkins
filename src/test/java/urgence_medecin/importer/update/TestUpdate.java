package urgence_medecin.importer.update;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import urgence_medecin.importer.AppTestSuite;
import urgence_medecin.importer.ExcelReader;
import urgence_medecin.importer.MetaDatasUpdater;

public class TestUpdate {

	private static final String SAMPLE_XLSX_FILE_PATH = "BDD.xlsx";

	public static ExcelReader reader;

	@BeforeClass
	public static void readFile() throws EncryptedDocumentException, InvalidFormatException, IOException {
		reader = new ExcelReader(SAMPLE_XLSX_FILE_PATH);
	}

	@AfterClass
	public static void closeFile() {
		reader.close();
	}

	@Test
	public void testUpdateWithLessVariablesThenPosts() throws URISyntaxException {
		final String variable = "Phrase1";
		final List<Long> postIds = Arrays.asList(42158L, 42150L, 41772L, 40783L, 41393L, 41188L, 42190L, 42296L, 40950L,
				41907L, 41597L, 40892L, 42055L, 42560L, 41771L, 41474L, 42033L, 42459L, 42881L, 41824L, 41230L, 41559L,
				41626L, 43082L, 40709L);
		List<String> valuesOfHeader = reader.getValuesOfHeader("Ville Accroche", variable);
		Assert.assertEquals(23, valuesOfHeader.size());

		Assert.assertEquals(AppTestSuite.readLineByLine("update/updateLessVariablesThanPosts"),
				MetaDatasUpdater.updateStatements(variable.toLowerCase(), postIds, valuesOfHeader));
	}

	@Test
	public void testUpdateWithMuchLessVariablesThenPosts() throws URISyntaxException {
		final String variable = "Phrase3";
		final List<Long> postIds = Arrays.asList(42158L, 42150L, 41772L, 40783L, 41393L, 41188L, 42190L, 42296L, 40950L,
				41907L, 41597L, 40892L, 42055L, 42560L, 41771L, 41474L, 42033L, 42459L, 42881L, 41824L, 41230L, 41559L,
				41626L, 43082L, 40709L);
		List<String> valuesOfHeader = reader.getValuesOfHeader("Ville Accroche", variable);
		Assert.assertEquals(7, valuesOfHeader.size());

		Assert.assertEquals(AppTestSuite.readLineByLine("update/updateMuchLessVariablesThanPosts"),
				MetaDatasUpdater.updateStatements(variable.toLowerCase(), postIds, valuesOfHeader));
	}

	@Test
	public void testUpdateWithMoreVariablesThenPosts() throws URISyntaxException {
		final String variable = "Phrase2";
		final List<Long> postIds = Arrays.asList(42158L, 42150L, 41772L, 40783L, 41393L, 41188L, 42190L, 42296L, 40950L,
				41907L, 41597L, 40892L, 42055L, 42560L, 41771L, 41474L, 42033L, 42459L, 42881L, 41824L, 41230L, 41559L,
				41626L, 43082L, 40709L);
		List<String> valuesOfHeader = reader.getValuesOfHeader("Ville Accroche", variable);
		Assert.assertEquals(64, valuesOfHeader.size());

		Assert.assertEquals(AppTestSuite.readLineByLine("update/updateMoreVariablesThanPosts"),
				MetaDatasUpdater.updateStatements(variable.toLowerCase(), postIds, valuesOfHeader));
	}
}
