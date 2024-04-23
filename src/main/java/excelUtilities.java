import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtilities {

	public static void readExcel() throws InvalidFormatException, IOException {
		String filePath = System.getProperty("user.dir") + "/src/main/resources/Sample Doc.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(new File(filePath));
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow rows;
		for (int rowNo = 0; rowNo <= sheet.getLastRowNum(); rowNo++) {
			rows = sheet.getRow(rowNo);
			for (int col = 0; col < sheet.getRow(rowNo).getLastCellNum(); col++) {
				System.out.print(rows.getCell(col) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		excelUtilities.readExcel();

		String filePath = System.getProperty("user.dir") + "/src/main/resources/Sample Doc1.xlsx";
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook.createSheet("Students");
		XSSFRow row1 = sheet1.createRow(0);
		row1.createCell(0).setCellValue("Visitor");
		
		FileOutputStream fos = new FileOutputStream(filePath); 
		workbook.write(fos);
		fos.close();
	}
}
