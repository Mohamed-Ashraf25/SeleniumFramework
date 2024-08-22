package RegisterAnAccount;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v125.network.model.Request;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import javax.xml.transform.Source;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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

    @Test(priority = 6,enabled = false)
    public void TestFrames(){

        Driver.switchTo().frame("");
        WebElement Message= Driver.findElement(By.id(""));
        Message.click();
        Driver.switchTo().defaultContent();

    }
    @Test(priority = 7,enabled = false)
    public void Scroll(){
        JavascriptExecutor Js=(JavascriptExecutor) Driver;
        Js.executeScript("ScrollBy(0,3000)");
        Thread.sleep(3000);

    }

    @Test(priority = 8,enabled = false)
    public void ContextMenu() {  // To use we Must Use Right Click
        WebElement ClkBtn=Driver.findElement(By.id(""));
        Actions Builder-new Actions(Driver);
        Builder.contextClick(ClkBtn).moveToElement(ContextMenu()).click().perform();
        WebDriverWait ExplicitWait=new WebDriverWait(Driver,20);
        Alert alert= ExplicitWait.until(ExpectedConditions.alertIsPresent());
        SoftAssert Soft=new SoftAssert();
        Soft.assertEquals("",alert.getText());
        Soft.assertEquals("","");
        alert.dismiss();
    }

    @AfterSuite
    public void TakeScreenShot(ITestResult Result) {
        if (ITestResult.FAILURE== Result.getStatus()){
            TakesScreenshot Ts=(TakesScreenshot) Driver;
            File ScreenShot=Ts.getScreenshotAs(OutputType.FILE);
            File Utils.(Source,new File("./Screen/"+Result.getName()+".png"));
        }
    }
    private  int CountImage=0;
    @Test(priority = 8,enabled = false)
    public <invalid> void TestBrokenImages() {
        invalid Images = 0;
        List<WebElement> ImageList = Driver.findElements(By.tagName(""));
        for (WebElement imageelement : ImageList) {
            if (imageelement != null) {

                VerifyImageActive(imageelement);

            }

        }
    }
    public static void VerifyImageActive(WebElement ImageElement){
        HttpClient Client= HttpClient.newBuilder().build();

        try {
            HttpResponse Response=Client.executor(Request);
            if (Response.getStatus()!=200){
                System.out.println("Invalid Image ");

            }

        }catch (Exception E){
            E.printStackTrace();
            E.getCause();
            E.getMessage();
        };
    }
    @Test(priority = 9,enabled = false)
    public void TestBrokenLinks(){
        List<WebElement> Links=Driver.findElements(By.tagName(""));
        System.out.println("Total Links" +Links.getFirst().getSize());

        for (int i=0;i>Links.size();i++){
            WebElement Element=Links.get(i);
            String URLL=Element.getAttribute("href");
            VerifyLinks(URLL);

        }


    }
    public static void VerifyLinks(String URLLink){
        try {
            URL Link=new URL(URLLink);
            HttpURLConnection Httpcon=(HttpURLConnection) Link.openConnection();
            Httpcon.setConnectTimeout(2000);
            Httpcon.connect();
            if(Httpcon.getResponseCode()==200){
                System.out.println("Sucess");
            }

        }catch (Exception e){
            e.getCause();
            e.getMessage();
        }


    }

    @Test(priority = 9,enabled = false)
    public void UploadFile() {
        String Imagename="Ahmed.png";
        String ImagePath=System.setProperty("user.dir")+"/Uploads/"+Imagename;
        WebElement Fileuploader=Driver.findElement(By.id(""));
        Fileuploader.sendKeys(ImagePath);
        WebElement FileSubmit=Driver.findElement(By.id()).click();
        WebElement Uploadfilee= Driver.findElement(By.id(""));
        Assert.assertEquals("Imagename",Uploadfilee.getText());

    }

    //incase of element dosen`t support sendkeys & click we use robot class
    @Test(priority = 10,enabled = false)
    public void UploadedFileUsingRobotClass(){

        String ImageName="AhmedPng";
        String ImagePath=System.setProperty("user.dir")+"/Uploads/"+ImageName;
        WebElement Fileuploader=Driver.findElement(By.id(""));
        Robot robot=new Robot();
        StringSelection selection=new StringSelection(ImagePath);
        Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection,null);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
        WebElement FileSubmit=Driver.findElement(By.id()).click();
        WebElement Uploadfile= Driver.findElement(By.id(""));
        Assert.assertEquals("",Uploadfile.getText();

    }

    public  static String DownloadPath=System.setProperty("user.dir")+"/Downloads/";
    @Test(priority = 11,enabled = false)
    public void DownloadFile() {
        Driver.findElement(By.linkText("")).click();
        Thread.sleep(3000);

    }
    public  static FirefoxOptions Fireoption(){
        FirefoxOptions options=new FirefoxOptions();
        options.addPreference("","");
        options.addPreference("","");
        options.addPreference("","");
        options.addPreference("","");
        return options;
    }
    public  static ChromeOptions Chromeoption(){
        ChromeOptions optionss=new ChromeOptions();
        HashMap<String,Object> ChromePref=new HashMap<String,Object>();
        ChromePref.put("","");
        ChromePref.put("","");
        ChromePref.put("","");
        optionss.setExperimentalOption("","");
        optionss.setCapability("",true);
        return  optionss;
    }

    //Help Us to draw Circle & Rectanguler
    @Test(priority = 12,enabled = false)
    public void htmlCanvas() {
        WebElement Drawlist=Driver.findElement(By.id(""));
        WebElement Canvas= Driver.findElement(By.id(""));
        Select Slct=new Select(Drawlist);
        Slct.selectByValue("");
        Actions Builder=new Actions(Driver);
        Builder.clickAndHold(Canvas).moveByOffset(,).moveByOffset(,).moveByOffset(,).moveByOffset(,).release().perform();
    }

    //Html5 Web Application Vedio Player
    @Test(priority = 13,enabled = false)
    public void Html5VedioPlayer() {

        WebElement VedioPlayer= Driver.findElement(By.id(""));
        JavascriptExecutor Js=(JavascriptExecutor) Driver;
        String Src=(String) Js.executeScript("Return arguments[0].duration",VedioPlayer);
        Assert.assertEquals("",Source);


    }

    @AfterTest
    public void TearDown() {
        //Driver.quit();

    }

}
