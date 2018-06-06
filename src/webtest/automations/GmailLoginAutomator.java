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

public class GmailLoginAutomator extends Automation {
    private static GmailLoginAutomator ourInstance = new GmailLoginAutomator();

    public static GmailLoginAutomator getInstance() {
        return ourInstance;
    }

    Credential credentials;

    private GmailLoginAutomator() {
        super();
        credentials = CredentialManager.getInstance().getGmailCredential();
    }

    @Override
    public void automate() {
        WDname.get("http://www.gmail.com");
        while (true) {
            try {
                WDname.findElement(By.id("reload-button")).click();
            } catch (NotFoundException exception) {
                break;
            }
        }

        WDname.findElement(By.id("identifierId")).sendKeys(credentials.getUsername());
        WDname.findElement(By.id("identifierNext")).click();

        WebDriverWait wait = new WebDriverWait(WDname, 10);
        WebElement passwordBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));

        passwordBox.sendKeys(credentials.getPassword());
        WDname.findElement(By.id("passwordNext")).click();

        WebDriverWait wait2 = new WebDriverWait(WDname, 10);
        WebElement inbox_link = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.J-Ke.n0")));

        String notifications = inbox_link.getText();
        System.out.println("You have new mail : " + notifications + " ");

    }
}
