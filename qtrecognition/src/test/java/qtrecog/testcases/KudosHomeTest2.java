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

public class KudosHomeTest2 extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());

	KudosHomeObj kho;
	LoginPageTest lpt;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browserName) {
		launchQTR(browserName);
		log.info("verifySendKudos Started");
	}

	@Test

	public void verifySendKudos() throws Throwable {
		LoginPageObj lpo = new LoginPageObj();
		lpo.login(prop.getProperty("username"), prop.getProperty("password"));
		KudosHomeObj kho = new KudosHomeObj();
		kho.verifySendBtn();
		Action.explicitWait(getDriver(), kho.emailDropdown, 10);
		kho.selectMail();
		kho.selectKudos();
		kho.typeCitation();
		kho.clickSendButton();
		String dispMsg = "Kudos Sent Successfully.";
		Assert.assertEquals(kho.displayMessage(), dispMsg, "Kudos cannot be sent");
		log.info("Verify Send Kudos");

	}

	@AfterTest
	public void tearDown() {
		getDriver().quit();
		log.info("verifySendKudos Ended");
	}

}
