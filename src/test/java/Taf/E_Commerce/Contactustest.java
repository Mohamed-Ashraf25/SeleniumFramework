package Taf.E_Commerce;

public class Contactustest extends TestBase {
	HomePage Home;
	ContactusPage Contact;
	
	public void TestContactus() {
		Home=new HomePage(Driver);
		Contact=new ContactusPage(Driver);
		Home.openContactuslink();
		Contact.ContactusAccess("Mohamed Ashraf Khalil","M.Khalil2599@gmail.com","I want a Call For An Enquiry");
		
		
	}
	

}
