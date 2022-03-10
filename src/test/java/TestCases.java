import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestCases {

    WebDriver driver;
    WebDriverWait wait;

    HomePage home;
    LoginPage login;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\luis.lara\\Downloads\\91\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.get("https://www.telus.com/en/smarthome-security/adt-telus-family");
    }
    @AfterMethod
    public void finish(){
        driver.quit();
    }


    @Test
    public void checkAppMessage(){
        home = new HomePage(driver,wait);
        login = new LoginPage(driver,wait);
        home.clickLoginButton();
        String message = login.getAppMessage();
        Assert.assertEquals(message," It's easier on the app. Text app to 54555 to download.");
    }

    @Test
    public void checkForgotUsernameLink(){
        home = new HomePage(driver,wait);
        login = new LoginPage(driver,wait);
        home.clickLoginButton();
        login.clickForgotUsername();
        String message = driver.getCurrentUrl();
        Assert.assertEquals(message,"https://www.telus.com/my-telus/forgot/username");
    }

    @Test
    public void checkForgotPasswordLink(){
        home = new HomePage(driver,wait);
        login = new LoginPage(driver,wait);
        home.clickLoginButton();
        login.clickForgotPassword();
        String message = driver.getCurrentUrl();
        Assert.assertEquals(message,"https://www.telus.com/my-telus/forgot/password?clientId=uni_portal");
    }
}
