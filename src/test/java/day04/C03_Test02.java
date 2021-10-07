package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Test02 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //3. Login alanine  “username” yazdirin
        driver.findElement(By.id("user_login")).sendKeys("username");


        //4. Password alanine “password” yazdirin
        driver.findElement(By.id("user_password")).sendKeys("password");


        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.get("http://zero.webappsecurity.com");

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("1000");

        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");

        //9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement successfullySubmitted= driver.findElement(By.id("alert_content"));

        if (successfullySubmitted.isDisplayed()){
            System.out.println("Test PASS");
        }else {
            System.out.println("Test FAILED");
        }
        driver.close();

        // ODEV
        //1. “https://www.saucedemo.com” Adresine gidin
        //2. Username kutusuna “standard_user” yazdirin
        //3. Password kutusuna “secret_sauce” yazdirin
        //4. Login tusuna basin
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        //6. Add to Cart butonuna basin
        //7. Alisveris sepetine tiklayin
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        //9. Sayfayi kapatin

    }
}
