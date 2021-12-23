package qtrecog.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qtrecog.actiondriver.Action;
import qtrecog.base.*;

public class LoginPageObj extends Base {

	@FindBy(css = "input[name='username']")
	public WebElement userName;

	@FindBy(css = "input[name='pass']")
	public WebElement password;

	@FindBy(css = "button[type='submit']")
	public WebElement signinButton;

	@FindBy(className = "myHeading")
	public WebElement header;

	public LoginPageObj() {
		PageFactory.initElements(getDriver(), this);
	}

	public KudosHomeObj login(String uname, String pswd) {
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(getDriver(), signinButton);
		return new KudosHomeObj();

	}

	public String getCurrURL() throws Throwable {
		String homePageURL = Action.getCurrentURL(getDriver());
		return homePageURL;
	}

	public String getCurrTitle() throws Throwable {
		String homePageTitle = Action.getTitle(getDriver());
		return homePageTitle;
	}

}
