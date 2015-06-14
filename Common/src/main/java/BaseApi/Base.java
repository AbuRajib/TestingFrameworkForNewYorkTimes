package BaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by HP on 6/13/2015.
 */
public class Base {
    WebDriver driver=null;

    @Parameters({"useSauceLab","useName","key","BrowserName","BrowserVersion","os","url"})
    @BeforeMethod
    public void setUp(Boolean useSauceLab,String useName,String key,String BrowserName,
                      String BrowserVersion,String os,String url) throws IOException {

        if(useSauceLab==true){
            setUpCloudEnvironment(useName,key,BrowserName,BrowserVersion,os,url);
        }

        else {
            setUpLocalEnvironment(BrowserName,BrowserVersion,url);

        }

    }


    public void setUpCloudEnvironment(String useName,String key,String BrowserName,
                                      String BrowserVersion,String os,String url) throws IOException {

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setBrowserName(BrowserName);
        cap.setCapability("version",BrowserVersion);
        cap.setCapability("platform",os);

        this.driver=new RemoteWebDriver(new URL("http://"+useName+":"+key+"@ondemand.saucelabs.com:80/wd/hub"),cap);
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    public void setUpLocalEnvironment(String BrowserName,String BrowserVersion,String url){

        if(BrowserName.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
        }

        else if(BrowserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","..//Common//Selenium-Driver//chromedriver.exe");
            driver=new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }












    @AfterMethod
    public void cleanUp(){
        driver.close();
    }

    public void clickByCss(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }

    public void clickByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }

    public void typeByCss(String locator,String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void typeByXpath(String locator,String value){
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void typeAndEnterByCss(String locator,String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    public void typeAndEnterByXpath(String locator,String value){
        driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
    }

    public void clickByText(String locator) throws InterruptedException {
        driver.findElement(By.linkText(locator)).click();
        sleepFor(2);
    }

    public String getTextByCss(String locator){
        String text=driver.findElement(By.cssSelector(locator)).getText();
        return text;
    }

    public String getTextByXpath(String locator){
        String text=driver.findElement(By.xpath(locator)).getText();
        return text;
    }

    public List<String> getListOfTextByCss(String locator){
        List<WebElement> elements=driver.findElements(By.cssSelector(locator));
        ArrayList<String> list=new ArrayList<String>();
        for(WebElement wb:elements){
            list.add(wb.getText());
        }
        return list;
    }

    public List<String> getListOfTextByXpath(String locator){
        List<WebElement> elements=driver.findElements(By.xpath(locator));
        ArrayList<String> list=new ArrayList<String>();
        for(WebElement wb:elements){
            list.add(wb.getText());
        }
        return list;
    }

    public void displayText(List<String> list){
        for(String st:list){
            System.out.println(st);
        }
    }

    public List<WebElement> getWebElementsByCss(String locator){
        List<WebElement> elements=driver.findElements(By.cssSelector(locator));
        return elements;
    }

    public List<WebElement> getWebElementsByXpath(String locator){
        List<WebElement> elements=driver.findElements(By.xpath(locator));
        return elements;
    }

    public void sleepFor(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    public void navBack(){
        driver.navigate().back();
    }

}
