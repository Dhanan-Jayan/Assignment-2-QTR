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

public class KudosRecentsTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	KudosHomeObj kho;
	LoginPageTest lpt;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browserName) {
		launchQTR(browserName);
		log.info("verifyRecentContacts Started");
	}

	@Test
	public void verifyRecentContacts() throws Throwable {
		LoginPageObj lpo = new LoginPageObj();
		lpo.login(prop.getProperty("username"), prop.getProperty("password"));
		KudosHomeObj kho = new KudosHomeObj();
		boolean result = kho.verifyRecent();
		Assert.assertTrue(result, "Recent Kudos Contact is not displayed");
		log.info("verify RecentContacts");

	}

	@AfterTest
	public void tearDown() {
		getDriver().quit();
		log.info("verifyRecentContacts Ended");
	}

}