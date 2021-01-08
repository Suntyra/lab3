import helpers.WebdriverSettings;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AnswerTheQuestionTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = WebdriverSettings.getDriver();
    }

    @Test
    public void testAnswerTheQuestion() throws InterruptedException {
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
        driver.findElement(By.xpath("(//div[@class = 'notranslate public-DraftEditor-content'])[2]")).click();
        driver.findElement(By.xpath("(//div[@class = 'notranslate public-DraftEditor-content'])[2]")).sendKeys("test answer");
        driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@class = 'a416'])[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Delete')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Delete')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Close')]")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
