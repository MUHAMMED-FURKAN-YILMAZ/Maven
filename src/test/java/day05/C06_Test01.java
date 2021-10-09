package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C06_Test01 {

//1-Test01 isimli bir class olusturun

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }



//2- https://www.amazon.com/ adresine gidin
    @Test
    public void amazon() {
        driver.get("https://www.amazon.com/");

//3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

//4-Sayfayi “refresh” yapin
        driver.navigate().refresh();

//5- Sayfa basliginin “Amazon” ifadesi icerdigini control edin
        String actualTitle= driver.getTitle();
        String includeTitle="Amazon";
        if (actualTitle.contains(includeTitle)){
            System.out.println("Actual Title contains-> "+includeTitle);
        }else{
            System.out.println("Actual Title does not contains-> "+includeTitle);
        }

//6-Sayfa basliginin “Amazon.com. Spend less. Smile more.”a esit oldugunu control ediniz
        String expectedTitle="Amazon.com. Spend less. Smile more.";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Actual Title equals-> "+expectedTitle);
        }else{
            System.out.println("Actual Title does not equals-> "+expectedTitle);
        }

//7- URL in amazon.com icerdigini control edin
        String actualUrl= driver.getCurrentUrl();
        String includeUrl="amazon.com";
        if (actualUrl.contains(includeUrl)){
            System.out.println("Actual Title contains-> "+includeUrl);
        }else{
            System.out.println("Actual Title does not contains-> "+includeUrl);
        }

//8-”Nutella” icin arama yapiniz
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

//9- Kac sonuc bulundugunu yaziniz
        WebElement searchResult= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Search result-> "+searchResult.getText());
    }

//10-Sayfayi kapatin
    @After
    public void tearDown(){
        driver.close();
    }
}
