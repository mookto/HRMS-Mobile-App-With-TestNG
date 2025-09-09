package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
    AndroidDriver driver;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Menu\nTab 5 of 5\"]")
    WebElement drawerbtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Log out\"]")
    WebElement logoutbtn;

    public Logout(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void logout() {
        drawerbtn.click();
        scrollToLogout();
        logoutbtn.click();
    }

    private void scrollToLogout() {
        try {
            // Method 1: Using AppiumBy (recommended)
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().description(\"Log out\"))"
            ));
        } catch (Exception e) {
            // Method 2: Manual scroll if above fails
            scrollManually();
        }
    }

    private void scrollManually() {
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        new io.appium.java_client.TouchAction<>(driver)
                .press(io.appium.java_client.touch.offset.PointOption.point(startX, startY))
                .waitAction(io.appium.java_client.touch.WaitOptions.waitOptions(java.time.Duration.ofMillis(1000)))
                .moveTo(io.appium.java_client.touch.offset.PointOption.point(startX, endY))
                .release()
                .perform();
    }
}