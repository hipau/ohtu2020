package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        
        // Sisäänkirjautuminen
        /*
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        
        // Oikea salasana
        //element = driver.findElement(By.name("password"));
        //element.sendKeys("akkep");
        
        // Väärä salasana
        element = driver.findElement(By.name("password"));
        element.sendKeys("wrong");
        
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        */
        
        // Uuden käyttäjätunnuksen luominen
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(1);
        
        Random r = new Random();    
        element = driver.findElement(By.name("username"));
        element.sendKeys("uusi" + r.nextInt(100000));        
        element = driver.findElement(By.name("password"));
        element.sendKeys("password");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("password");        
        sleep(1);
        
        element = driver.findElement(By.name("signup"));
        element.submit();
        sleep(2);
        
        // Uloskirjautuminen
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(1);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(1);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
