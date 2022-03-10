import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "idtoken1")
    private WebElement input_username;
    @FindBy(id = "idtoken2")
    private WebElement input_password;
    @FindBy(xpath = "(//button[@data-id=\"login\"])[1]")
    private WebElement btn_login;
    @FindBy(xpath = "(//div[@data-testid=\"auth-failed\"])[1]")
    private WebElement txt_failedMessage;
    @FindBy(xpath = "//div[@class=\"sc-kkGfuU kJTCeM\"]")
    private WebElement txt_appMessage;
    @FindBy(xpath = "//a[@href='https://www.telus.com/my-telus/forgot/username']")
    private WebElement link_forgotUsername;
    @FindBy(xpath = "//a[@href='https://www.telus.com/my-telus/forgot/password?clientId=uni_portal']")
    private WebElement link_forgotPassword;

    LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public void fillForm(String user, String password){
        try {
            Thread.sleep(2000);
            input_username.sendKeys(user);
            Thread.sleep(2000);
            input_password.sendKeys(password);
            input_username.sendKeys(user);
            Thread.sleep(2000);
            btn_login.click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void fillUserField(String user){
        wait.until(ExpectedConditions.visibilityOf(input_username));
        input_username.sendKeys(user);
        waitSleep(3000);
    }

    public void clickLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(btn_login));
        btn_login.click();
    }

    public String getAppMessage(){
        wait.until(ExpectedConditions.visibilityOf(txt_appMessage));
        System.out.println( txt_appMessage.getText());
        return txt_appMessage.getText();
    }

    public void clickForgotUsername(){
        wait.until(ExpectedConditions.visibilityOf(link_forgotUsername));
        link_forgotUsername.click();
        waitSleep(2000);
    }

    public void clickForgotPassword(){
        wait.until(ExpectedConditions.visibilityOf(link_forgotPassword));
        link_forgotPassword.click();
        waitSleep(2000);
    }

    public void waitSleep(int a){
        try {
            Thread.sleep(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
