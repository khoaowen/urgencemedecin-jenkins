package urgence_medecin.importer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import urgence_medecin.importer.insert.TestInsert;
import urgence_medecin.importer.update.TestUpdate;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TestInsert.class, TestUpdate.class })
public class AppTestSuite {

	public static String readLineByLine(String filePath) throws URISyntaxException {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(
				Paths.get(AppTestSuite.class.getClassLoader().getResource(filePath).toURI()), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}

}
