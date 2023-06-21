package Taf.E_Commerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Pagebase{
	
	public RegisterPage(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "gender-male")
	WebElement Gender;
	@FindBy(id="FirstName")
	WebElement Firstname;
	@FindBy(id = "LastName")
	WebElement Lastname;
	@FindBy(id="Email")
	WebElement Emails;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]")
	WebElement Day;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]")
	WebElement Month;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]")
	WebElement Year;
	@FindBy(id="Company")
	WebElement CompanyName;
	@FindBy(id = "Password")
	WebElement Password;
	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmedPassword;
	@FindBy(id = "register-button")
	WebElement RegisterBtn;
	
	public void UserRegisteration(String fname,String lname,String email,String day,String month,String year ,String companyname ,String password,String Confirmedpasswword) {

		ClickButton(Gender);
		SendText(Firstname,fname);
		SendText(Lastname,lname);
		SendText(Emails,email);
		SendText(Day,day);
		SendText(Month,month);
		SendText(Year,year);
		SendText(CompanyName,companyname);
		SendText(Password,password);
		SendText(ConfirmedPassword,Confirmedpasswword);
		ClickButton(RegisterBtn);
	}
	
	
	
	
}
