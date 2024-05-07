package constants;

import utils.CommonUtils;

public class FileConstants {
	
	public static final String LOGIN_TESTDATA_FILE_PATH = 
			System.getProperty("user.dir")+"/src/main/java/testdata/loginTestData.properties";
	public static final String SCREENSHOTS_FOLDER_PATH = 
			System.getProperty("user.dir")+"/src/main/java/reports/"+CommonUtils.getTimeStamp()+".PNG";
	public static final String FILE_PATH = 
			System.getProperty("user.dir")+"/src/main/resources/SampleDoc.xlsx";
	public static final String IMAGE_PATH = 
			System.getProperty("user.dir")+"/src/main/java/reports/20240507213610.PNG";
	public static final String REPORT_PATH = 
			System.getProperty("user.dir")+"/src/main/java/reports/"+CommonUtils.getTimeStamp()+".html";
}
