package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C04_CheckBoxTest {

    //1. Bir class oluşturun : CheckBoxTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.



    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void test1() {
        // a. Verilen web sayfasına gidin.
        //     https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement box1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement box2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        // c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!box1.isSelected()) {
            box1.click();
        }

        // d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!box2.isSelected()) {
            box2.click();
        }

    }

        @After
        public void tearDown(){driver.close();}


//1-Test01 isimli bir class olusturun
//2- https://www.amazon.com/ adresine gidin
//3- Browseri tam sayfa yapin
//4-Sayfayi “refresh” yapin
//5- Sayfa basliginin “Amazon” ifadesi icerdigini control edin
//6-Sayfa basliginin “Amazon.com. Spend less. Smile more.” a esit oldugunu control ediniz
//7- URL in amazon.com icerdigini control edin
//8-”Nutella” icin arama yapiniz
//9- Kac sonuc bulundugunu yaziniz
//10-Sayfayi kapatin



}
