package qtrecog.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qtrecog.base.Base;
import qtrecog.pageobjects.KudosHomeObj;
import qtrecog.pageobjects.LoginPageObj;

public class KudosHomeTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());

	KudosHomeObj kho;
	LoginPageTest lpt;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browserName) {
		launchQTR(browserName);
		log.info("KudosHomeTest Started");
	}

	@Test(priority = 1)
	public void verifyUser() throws Throwable {
		LoginPageObj lpo = new LoginPageObj();
		lpo.login(prop.getProperty("username"), prop.getProperty("password"));
		KudosHomeObj kho = new KudosHomeObj();
		SoftAssert s = new SoftAssert();
		s.assertEquals(kho.validateUserName(), prop.getProperty("login_username"),"Expected user name is not displayed");
		boolean result = kho.verifyImgDisplay();
		s.assertTrue(result, "User image is not displayed");
		s.assertAll();
		log.info("Verified User Details Display");
	}

	@Test(priority = 0)
	public void verifyTitleHome() throws Throwable {
		LoginPageTest lpt = new LoginPageTest();
		lpt.verifyTitleLogin();
		log.info("Verified Page Title ");

	}

	@AfterTest
	public void tearDown() {
		getDriver().quit();
		log.info("KudosHomeTest Ended");
	}
}
