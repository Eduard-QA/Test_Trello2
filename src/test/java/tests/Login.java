package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod
    public void preConditions() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }
    }

    @Test
    public void login1() {
        User user = User.builder().email("juliakliot.jk@gmail.com").password("misha240613").build();
        logger.info("Test login positive 1--"+user.getEmail()+""+user.getPassword());

        app.getUser().initLogin();
        app.getUser().pause(2000);
        app.getUser().fillInLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(2000);
        logger.info("Logged--");

        Assert.assertTrue(app.getUser().isLogged());

    }
}