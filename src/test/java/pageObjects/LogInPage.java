package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends ConstructorPage{

	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	//username
	@FindBy(xpath="//input[@id='user-name']")
	WebElement user;
	
	//password
	@FindBy(xpath="//input[@id='password']")
	WebElement pass;
	
	//submit button
	@FindBy(xpath="//input[@id='login-button']")
	WebElement button;
	
	//Login_log
	@FindBy(xpath="//div[@class='login_logo']")
	WebElement logo;
	
	//home_logo
	@FindBy(xpath="//div[@class='app_logo']")
	WebElement home_logo;
	//title
	@FindBy(xpath="//title[contains(text(),'Swag Labs')]")
	WebElement title;
	
	//Actions
	
	public void username(String ur) {
		user.sendKeys(ur);
	}
	
	public void password(String pas) {
		pass.sendKeys(pas);
	}
	
	public void submitButton() {
		button.click();
	}
	
	public boolean logos() {
		boolean logo_result=logo.isDisplayed();
		return logo_result;
	}
	
	public String text_title() {
		String text=title.getText();
		return text;
	}
	
	public boolean home_logos() {
		boolean logo_home=home_logo.isDisplayed();
		return logo_home;
	}
	
	public boolean logInLog() {
		boolean l_logo=logo.isDisplayed();
		return l_logo;
	}
}
