package urgence_medecin.importer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javafx.util.Pair;

public class App {

	private static final String SAMPLE_XLSX_FILE_PATH = "texte_image.xlsx";

	public static void main(String[] args) {

		try (ExcelReader reader = new ExcelReader(SAMPLE_XLSX_FILE_PATH)) {
//			generateInsertStatements(reader);
			generateUpdateStatements(reader);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException | URISyntaxException e) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, e.getMessage());
		}
	}

	private static List<Long> parsePostIds(String fileName) throws IOException, URISyntaxException {
		Path path = new File(App.class.getClassLoader().getResource(fileName).getPath()).toPath();
		List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
		return allLines.stream().map(Long::parseLong).collect(Collectors.toList());
	}

	private static void generateUpdateStatements(ExcelReader reader) throws IOException, URISyntaxException {
		final List<Long> postIds = parsePostIds("list_of_villes_principales_de_departement.txt");
		final List<String> variablesToRead = LongStream.rangeClosed(1, 5).mapToObj(i -> "logo_variable" + i)
				.collect(Collectors.toList());
		StringBuilder bd = new StringBuilder();
		for (String var : variablesToRead) {
			List<String> valuesOfHeader = reader.getValuesOfHeader("ALT VILLLE", var);
			bd.append(MetaDatasUpdater.updateStatements(var, postIds, valuesOfHeader));
		}
		try (BufferedWriter writer = Files.newBufferedWriter(new File("sqlUpdateResult.txt").toPath())) {
			writer.write(bd.toString());
		}

	}

	private static void generateInsertStatements(final ExcelReader reader) throws IOException, URISyntaxException {
//		final List<Long> postIds = LongStream.rangeClosed(6550, 43291).boxed().collect(Collectors.toList());
		final List<Long> postIds = parsePostIds("list_of_villes.txt");
		final long firstMetaId = 2359535;
		List<String> variablesToRead = IntStream.rangeClosed(1, 5).mapToObj(i -> "variable" + i)
				.collect(Collectors.toList());
		Long metaId = firstMetaId;
		StringBuilder bd = new StringBuilder();
		for (String var : variablesToRead) {
			List<String> valuesOfHeader = reader.getValuesOfHeader("ALT VILLLE", var);
			Pair<String, Long> generateStatements = MetaDatasUpdater.insertStatements(metaId, var, postIds,
					valuesOfHeader);
			bd.append(generateStatements.getKey());
			metaId = generateStatements.getValue();
		}
		try (BufferedWriter writer = Files.newBufferedWriter(new File("sqlResult.txt").toPath())) {
			writer.write(bd.toString());
		}
	}
}