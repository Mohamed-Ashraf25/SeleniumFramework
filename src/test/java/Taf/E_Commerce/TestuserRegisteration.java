package Taf.E_Commerce;

import org.testng.annotations.Test;

public class TestuserRegisteration extends TestBase{
	HomePage Home;
	RegisterPage Registerobject;
	@Test
	public void RegisterSuccessfuly()
	{
		Home=new HomePage(Driver);
		Registerobject=new RegisterPage(Driver);
	     //Faker fakerdata=new Faker();
	     //String Emailss=fakerdata.internet().emailAddress();
		Home.openRegisterlink();
		Registerobject.UserRegisteration("Mohamed","Ashraf","m.khalil@gmail.coms","21","8","1995","TelecomEgypt","17112013","17112013");





	}
}
