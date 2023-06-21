package Taf.E_Commerce;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Pagebase{

	public HomePage(WebDriver Driver) {
		
		super(Driver);
		JS = (JavascriptExecutor) Driver; 
	//	Actions  action= new Actions(Driver);
	}
	@FindBy(linkText="Register")
	WebElement RegisterLink;

	@FindBy(linkText= "Contact us")
	WebElement Contactuslink;
	
	@FindBy(linkText= "Wishlist")
	WebElement Wishlistlink;
	@FindBy(linkText = "Log in")
	WebElement loginlink;
	
	@FindBy(linkText = "Shopping cart")
	WebElement Shopcartlink;
	
	public void openshopcartlink() {
		ClickButton(Shopcartlink);
		
	}
	public void openloginpage() {
		ClickButton(loginlink);
		
	}
	
	public void openWishlistlink() {

		ClickButton(Wishlistlink);
	}
	public void openRegisterlink() {

		ClickButton(RegisterLink);
	}

	public void openContactuslink() {
		ScrolltoBottom();

		ClickButton(Contactuslink);
	}
}
