import helpers.WebdriverSettings;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AnswerTheQuestionTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = WebdriverSettings.getDriver();
    }

    @Test
    public void testAnswerTheQuestion() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.answers.com/");
        driver.manage().window().setSize(new Dimension(1200, 1200));
        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Log in with email')]")).click();
        driver.findElement(By.xpath("//input[@id='email-input']")).click();
        driver.findElement(By.xpath("//input[@id='email-input']")).sendKeys("artyom99@bk.ru");
        driver.findElement(By.xpath("//input[@id='outlined-adornment-password']")).click();
        driver.findElement(By.xpath("//input[@id='outlined-adornment-password']")).sendKeys("Dsde@4d1.ds");
        driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//span[contains(text(), 'Answer')]"))));
        driver.findElement(By.xpath("//span[contains(text(), 'Answer')]")).click();
        driver.findElement(By.xpath("(//div[@class = 'notranslate public-DraftEditor-content'])[2]")).click();
        driver.findElement(By.xpath("(//div[@class = 'notranslate public-DraftEditor-content'])[2]")).sendKeys("test answer" + Keys.ENTER);
        driver.findElement(By.xpath("(//span[@class = 'a611'])[6]")).click();
        driver.findElement(By.xpath("(//div[@class = 'notranslate public-DraftEditor-content'])[2]")).sendKeys("test answer" + Keys.ENTER);
        driver.findElement(By.xpath("(//span[@class = 'a611'])[5]")).click();
        driver.findElement(By.xpath("(//div[@class = 'notranslate public-DraftEditor-content'])[2]")).sendKeys("test answer" + Keys.ENTER);
        driver.findElement(By.xpath("(//span[@class = 'a611'])[4]")).click();
        driver.findElement(By.xpath("(//div[@class = 'notranslate public-DraftEditor-content'])[2]")).sendKeys("test answer" + Keys.ENTER);
        driver.findElement(By.xpath("(//span[@class = 'a611 a612'])[3]")).click();
        driver.findElement(By.xpath("(//div[@class = 'notranslate public-DraftEditor-content'])[2]")).sendKeys("test answer" + Keys.ENTER);
        driver.findElement(By.xpath("(//span[@class = 'a611 a612'])[4]")).click();
        driver.findElement(By.xpath("(//div[@class = 'notranslate public-DraftEditor-content'])[2]")).sendKeys("test answer" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@id = 'image-modal-answer-upload']")).sendKeys("/home/suntyra/Pictures/suntyra.png");
        driver.findElement(By.xpath("(//div[@class = 'a652 a461'])")).click();
        driver.findElement(By.xpath("//input[@id = 'image-modal-answer-upload']")).sendKeys("/home/suntyra/Pictures/suntyra.png");
        driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'test answer')]")));
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("(//button[@class = 'a416'])[2]"))));
        driver.findElement(By.xpath("(//button[@class = 'a416'])[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Delete')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Delete')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Close')]")).click();
        driver.quit();
    }
}
