package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class DataUtils {

	/**
	 * To read the login test data file
	 * 
	 * @param key provide key to get the value
	 * @return value of the key passed
	 * @throws IOException
	 */
	public static String readLoginTestData(String key) throws IOException {
		FileInputStream f = new FileInputStream(FileConstants.LOGIN_TESTDATA_FILE_PATH);
		Properties p = new Properties();
		p.load(f);
		return p.getProperty(key);
	}

}
