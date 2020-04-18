package urgence_medecin.importer;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Helper class to read an excel file
 * 
 * @author khoa
 *
 */
public class ExcelReader implements Closeable {

	private final String filePath;
	private final Workbook workbook;

	public ExcelReader(String filePath) throws EncryptedDocumentException, InvalidFormatException, IOException {
		this.filePath = filePath;
		workbook = WorkbookFactory.create(new File(getClass().getClassLoader().getResource(filePath).getFile()));
	}

	/**
	 * Get all values for the {@code headerName} of the sheet {@code sheetName}
	 * 
	 * @param sheetName
	 * @param headerName
	 * @return
	 */
	public List<String> getValuesOfHeader(String sheetName, String headerName) {
		List<String> result = new ArrayList<>();
		if (workbook == null) {
			throw new IllegalStateException("The workbook must be initialized first");
		}
		Sheet sheet = workbook.getSheet(sheetName);
		DataFormatter dataFormatter = new DataFormatter();
		int columnIndex = 0;
		for (Cell c : sheet.getRow(0)) {
			if (dataFormatter.formatCellValue(c).equals(headerName)) {
				break;
			}
			columnIndex++;
		}
		int rowIndex = 1;
		Cell cellValue;
		while ((cellValue = sheet.getRow(rowIndex) == null ? null
				: sheet.getRow(rowIndex).getCell(columnIndex)) != null) {
			String formatCellValue = dataFormatter.formatCellValue(cellValue).trim();
			if (formatCellValue.isEmpty()) {
				break;
			}
			result.add(formatCellValue);
			rowIndex++;
		}
		return result;
	}

	@Override
	public void close() {
		try {
			workbook.close();
		} catch (IOException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can not close workbook: " + filePath);
		}
	}

}
