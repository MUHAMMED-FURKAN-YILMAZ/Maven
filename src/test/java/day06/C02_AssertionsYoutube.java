package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_AssertionsYoutube {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    // ○ titleTest  => Sayfa başlığının “YouTube” oldugunu test edin
    // ○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com");
    }

    @Test
    public void titleTest(){
        String actualTitle=driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertEquals("Baslik YouTube degil",expectedTitle,actualTitle);
    }

    @Test
    public void imageTest(){
        WebElement logo= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue("Logo gorunmuyor",logo.isDisplayed());
    }

    @Test
    public void searchBox(){
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue("Arama kutusuna ulasilamiyor",searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        String unexpectedTitle="youtube";
        String actualTitle=driver.getTitle();
        Assert.assertNotEquals("Title istenmeyen kelimeye esit",unexpectedTitle,actualTitle);

       // Assert.assertFalse("false mesaji",unexpectedTitle.equals(actualTitle));
       // Assert.assertTrue("True Mesaji",!unexpectedTitle.equals(actualTitle));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }



}
