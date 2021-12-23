package qtrecog.testcases;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import qtrecog.base.Base;
import qtrecog.pageobjects.KudosHomeObj;
import qtrecog.pageobjects.LoginPageObj;

public class LoginPageTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());

	LoginPageObj lpo;
	KudosHomeObj kho;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browserName) {
		launchQTR(browserName);
		log.info("LoginPageTest Started");

	}

	@Test(priority = 1)

	public void verifyTitleLogin() throws Throwable {

		LoginPageObj lpo = new LoginPageObj();
		String actualTitle = lpo.getCurrTitle();
		String explTitle = "QTRecognition";
		Assert.assertEquals(actualTitle, explTitle);
		log.info("Verified Title of the Page");

	}

	@Test(priority = 2)
	public void verifyElementColours() {

		LoginPageObj lpo = new LoginPageObj();
		SoftAssert a = new SoftAssert();

		String expectedSigninColour = "#2a2559";
		String signinColour = lpo.signinButton.getCssValue("background-color");
		String actualSigninColour = Color.fromString(signinColour).asHex();
		a.assertEquals(actualSigninColour, expectedSigninColour);
		log.info("Verified Colour #2a2559 of the Page");

		String expectedHeaderColour = "#fecc160";
		String headerColour = lpo.header.getCssValue("background-color");
		String actualHeaderColour = Color.fromString(headerColour).asHex();
		a.assertEquals(actualHeaderColour, expectedHeaderColour);
		log.info("Verified Colour #fecc160 of the Page");

		String expectedUserNameColour = "#939598";
		String userNameColour = lpo.userName.getCssValue("background-color");
		String actualUserNameColour = Color.fromString(userNameColour).asHex();
		a.assertEquals(actualUserNameColour, expectedUserNameColour);

		String expectedPasswordColour = "#939598";
		String passwordColour = lpo.password.getCssValue("background-color");
		String actualPasswordColour = Color.fromString(passwordColour).asHex();
		a.assertEquals(actualPasswordColour, expectedPasswordColour);
		log.info("Verified Colour #939598 of the Page");

		a.assertAll();
	}
	@Test(priority = 10)

	public void verifyLogin() throws Throwable {

		LoginPageObj lpo = new LoginPageObj();
		kho = lpo.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Enter UserName and Password");
		String actualURL = lpo.getCurrURL();
		String expectedURL = "https://qtrecognition.testqtwiz.com/Activity.php";
		Assert.assertEquals(actualURL, expectedURL);
		log.info("Login is Successful");

	}

	@AfterTest
	public void tearDown() {
		log.info("LoginPageTest Ended");
		getDriver().quit();
	}

}
