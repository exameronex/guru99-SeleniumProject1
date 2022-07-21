import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Main {
    public static void main(String[] args) {
        //login mngr425050
        //password ygUsEjY

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get(Unit.URL);

        driver.findElement(By.cssSelector("[name=uid]")).sendKeys("invalid");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("valid");
        driver.findElement(By.cssSelector("[name=btnLogin]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();


        assertEquals( "User or Password is not valid", text);
        alert.accept();

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.titleIs(Unit.FIRST_TITLE));

        driver.findElement(By.cssSelector("[name=uid]")).sendKeys("valid");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("invalid");
        driver.findElement(By.cssSelector("[name=btnLogin]")).click();

        alert = wait.until(ExpectedConditions.alertIsPresent());
        text = alert.getText();

        assertEquals( "User or Password is not valid", text);
        alert.accept();

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.titleIs(Unit.FIRST_TITLE));

        driver.findElement(By.cssSelector("[name=uid]")).sendKeys("invalid");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("invalid");
        driver.findElement(By.cssSelector("[name=btnLogin]")).click();

        alert = wait.until(ExpectedConditions.alertIsPresent());
        text = alert.getText();

        assertEquals( "User or Password is not valid", text);
        alert.accept();


        driver.findElement(By.cssSelector("[name=uid]")).sendKeys(Unit.LOGIN);
        driver.findElement(By.cssSelector("[name=password]")).sendKeys(Unit.PASSWORD);

        driver.findElement(By.cssSelector("[name=btnLogin]")).click();

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.titleIs(Unit.EXPECT_TITLE));

        assertEquals(Unit.MESSAGE, driver.findElement(By.cssSelector("[style='color: green']")).getText());



    }
}
