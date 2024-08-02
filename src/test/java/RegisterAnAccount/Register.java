package RegisterAnAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

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
public void Login(){



    }
    @AfterTest
    public void TearDown() {
        //Driver.quit();

    }

}
