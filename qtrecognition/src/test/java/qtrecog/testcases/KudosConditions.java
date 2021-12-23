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

public class KudosConditions extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	KudosHomeObj kho;
	LoginPageTest lpt;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browserName) {
		launchQTR(browserName);
		log.info("verifyKudosToOwn Started");
	}

	@Test
	public void verifyKudosToOwn() throws Throwable {
		LoginPageObj lpo = new LoginPageObj();
		lpo.login(prop.getProperty("username"), prop.getProperty("password"));
		KudosHomeObj kho = new KudosHomeObj();
		kho.verifySendBtn();
		Action.explicitWait(getDriver(), kho.emailDropdown, 10);
		kho.selectOwnMail();
		kho.selectKudos();
		kho.typeCitation();
		kho.clickSendButton();
		Thread.sleep(2000);
		String dispMsg = "Please enter mandatory fields.";
		Assert.assertEquals(kho.displayMessage(), dispMsg,"User is able to send kudos to his own mail which is a bug.");
		log.info("Verify Kudos To Own Mail");
	}

	@AfterTest
	public void tearDown() {
		getDriver().quit();
		log.info("verifyKudosToOwn Ended");
	}

}
