import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class RegisterDZoneTest {

    private WebDriver driver;

    @BeforeTest
    public void setDriver() throws Exception {
        String path = "chromedriver90.exe";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();

    }

    @Test
    public void verifyMsgErrorAtRegister() {

        String url = "https://dzone.com";
        driver.get(url);

        WebElement joinLink = driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/div[2]/div/div/div[1]/div/div[2]/div[2]/a[2]"));
        String linkText = joinLink.getText();

        System.out.println("Texto:" + linkText);

        joinLink.click();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement joinButton = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div[2]/div[3]/button"));
        joinButton.click();

        System.out.println("Button Text:" + joinButton.getText());

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement iconAlert = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div[2]/div[1]/div[2]/form/div[6]/span[2]/i"));

        Assert.assertTrue(iconAlert.isDisplayed());

        WebElement emailErrorMessage = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div[2]/div[1]/div[2]/form/div[1]"));
        String attribute = emailErrorMessage.getAttribute("data-validate");

        Assert.assertEquals("Please enter a valid email address", attribute);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterTest
    public void closeDriver() throws Exception {
        driver.quit();
    }
}