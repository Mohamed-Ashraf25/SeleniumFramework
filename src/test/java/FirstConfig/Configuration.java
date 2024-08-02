package FirstConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


/*
* Selenium Is a Robust tool that support rapid development of test website automation Feature->{open source , cross browser , multilingual ,cross browser }
* we use maven to solve java project problem no dependinces & pom.xml & can connect remotly with svn /github
*we use testng as it provide annotation and test runner and generate test report Can do parallel testing
* test annotation -> @Before {test,method,class,suite,group}
* -> @Aftr {test,method,class,suite,group}
* -> @test -> without this annotation no running for project
* ->@dataprovider {Used id DDT }
* ->@listener -> {used to track and save logs to report}
* */
public class Configuration {
    WebDriver Driver;

/*To config pop up window`s security authenticated

driver.get("https://useradmin:passwordadmin@url/basic-Auth");
if there is a wrong in syntax back to selenium documentation
* */
    @BeforeTest
    public void OpenBrowser() {
        Driver = new ChromeDriver();
        Driver.get("https://demo.nopcommerce.com/");
        Driver.manage().window().maximize();


    }

    //Any path or directory  inside the code But \\ before each file

//    @Test(priority = 1, enabled = true, dependsOnMethods = {""}, groups = {""})
    //Be Noted when use groups must config in regression.xml file tag runner include method name  .
    @Test
    public void getname() {
/*

       // Hard Assertion  kill process when found stop running
        //Assert.assertEquals(AR.contains("ER"),"Error Message ");

        //Soft assertion we write more than one assertion form tc in each assert write a message to discrement it
        SoftAssert soft=new SoftAssert();
        soft.assertEquals("","");
        soft.assertAll();//without this line no softassert will running

        */


        /*
        * Findelement -> Retun single instant if not found will return Exception
        *
        * Findelements -> Return list of element if not found rreturn null or zero or empty data list
        * */

//        WebElement User=Driver.findElement(By.id("")).sendKeys("Ahmed");
//        User.sendKeys(Keys.ENTER);
        //Keys is a class that contain keyboard action line ->  <- Enter Alt Shift Etc
//        User.click();
        Driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        Assert.assertEquals(Driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
        System.out.println(Driver.getTitle()); //Return page title
        //geturl(); will return url
        //getpagesource();  // will return source code of the page .
        //getwindowhandle(); wii return id of single browser
        //getwindowhandles(); will return id`s of multiple browser
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        Driver.close(); // Close Single Page
//        Driver.quit(); // Close all Browser Page
    }
}
