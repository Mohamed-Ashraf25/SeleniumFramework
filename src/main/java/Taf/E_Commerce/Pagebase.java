package Taf.E_Commerce;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Pagebase {
	protected WebDriver Driver;
	public JavascriptExecutor JS;
	public Select select;
	public Actions Action;

	public Pagebase(WebDriver Driver){

		PageFactory.initElements(Driver,this);

	}

	protected static void ClickButton(WebElement Button) {
		Button.click();
	}

	protected static void SendText(WebElement TextElement,String Value) {

		TextElement.sendKeys(Value);
	}
	public void ClearText(WebElement Element) {
		Element.clear();
		
	}
	public void ScrolltoBottom() {

		JS.executeScript("scrollBy(0,2500)");	}
	

}
