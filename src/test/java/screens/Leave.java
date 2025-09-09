package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class Leave {
    AndroidDriver driver;
    Utils utils;

    @FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.Button")
    WebElement btnLeave;
 @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ImageView[1]")
    WebElement btnApplyLeave;
    @FindBy(xpath = "//android.widget.EditText")
    WebElement txtPurpose;
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Apply\"]")
    WebElement btnApply;
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Done\"]")
    WebElement btnDone;

    public Leave(AndroidDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        this.driver = driver;
        this.utils = new Utils(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void applyLeave() throws InterruptedException {
        btnLeave.click();
        Thread.sleep(3000);
        btnApplyLeave.click();
        utils.scrollDown();
        txtPurpose.click();
        txtPurpose.sendKeys("test");
        driver.hideKeyboard();
        utils.scrollDown();
        Thread.sleep(1000);
        btnApply.click();
        Thread.sleep(1000);
        btnDone.click();
        Thread.sleep(3000);
    }
}
