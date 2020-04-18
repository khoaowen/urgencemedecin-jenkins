package urgence_medecin.importer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

import org.apache.commons.io.IOUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javafx.util.Pair;

public class App {

	public static void main(String[] args) {
		if (args.length != 1 || (!"DEV".equals(args[0]) && !"PROD".equals(args[0]))) {
			throw new IllegalArgumentException("Need to specify an argument either DEV or PROD");
		}
		String SAMPLE_XLSX_FILE_PATH = args[0] + ".xlsx";
		try (ExcelReader reader = new ExcelReader(SAMPLE_XLSX_FILE_PATH)) {
			if ("DEV".equals(args[0])) {
				generateInsertStatements(reader);
			} else {
				generateUpdateStatements(reader);
			}
		} catch (EncryptedDocumentException | InvalidFormatException | IOException | URISyntaxException e) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, e.getMessage());
		}
	}

	private static List<Long> parsePostIds(String fileName) throws IOException, URISyntaxException {
		File file = File.createTempFile(fileName, "");
		try (OutputStream outputStream = new FileOutputStream(file)) {
			IOUtils.copy(App.class.getClassLoader().getResourceAsStream(fileName), outputStream);
		} catch (FileNotFoundException e) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, e.getMessage());
		} catch (IOException e) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, e.getMessage());
		}
		Path path = file.toPath();
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
		try (BufferedWriter writer = Files.newBufferedWriter(new File("ProdResult.txt").toPath())) {
			writer.write(bd.toString());
		}

	}

	private static void generateInsertStatements(final ExcelReader reader) throws IOException, URISyntaxException {
//		final List<Long> postIds = LongStream.rangeClosed(6550, 43291).boxed().collect(Collectors.toList());
		final List<Long> postIds = parsePostIds("list_of_villes.txt");
		final long firstMetaId = 2359535;
		List<String> variablesToRead = IntStream.rangeClosed(1, 46).mapToObj(i -> "variable" + i)
				.collect(Collectors.toList());
		Long metaId = firstMetaId;
		StringBuilder bd = new StringBuilder();
		for (String var : variablesToRead) {
			List<String> valuesOfHeader = reader.getValuesOfHeader("Ville ALL", var);
			Pair<String, Long> generateStatements = MetaDatasUpdater.insertStatements(metaId, var, postIds,
					valuesOfHeader);
			bd.append(generateStatements.getKey());
			metaId = generateStatements.getValue();
		}
		try (BufferedWriter writer = Files.newBufferedWriter(new File("DevResult.txt").toPath())) {
			writer.write(bd.toString());
		}
	}
}