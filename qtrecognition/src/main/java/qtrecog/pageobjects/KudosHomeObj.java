package qtrecog.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qtrecog.actiondriver.Action;
import qtrecog.base.Base;

public class KudosHomeObj extends Base {

	KudosHomeObj kho;

	@FindBy(xpath = "//a[@Onclick='getRecentKudos()']")
	public WebElement activity;

	@FindBy(xpath = "//a[@Onclick='shoutOutToMe()']")
	public WebElement kudosToMe;

	@FindBy(xpath = "//a[@Onclick='shoutOutFromMe()']")
	public WebElement kudosFromMe;

	@FindBy(id = "search_panel")
	public WebElement kudosSearch;

	@FindBy(xpath = "//a[@Onclick='kudosToMyTeam()']")
	public WebElement kudosToMyTeam;

	@FindBy(xpath = "//button[@Onclick='kudosSearch()']")
	WebElement searchKudosBtn;

	@FindBy(xpath = "//a[@href='#myModal']")
	WebElement sendKudosBtn;

	@FindBy(xpath = "//*[@id='myModal']/div/div/div/button[2]")
	WebElement sendButton;

	@FindBy(xpath = "//*[@id=\"trophy_list\"]/div[1]/div/div")
	WebElement kudosType;

	@FindBy(xpath = "//*[@id=\"ct_1\"]/i")
	WebElement confrmKudosType;

	@FindBy(xpath = "//*[@id=\"ct_2\"]/i")
	WebElement confrmKudosType1;

	@FindBy(xpath = "//*[@id=\"trophy_list\"]/div[2]/div/div")
	WebElement kudosType1;

	@FindBy(xpath = "//img[@alt='Sample Image']")
	WebElement userImg;

	@FindBy(xpath = "//div[@id=\"0\"]/div/h5/b[2]")
	public WebElement searchResultUser;

	@FindBy(xpath = "//*[@id=\"0\"]/div/h5")
	public WebElement recentKudosElement;

	@FindBy(className = "header-font-size")
	public WebElement userName;

	@FindBy(className = "modal-title")
	WebElement confirmPage;

	@FindBy(id = "email_address")
	public WebElement emailDropdown;

	@FindBy(id = "display_message")
	WebElement displayMessage;

	@FindBy(id = "comment")
	WebElement citation;

	@FindBy(id = "contact_list")
	WebElement recentContacts;

	@FindBy(xpath ="//*[@id='s_e_add']")
	public
	WebElement kudosSearchEmail;

	public KudosHomeObj() {
		PageFactory.initElements(getDriver(), this);
	}

	public String validateUserName() throws Throwable {
		KudosHomeObj kho = new KudosHomeObj();
		String userNameHeading = kho.userName.getText();
		return userNameHeading;
	}

	public boolean verifyImgDisplay() throws Throwable {

		boolean ImgStatus = Action.isDisplayed(getDriver(), userImg);

		return ImgStatus;
	}

	public boolean verifySendBtn() throws Throwable {
		boolean sendKudosBtnStatus = Action.click1(sendKudosBtn,"sendKudosBtn");
		return sendKudosBtnStatus;
	}

	public void selectMail() throws Throwable {

		Action.click(getDriver(), emailDropdown);
		Action.type(emailDropdown, prop.getProperty("receivers_username"));
		Thread.sleep(1000);
		getDriver().findElement(By.id("email_address")).sendKeys(Keys.ARROW_DOWN);
		getDriver().findElement(By.id("email_address")).sendKeys(Keys.ENTER);

	}

	public void selectOwnMail() throws Throwable {

		Action.click(getDriver(), emailDropdown);
		Action.type(emailDropdown, prop.getProperty("username"));
		Thread.sleep(1000);
		getDriver().findElement(By.id("email_address")).sendKeys(Keys.ARROW_DOWN);
		getDriver().findElement(By.id("email_address")).sendKeys(Keys.ENTER);

	}

	public void typeCitation() throws Throwable {

		Action.type(citation, prop.getProperty("citation"));

	}

	public void selectKudos() throws Throwable {

		KudosHomeObj kho = new KudosHomeObj();
		kho.kudosType.click();

	}

	public void clickSendButton() throws Throwable {

		KudosHomeObj kho = new KudosHomeObj();
		kho.sendButton.click();

	}

	public String displayMessage() {
		KudosHomeObj kho = new KudosHomeObj();
		String message = kho.displayMessage.getText();
		return message;
	}

	public String citationMessage() {
		KudosHomeObj kho = new KudosHomeObj();
		String citationMessage = kho.citation.getText();
		return citationMessage;
	}

	public void searchMailSelect() throws InterruptedException {
        
		
		kudosSearchEmail.sendKeys(prop.getProperty("search_username")); 
		Thread.sleep(1000);
		getDriver().findElement(By.id("s_e_add")).sendKeys(Keys.ARROW_DOWN);
		getDriver().findElement(By.id("s_e_add")).sendKeys(Keys.ENTER);
		searchKudosBtn.click();

	}

	public boolean verifyRecent() throws Throwable {
		boolean recentsStatus = Action.isDisplayed(getDriver(), recentContacts);
		return recentsStatus;
	}

	public boolean recentActivitiesStatus() {
		boolean recentStatus = Action.isDisplayed(getDriver(), recentKudosElement);

		return recentStatus;
	}

}
