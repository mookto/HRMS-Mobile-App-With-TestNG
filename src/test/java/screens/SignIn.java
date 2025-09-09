package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {

    AndroidDriver driver;

    @FindBy(xpath="//android.widget.EditText[contains(@hint,'Username')]\n")
    WebElement userName;
    @FindBy(xpath="//android.widget.EditText[contains(@hint,'Password')]\n")
    WebElement txtPassword;
    @FindBy(xpath="//android.widget.Button[@content-desc=\"Login\"]")
    WebElement btnLogin;

    public SignIn(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void signIn(String username, String password) throws InterruptedException {
        userName.click();
        Thread.sleep(1000);
        userName.sendKeys(username);
        Thread.sleep(1000);
        txtPassword.click();
        Thread.sleep(2000);
        txtPassword.sendKeys(password);
        Thread.sleep(1000);
        btnLogin.click();
        Thread.sleep(5000);

    }
}
