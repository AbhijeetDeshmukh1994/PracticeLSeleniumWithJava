package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LginPage {

	WebDriver driver;
	
	public LginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
    private WebElement txt_username;	
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement txt_password;	
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement btn_login;
	
	
	
	public void setUsername(String user)
	{
		txt_username.sendKeys(user);
	}
	
	public void setPassword(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void click()
	{
		btn_login.click();
	}

	
	
	
}
