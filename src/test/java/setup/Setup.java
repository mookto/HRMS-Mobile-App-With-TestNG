package setup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Utils;
import screens.Logout;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Setup {

    public AndroidDriver driver;
Logout log;
    @BeforeTest
    public AndroidDriver setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Required capabilities for real device
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "YOUR_ANDROID_VERSION"); // e.g. "13"
        caps.setCapability("deviceName", "0871933276004103"); // e.g. from adb devices
        caps.setCapability("udid", "0871933276004103"); // same as adb devices output
        caps.setCapability("automationName", "UIAutomator2");

        // Install app from local path
        //caps.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/v2.apk");

        // Optional: if app is already installed, use appPackage & appActivity instead of app
         caps.setCapability("appPackage", "ai.smartoffice");
         caps.setCapability("appActivity", ".MainActivity");
        caps.setCapability("noReset", true);

        // Appium server URL (wd/hub is required for Appium < 2)
        URL url = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    @AfterMethod
    public void screenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Utils util = new Utils(driver);
                util.takeScreenShot(result.getName());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @AfterTest
    public void closeApp() {
        log=new Logout(driver);
        log.logout();
        if (driver != null) {
            driver.quit();
        }
    }
}
