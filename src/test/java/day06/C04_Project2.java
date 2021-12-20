package day06;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class C04_Project2 {
    /*
    Navigate to "https://react-shopping-cart-67954.firebaseapp.com/"
//// List all the elements on the website
//// Create a String Arraylist and put Product Names into the ArrayList
//// Choose 5 items randomly, add to cart and print the names of items
//// (Each product cannot be added more then 1 time!)
//
//// CHECK THE PRICES!
//// Sum each item's price and compare your result with the website
//// If results are matching print success message
//// Get string price values from Website, convert them to double and add to <Double> ArrayList and print the price list
//// Click Checkout
      */
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\user\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");

        Thread.sleep(5000); // Don't create this first wait for the exception //

        // List all the elements on the website
        List<WebElement> allProducts = driver.findElements(By.className("shelf-item__title"));

        // Create a String Arraylist and put Product Names into the ArrayList
        List<String> allProductsStringList = new ArrayList<>();

        for (int i = 0; i < allProducts.size(); i++) {

            allProductsStringList.add(allProducts.get(i).getText());

        }
        System.out.println("All product list -->" + allProductsStringList);


        System.out.println("----------------------");
        System.out.println("CHOSEN ITEMS:");



        // Choose 5 items randomly, add to cart and print the names of items
        // Each product cannot be added more then 1 time!
        List<Integer> itemsAddedToCart = new ArrayList<>();

        while (itemsAddedToCart.size() < 5) {

            Random rnd = new Random();

            int a = rnd.nextInt(allProducts.size());

            if (!itemsAddedToCart.contains(a)) {

                itemsAddedToCart.add(a);

                allProducts.get(a).click();

                Thread.sleep(1000);

                driver.findElement(By.xpath("//div[@class='float-cart__close-btn']")).click();

                Thread.sleep(1000);
            }
        }

        driver.findElement(By.xpath("//span[@class='bag bag--float-cart-closed']")).click();

        Thread.sleep(1000);

//        // CHECK THE PRICES
//        // Sum each item's price and compare your result with the website
//        // If results are matching print success message
//
        List<WebElement> eachItemPrice = driver.findElements(By.xpath("//div[@class='float-cart__content']//div[@class='shelf-item__price']"));

        List<Double> eachPriceDouble = new ArrayList<>();

        double total = 0;

        // Get string price values from Website, convert them to double and add to <Double> ArrayList and print the price list
        for (int k = 0; k < eachItemPrice.size(); k++) {

            String myString = eachItemPrice.get(k).getText();

            myString = myString.replaceAll("[^\\d]", ""); // remove all the non numeric char (letter or special character)

            double myD = Double.parseDouble(myString);

            eachPriceDouble.add(myD);

            total += myD;
        }

        System.out.println("Price List -->" + eachPriceDouble);


        String totalPriceWebSite = driver.findElement(By.xpath("//p[@class='sub-price__val']")).getText();

        totalPriceWebSite = totalPriceWebSite.replaceAll("[^\\d]", "");

        double totalPriceFromWebsite = Double.parseDouble(totalPriceWebSite);

        System.out.println("Result of our calculation for the total price --> " + total);
        System.out.println("Reslt of Website for the total price --> " + totalPriceFromWebsite);
        System.out.println("--> " + totalPriceWebSite);

        Thread.sleep(4000);

        Assert.assertTrue(total == totalPriceFromWebsite);
        System.out.println("Expected result and your result is matching");


        // Click Checkout
        driver.findElement(By.xpath("//div[text()='Checkout']")).click();


        // Handle Alerts
        driver.switchTo().alert().accept();
    }
}
