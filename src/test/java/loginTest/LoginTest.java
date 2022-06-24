package loginTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private static WebDriver driver;

    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver", "/Users/zined/Desktop/Temporaire/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://ludivinecrepin.fr");
    }

    @Test
    public void testH1() {
        WebElement h1 = driver.findElement(By.tagName("h1"));
        assertTrue(h1.getText().compareTo("LUDIVINE CRÉPIN") == 0);
    }

    @AfterAll // exe à la fin de tout les tests
    public static void closeAll() {
        driver.close();
    }
}
