package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static void takeScreenShot(WebDriver driver, String fileName) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir")+"\\screenShot\\" + fileName + ".png");
		FileHandler.copy(src, dest);
	}

	public static String readDataFromExcel(String filePath, String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream myFile = new FileInputStream(filePath);
		String value = WorkbookFactory.create(myFile).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
	public static String readDataFromPropertiesFile(String key) throws IOException {

		FileInputStream myFile = new FileInputStream("C:\\Users\\Serosoft Solutions\\eclipse-workspace\\CoverFoxTest\\FBTest.properties");
		Properties prop = new Properties();
		prop.load(myFile);
		String value = prop.getProperty(key);
		return value;
	}
}
