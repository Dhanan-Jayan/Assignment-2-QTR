package qtrecog.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qtrecog.base.Base;
import qtrecog.pageobjects.KudosHomeObj;
import qtrecog.pageobjects.LoginPageObj;

public class KudosSearchTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());

	KudosHomeObj kho;
	LoginPageTest lpt;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browserName) {
		launchQTR(browserName);
		log.info("KudosSearchTest Started");
	}

	@Test
	public void verifyKudosSearch() throws Throwable {
		LoginPageObj lpo = new LoginPageObj();
		lpo.login(prop.getProperty("username"), prop.getProperty("password"));
		KudosHomeObj kho = new KudosHomeObj();
		Thread.sleep(2000);
		kho.searchMailSelect();
		Thread.sleep(2000);
		String actualUser = kho.searchResultUser.getText();
		Assert.assertEquals(actualUser, prop.getProperty("search_user"));
		log.info("Verify Kudos Search");
	}


	@AfterTest
	public void tearDown() {
		log.info("KudosSearchTest Ended");
		getDriver().quit();
	}

}
