package testrunner;

import org.testng.annotations.Test;
import screens.Leave;
import screens.SignIn;
import setup.Setup;

public class LeaveTestRunner extends Setup {

    SignIn signIn;
    Leave leave;

    @Test
    public void LeaveTest() throws InterruptedException {

        signIn = new SignIn(driver);
        leave = new Leave(driver);
       signIn.signIn("mahedi.hasan@byslglobal.com","12345678");
        leave.applyLeave();

    }
}
