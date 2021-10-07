package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Test01 {
    public static void main(String[] args) {
        //1-Test01 isimli bir class olusturun
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //2- https://www.walmart.com/ adresine gidin
        driver.get("https://www.walmart.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4-Sayfayi “refresh” yapin
         driver.navigate().refresh();

        //5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        String actualTitle=driver.getTitle();
        String title="Save";

        if (actualTitle.contains(title)){
            System.out.println("Title contain "+title+" Test PASS");
        }else {
            System.out.println("Title does not contain "+title+" Test FAILED");
        }

        //6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        String expectedTitle="Walmart.com | Save Money.Live Better";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title equals "+title+" Test PASS");
        }else {
            System.out.println("Title does not equals "+title+" Test FAILED");
        }

        //7- URL in walmart.com icerdigini control edin
        String actualUrl=driver.getCurrentUrl();
        String includeUrl="walmart.com";

        if (actualUrl.contains(includeUrl)) {
            System.out.println("Actual URL contain "+includeUrl+" Test PASS");
        }else {
            System.out.println("Actual URL does not contain "+includeUrl+" Test FAILED");
        }

        //8-”Nutella” icin arama yapiniz
        WebElement searchBox= driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        //9- Kac sonuc bulundugunu yaziniz
        WebElement searchResult= driver.findElement(By.xpath("//div[@class='inline-flex mv3-xl mt3 ml3 ml4-xl mr1 db']"));
        System.out.println(searchResult.getText());

        //10-Sayfayi kapatin
        driver.close();

        //Collapse
        //
        //
        //
        //
        //
        //Send a message to qa-live-channel
    }
}
