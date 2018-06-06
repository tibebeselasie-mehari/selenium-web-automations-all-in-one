package webtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Automation {
    protected WebDriver WDname;

    public Automation() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WDname = new ChromeDriver();
    }

    public abstract void automate();

    public void closeWindow(){
        WDname.close();
    }
}
