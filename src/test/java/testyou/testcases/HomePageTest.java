package testyou.testcases;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import testyou.dataprovider.DataProviders;
import testyou.base.BaseClass;
import testyou.pageobjects.LoginPage;
import testyou.utility.Log;

/**
 *
 */
public class HomePageTest extends BaseClass {

	// @Parameters("browser")
	@Test(priority = 1)
	public void setup() {
		Log.info("launch chrome browser");
		String browser = "chrome";
		launchApp(browser);

	}

	@Test(priority = 2, dataProvider = "webloginUsers", dataProviderClass = DataProviders.class)
	public void addusername(String username,String password) {
		LoginPage Lin = new LoginPage();
		Lin.name(username,password);

	}

	@Test(priority = 3, dataProvider = "webloginUsers", dataProviderClass = DataProviders.class)
	public void addpassword(String username,String password){
		LoginPage Lin = new LoginPage();
		Lin.password(username,password);
	}

	@Test(priority = 4)
	public void submit() {
		LoginPage Lin = new LoginPage();
		Lin.submit();
	}
	
	@Test(priority = 5)
	public void checkvalidationError() {
		LoginPage Lin = new LoginPage();
		Lin.checkValidationError();
	}
//	@Test(priority = 6)
//	public void close() {
//		LoginPage Lin = new LoginPage();
//		Lin.close();
//	}
}
