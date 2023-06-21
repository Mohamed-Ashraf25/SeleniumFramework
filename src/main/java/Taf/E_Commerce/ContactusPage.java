package Taf.E_Commerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactusPage extends Pagebase{

	public ContactusPage(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id = "FullName")
	WebElement FullName;
	@FindBy(id = "Email")
	WebElement Email;
	@FindBy(id = "Enquiry")
	WebElement Enquiry;
	@FindBy(css="button.button-1.contact-us-button")
	WebElement Submits;

	public void ContactusAccess(String Fname,String Emailss,String Enquirys) {
		SendText(FullName, Fname);
		SendText(Email, Emailss);
		SendText(Enquiry, Enquirys);
		ClickButton(Submits);
	}
}
