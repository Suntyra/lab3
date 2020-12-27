import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EvaluateAnswerTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/home/suntyra/chromedriver");
        //System.setProperty("webdriver.gecko.driver", "/home/suntyra/geckodriver");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
    }

    @Test
    public void testEvaluateAnswer() throws InterruptedException {
        driver.get("https://www.answers.com/");
        driver.manage().window().setSize(new Dimension(1200, 1200));
        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(), 'Log in with email')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='email-input']")).click();
        driver.findElement(By.xpath("//input[@id='email-input']")).sendKeys("artyom99@bk.ru");
        driver.findElement(By.xpath("//input[@id='outlined-adornment-password']")).click();
        driver.findElement(By.xpath("//input[@id='outlined-adornment-password']")).sendKeys("Dsde@4d1.ds");
        driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//span[contains(text(), 'Answer')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(), 'Close')]")).click();
        driver.findElement(By.xpath("(//button[contains(@class, 'up-arrow')])[1]")).click();
        driver.findElement(By.xpath("(//button[contains(@class, 'a305') and contains(@class, 'a455')])[2]")).click();
        driver.findElement(By.xpath("(//button[contains(@class, 'a305') and contains(@class, 'a455')])[2]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'a469') and contains(@class, 'a467')])[1]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'a469') and contains(@class, 'a467')])[2]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'a469') and contains(@class, 'a467')])[3]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'a469') and contains(@class, 'a467')])[4]")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}

