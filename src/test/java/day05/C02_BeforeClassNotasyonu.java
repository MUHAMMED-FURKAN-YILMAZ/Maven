package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_BeforeClassNotasyonu {

    // amazon sayfasina gidip 3 farkli test methodu hazirlayin
    // her method'da farkli aramalar yapalim

        static WebDriver driver; // -> scop'a takilmamak icin bunu class member yaptik
        WebElement searcBox=driver.findElement(By.id("twotabsearchtextbox"));



    @BeforeClass //-> Junit'te @BeforeClass kullaniyorsak static yapmaliyiz
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
    }

    @Test
    public void Test1(){
        searcBox.clear();
        searcBox.sendKeys("Nutella"+ Keys.ENTER);
    }

    @Test
    public void Test2(){
        searcBox.clear();
        searcBox.sendKeys("Bicycle"+ Keys.ENTER);
    }

    @Test
    public void Test3(){
        searcBox.clear();
        searcBox.sendKeys("java"+ Keys.ENTER);
    }

    @AfterClass // bu da @BeforeClass gibi static olmali
    public static void tearDown(){
        driver.close();
    }


}
