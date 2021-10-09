package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_Assertions {

    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // ○ logoTest => BestBuy logosunun görüntülendigini test edin
    // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void urlTest(){
        String actualURL= driver.getCurrentUrl();
        String expectedURL="https://www.bestbuy.com/";
        Assert.assertEquals("Istenen URL bulunamadi",expectedURL,actualURL);
    }

    @Test
    public void titleTest(){
        String actualTitle= driver.getTitle();
        String unexpectedWord="Rest";
        Assert.assertFalse("unexpected word contains title",actualTitle.contains(unexpectedWord));
        // virgulun sagi boolean sartimiz. False aradigimiz icin boolean F donerse Pass, diger durumda Failed doner
    }

    @Test
    public void logoTest(){
        WebElement logo= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue("Logo is not display",logo.isDisplayed());
    }

    @Test
    public void fransizcaTest(){
        WebElement fransizcaLinki= driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue("Fransizca Linki goruntulenemiyor",fransizcaLinki.isDisplayed());
    }


    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
