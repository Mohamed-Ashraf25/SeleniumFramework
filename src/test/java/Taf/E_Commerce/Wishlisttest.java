package Taf.E_Commerce;

public class Wishlisttest extends TestBase {
	HomePage Home;
	
	public void  OpenWishlistPage() {
		Home=new HomePage(Driver);
		Home.openWishlistlink();
	}

}
