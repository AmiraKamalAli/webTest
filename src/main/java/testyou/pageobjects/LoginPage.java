/**
 * 
 */
package testyou.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import testyou.actiondriver.Action;
import testyou.base.BaseClass;
import testyou.utility.Log;

public class LoginPage extends BaseClass {

	Action action = new Action();
	@FindBy(id = "ctl00_CPHContainer_txtUserLogin")
	private WebElement userName;

	@FindBy(id = "ctl00_CPHContainer_txtPassword")
	private WebElement password;

	@FindBy(id = "ctl00_CPHContainer_btnLoginn")
	private WebElement signInBtn;

	@FindBy(xpath = "//span[@id='ctl00_CPHContainer_lblOutput']")
	private WebElement error;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void name(String name, String password) {

		action.implicitWait(getDriver(), 5000);
		action.type(userName, name);

	}

	public void password(String name, String pw) {
		// TODO Auto-generated method stub

		action.implicitWait(getDriver(), 5000);
		action.type(password, pw);

	}

	public void submit() {
		// TODO Auto-generated method stub

		action.implicitWait(getDriver(), 5000);
		action.click(getDriver(), signInBtn);

	}

	public void checkValidationError() {

		action.implicitWait(getDriver(), 5000);
		action.isDisplayed(getDriver(), error);
		String errorText = error.getText();
		System.out.println("check validation error" + errorText);
		action.implicitWait(getDriver(), 5000);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(errorText.matches("Userid or Password did Not Match !!"), "passed");
		System.out.println("passed");
		Log.info("Userid or Password did Not Match !!"+ "passed");
		softAssert.assertAll();

	}

	public void close() {
		// TODO Auto-generated method stub
		getDriver().close();
	}
}
