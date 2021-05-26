import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class SearchGoogleTest {
    private WebDriver driver;

    @BeforeTest
    public void setDriver() throws Exception {
        String path = "chromedriver91.exe";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();

    }

    /*
     * Preparacion de la prueba
     * Logica de la prueba
     * Verificacion - Assert
     */
    @Test
    public void principalPageGoogle() {
        String googleUrl = "https://www.google.com";
        driver.get(googleUrl);
        // Step 1: find element
        WebElement searchField = driver.findElement(By.name("q"));
        // Step 2: write in the element
        searchField.sendKeys("UCB");
        // Step 3: submit form
        searchField.submit();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        WebElement result = driver.findElement(By.xpath("//*[@id=\"wp-tabs-container\"]/div[1]/div[2]/div[1]/div/div[2]/h2/span"));
        WebElement result = driver.findElement(By.xpath("//*[@id=\"_32muYMaAAsic5OUPn_2tqAY86\"]/div[1]/div[2]/div[1]/div/div[2]/h2"));
        Assert.assertEquals(result.getText(), "Universidad Católica Boliviana \"San Pablo\" Regional La Paz");
    }

    @AfterTest
    public void closeDriver() throws Exception {
        driver.quit();
    }
}