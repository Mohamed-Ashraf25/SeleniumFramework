import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Configuration {
    WebDriver Driver;


    @BeforeTest
    public void OpenBrowser() {
        Driver = new ChromeDriver();
        Driver.get("https://demo.nopcommerce.com/");
        Driver.manage().window().maximize();

    }

//    @Test(priority = 1, enabled = true, dependsOnMethods = "", groups = "")
    @Test
    public void getname() {


        Assert.assertEquals(Driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
        System.out.println(Driver.getTitle());
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        Driver.close();
    }
}
