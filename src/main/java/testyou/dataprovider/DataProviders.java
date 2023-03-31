/**
 * 
 */
package testyou.dataprovider;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import testyou.utility.ExcelUtility;
/**
 * @author Amira
 *
 */
public class DataProviders {

//Class --> AddToCartPageTest, EndToEndTest,  Test Case--> addToCartTest, endToEndTest	
	@DataProvider(name = "webloginUsers")
	public Object[][] getdataweb() throws IOException {

		List<Map<String, String>> testDataInMap = ExcelUtility.getMapTestDataInMap();

		Object[][] data = new Object[1][2];

		String Name = testDataInMap.get(0).get("name");

		String password = testDataInMap.get(0).get("password");

		data[0][0] = Name;
		data[0][1] = password;
		return data;

	}

}
