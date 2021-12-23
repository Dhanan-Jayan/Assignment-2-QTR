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

public class KudosMandateTest1 extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Parameters("browser")
	@BeforeTest
	public void setup(String browserName) {
		launchQTR(browserName);
		log.info("verifyKudosMandatry Started");
	}

	@Test
	public void verifyCitationMandatory() throws Throwable {
		LoginPageObj lpo = new LoginPageObj();
		lpo.login(prop.getProperty("username"), prop.getProperty("password"));
		KudosHomeObj kho = new KudosHomeObj();
		kho.verifySendBtn();
		Action.explicitWait(getDriver(), kho.emailDropdown, 30);
		kho.selectMail();
		kho.selectKudos();
		kho.clickSendButton();
		Thread.sleep(2000);
		String dispMsg = "Please enter mandatory fields.";
		Assert.assertEquals(kho.displayMessage(), dispMsg);
		log.info("Verify Kudos Mandatry");
	}

	@AfterTest
	public void tearDown() {
		getDriver().quit();
		log.info("verifyCitationMandatory Ended");
	}

}
