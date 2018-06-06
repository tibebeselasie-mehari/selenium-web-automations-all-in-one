package webtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import webtest.automations.*;

import java.util.Scanner;


public class WebTest {

    public static void main(String[] args) {

        System.out.println("Welcome to the automations tool\n\n" +
                "======================================\n" +
                "Choose an automation:\n" +
                "\t(1) - Automate Facebook Login and notification checkup.\n" +
                "\t(2) - Login to Gmail and check if there are new primary emails.\n" +
                "\t(3) - Login to AAiT student portal and check last semester grade.\n" +
                "\t(4) -  Access Reporter Magazine and use the contents of published news to grow your new website.\n"
              );


        Automation automation;

        switch (getEnteredValue()) {
            case 1:
                automation = FacebookLoginAutomator.getInstance();
                break;
            case 2:
                automation = GmailLoginAutomator.getInstance();
                break;
            case 3:
                automation = AaitPortalLoginAutomator.getInstance();
                break;
            default:
                automation = ReporterScrapper.getInstance();
                break;
        }

        automation.automate();
        automation.closeWindow();

    }

    public static int getEnteredValue() {
        Scanner scanner = new Scanner(System.in);
        Integer result;
        while (true) {
            System.out.println("please choose a number (0 - to exit program) : ");
            result = scanner.nextInt();
            if(result == 0) System.exit(0);
            if (result > 0 && result <= 4)
                return result;
            System.out.println("invalid choice. please try again.");
        }
    }
}
