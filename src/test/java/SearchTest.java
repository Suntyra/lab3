import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/home/suntyra/chromedriver");
        //System.setProperty("webdriver.gecko.driver", "/home/suntyra/geckodriver");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
    }

    @Test
    public void testSearch() throws InterruptedException {
        driver.get("https://www.answers.com/");
        driver.findElement(By.xpath("//input[@name='q']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Shrek");
        driver.findElement(By.xpath("//input[@name='q']")).submit();
        Thread.sleep(2000);
        assertThat(driver.findElement(By.xpath("//span[contains(text(), 'Shrek')]")).getText(), is("Shrek"));
        driver.quit();
    }
}
