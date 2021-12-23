package qtrecog.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qtrecog.actiondriver.Action;
import qtrecog.base.Base;
import qtrecog.pageobjects.KudosHomeObj;
import qtrecog.pageobjects.LoginPageObj;

public class ActivityPanel extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	KudosHomeObj kho;
	LoginPageTest lpt;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browserName) {
		launchQTR(browserName);
		LoginPageObj lpo = new LoginPageObj();
		lpo.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Verify Kudos Sections in Activity Started");
	}

	@Test(priority = 0)
	public void verifyKudosFromMe() throws Throwable {

		KudosHomeObj kho = new KudosHomeObj();
		Action.explicitWait(getDriver(), kho.recentKudosElement, 10);
		kho.kudosFromMe.click();
		boolean result = kho.recentActivitiesStatus();
		Assert.assertTrue(result, "Kudos from me section is not displayed");
		log.info("Verify Kudos Sections in Activity");
		

	}

	@Test(priority = 1)
	public void verifyKudosToMe() throws Throwable {

		KudosHomeObj kho = new KudosHomeObj();
		kho.kudosToMe.click();
		kho.recentActivitiesStatus();
		boolean result = kho.recentActivitiesStatus();
		Assert.assertTrue(result, "Kudos to me section is not displayed");
		log.info("Verify Kudos Sections in Activity");
	}

	@Test(priority = 2)
	public void verifyActivity() throws Throwable {

		KudosHomeObj kho = new KudosHomeObj();
		kho.activity.click();
		Action.explicitWait(getDriver(), kho.recentKudosElement, 10);
		boolean result = kho.recentActivitiesStatus();
		Assert.assertTrue(result, "Activity section is not displayed");
		log.info("Verify Kudos Sections in Activity");
	}

	@AfterTest
	public void tearDown() {
		getDriver().quit();
		log.info("Verify Kudos Sections in Activity Ended");
	}

}