package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Before_After {

    // 3 test methodu yapin


    // 1. method amazon.com,
    // 2. method techproeducation'a
    // 3. method facebook'a gitsin
    // eger her test method'u icin yeni bir sayfa acilsin ve test method'u sonunda kapansin
    // istiyorsak @Before ve @After annotation'lari kullanilmali

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void amazonTesti(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void  techproedTesti(){
        driver.get("https://www.techproed.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void  facebookTesti(){
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
    }

    @After
    public void tearDown(){driver.close();}

}
