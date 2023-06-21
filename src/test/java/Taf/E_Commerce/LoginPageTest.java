package Taf.E_Commerce;

public class LoginPageTest extends TestBase{
	HomePage Home;
	Loginpage Login;
	public void TestloginPage() {
		
		Home=new HomePage(Driver);
		Login=new Loginpage(Driver);
		Home.openloginpage();
		Login.loginSuccessfully("m.khalil25@gmail.com","17112013");
		
	}
	

}
