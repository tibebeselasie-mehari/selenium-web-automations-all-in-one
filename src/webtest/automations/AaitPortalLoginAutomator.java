package webtest.automations;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webtest.Automation;
import webtest.security.Credential;
import webtest.security.CredentialManager;

public class AaitPortalLoginAutomator extends Automation {
    private static AaitPortalLoginAutomator ourInstance = new AaitPortalLoginAutomator();

    public static AaitPortalLoginAutomator getInstance() {
        return ourInstance;
    }

    private Credential credentials;

    private AaitPortalLoginAutomator() {
        super();
        credentials = CredentialManager.getInstance().getAaitPortalCredential();
    }

    @Override
    public void automate() {

        WDname.get("http://portal.aait.edu.et");
        while (true) {
            try {
                WDname.findElement(By.id("reload-button")).click();
            } catch (NotFoundException exception) {
                break;
            }
        }

        WDname.findElement(By.id("UserName")).sendKeys(credentials.getUsername());
        WDname.findElement(By.id("Password")).sendKeys(credentials.getPassword());
        WDname.findElement(By.cssSelector("button[type='submit']")).click();

    }
}
