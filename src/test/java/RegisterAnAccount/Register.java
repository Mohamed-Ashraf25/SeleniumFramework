package RegisterAnAccount;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Register {
    WebDriver Driver;

    @BeforeTest
    public void OpenBrowser() {
        Driver=new ChromeDriver();
        Driver.get("https://demo.nopcommerce.com/");
        Driver.manage().window().maximize();
        Driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

    }
    @Test(priority = 1)
    public void Registeration(){

        WebElement RegisterBtn=Driver.findElement(By.linkText("Register"));
        RegisterBtn.click();
        WebElement GenderBtn=Driver.findElement(By.id("gender-male"));
        GenderBtn.click();
        WebElement Fname=Driver.findElement(By.id("FirstName"));
        Fname.sendKeys("Mohmaed");
        WebElement Lname=Driver.findElement(By.id("LastName"));
        Lname.sendKeys("Mohmaed");
        WebElement SelectDay =Driver.findElement(By.name("DateOfBirthDay"));
        Select Slct=new Select(SelectDay);
        Slct.selectByValue("21");
        WebElement SelectMonth =Driver.findElement(By.name("DateOfBirthMonth"));
        Slct=new Select(SelectMonth);
        Slct.selectByValue("8");
        WebElement SelectYear =Driver.findElement(By.name("DateOfBirthYear"));
        Slct=new Select(SelectYear);
        Slct.selectByValue("1995");
        WebElement EmailTxt=Driver.findElement(By.id("Email"));
        EmailTxt.sendKeys("marawan124@gmail.com");
        WebElement Password=Driver.findElement(By.id("Password"));
        Password.sendKeys("Ahmed1");
        WebElement ConfirmedPassword=Driver.findElement(By.id("ConfirmPassword"));
        ConfirmedPassword.sendKeys("Ahmed1");
        WebElement SubmitBtn=Driver.findElement(By.id("register-button"));
        SubmitBtn.click();
        String AR="Your registration completed";
        WebElement confirmationTxt=Driver.findElement(By.className("result"));
        Assert.assertEquals(confirmationTxt.getText(),AR);
        WebElement ContinueBtn=Driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a"));
        ContinueBtn.click();


    }
    @Test(priority = 2,dependsOnMethods = {"Registeration"})
    public void PopUpAlet(){

        WebElement AlertBtn=Driver.findElement(By.id(""));
        AlertBtn.click();
        Alert alert=Driver.switchTo().alert();
        String Text=alert.getText();
        Assert.assertEquals(Text,"");
        alert.sendKeys("");
        alert.accept();
        alert.dismiss();


    }
    @Test(priority = 3,enabled = false)
    public  void TestMultipleWindow(){
        String CurrnetWindowId=Driver.getWindowHandle();
        for(String WindowId:Driver.getWindowHandles()){

            String Title=Driver.switchTo().window(WindowId).getTitle();
            if (Title.equalsIgnoreCase("")){
                Assert.assertEquals("",Driver.getTitle());
                Driver.close();
                break;
            }
        }
        Driver.switchTo().window(CurrnetWindowId);
    }

    @Test(priority = 4,enabled = false)
    public  void  TestCookies(){
        Cookie StokeCookie=Driver.manage().getCookieNamed("");
        Assert.assertEquals(null,"");
        Select Slc=new Select(Driver);
        Slc.deselectByVisibleText("");
        StokeCookie=Driver.manage().getCookieNamed("");
        Assert.assertEquals("",StokeCookie.getValue());
        Set<Cookie> CookiesGroup=Driver.manage().getCookies();
        Iterator<Cookie> itr=CookiesGroup.iterator();
        while (itr.hasNext()){

            Cookie Cookiee=itr.next();
            System.out.println(Cookiee.getName());
        }
    }

    @Test(priority = 5,enabled = false)
    public void TestSynchonizationtime(){
        Thread.sleep(1000);   //Threed Sleep
        Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //implicit wait
        WebDriverWait ExplicitWait=new WebDriverWait(Driver,1000);//Explicit Wait "Used to Wait Until Condition "
        ExplicitWait.until(ExpectedConditions.titleContains(""));

        Wait<WebDriver> FluentWait=new FluentWait<WebDriver>(Driver).withTimeout(20,TimeUnit.SECONDS)
                .pollingEvery(2,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement Message=FluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.id(""));
            }
        })

    }


    @AfterTest
    public void TearDown() {
        //Driver.quit();

    }

}
