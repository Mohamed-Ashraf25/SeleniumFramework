package Taf.E_Commerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Pagebase{

	public Loginpage(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "Email")
	WebElement Email;
	@FindBy (id = "Password")
	WebElement Password;
	
	@FindBy(id = "RememberMe")
	WebElement RememebrBtn;
	
	@FindBy(css ="button.button-1.login-button")
	WebElement loginbtn;
	
	public void loginSuccessfully(String emails,String PAssword) {
		
		SendText(Email,emails);
		SendText(Password, PAssword);
		ClickButton(RememebrBtn);
		ClickButton(loginbtn);
	}
}
