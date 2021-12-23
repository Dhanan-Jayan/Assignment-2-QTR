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

public class KudosMandatoryTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	KudosHomeObj kho;
	LoginPageTest lpt;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browserName) {
		launchQTR(browserName);
		log.info("verifyKudosMandatry Started");
	}

	@Test
	public void verifyKudosMandatry() throws Throwable {
		KudosHomeObj kho = new KudosHomeObj();
		LoginPageObj lpo = new LoginPageObj();
		lpo.login(prop.getProperty("username"), prop.getProperty("password"));
		kho.verifySendBtn();
		Action.explicitWait(getDriver(), kho.emailDropdown, 10);
		kho.selectMail();
		kho.typeCitation();
		kho.clickSendButton();
		Thread.sleep(3000);
		String dispMsg = "Please select any image.";
		Assert.assertEquals(kho.displayMessage(), dispMsg);
		log.info("Verify Kudos Mandatry");
	}

	@AfterTest
	public void tearDown() {
		getDriver().quit();
		log.info("verifyKudosMandatry Ended");
	}

}
