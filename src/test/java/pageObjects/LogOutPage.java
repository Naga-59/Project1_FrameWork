package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LogOutPage extends ConstructorPage {


	public LogOutPage (WebDriver driver){
		super(driver);
	}
	
	//logout option
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement option;
	
	//logout button
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement button;
	
	public void logoutOption() {
		option.click();
	}
	
	//button
	public void logOutButton() {
		button.click();
	}
}
