package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverSettings {

    public static WebDriver getDriver(){
        String driveType = "CHROME";
        if (driveType.equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "/home/suntyra/chromedriver");
            return new ChromeDriver();
        }
        if (driveType.equals("FIREFOX")) {
            System.setProperty("webdriver.gecko.driver", "/home/suntyra/geckodriver");
            return new FirefoxDriver();
        }
        return null;
    }
}
