package webtest.automations;

import org.openqa.selenium.By;
import webtest.Automation;
import webtest.security.Credential;
import webtest.security.CredentialManager;

public class FacebookLoginAutomator extends Automation {
    private static FacebookLoginAutomator ourInstance = new FacebookLoginAutomator();

    Credential credentials = CredentialManager.getInstance().getFacebookCredential();

    public static FacebookLoginAutomator getInstance() {
        return ourInstance;
    }

    private FacebookLoginAutomator() {
        super();
    }

    @Override
    public void automate() {
        WDname.get("http://www.facebook.com");
        WDname.findElement(By.id("email")).sendKeys(credentials.getUsername());
        WDname.findElement(By.id("pass")).sendKeys(credentials.getPassword());
        WDname.findElement(By.id("loginbutton")).click();

        String notifications = WDname.findElement(By.id("notificationsCountValue")).getText();
        System.out.println("You have: " + notifications + " new notifications");

    }
}
