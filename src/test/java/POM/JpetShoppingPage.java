package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JpetShoppingPage {
	WebDriver driver;
    WebDriverWait wait;
    public JpetShoppingPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    By dogs= By.xpath("//*[@id=\"SidebarContent\"]/h4[2]/a");
    By breed = By.linkText("K9-PO-02");
    By addToCart = By.xpath("//a[@class='btn btn-primary btn-sm']");
    By quantity = By.xpath("//*[@id=\"jpetstore-content\"]/div[2]/form/table/tbody/tr/td[5]/input");
    By updateCart = By.xpath("//button[@class='btn btn-primary btn-sm']");
    By checkout = By.xpath("//a[text()='Proceed to Checkout']");

    public void clickOnDogs(){
        driver.findElement(dogs).click();
    }
    public void clickOnBreed(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"jpetstore-content\"]/div[2]/table/tbody/tr[4]/td[1]/a")));
//
        driver.findElement(breed).click();
    }
    public void clickOnAddToCart(){
        driver.findElement(addToCart).click();
    }
    public void setQuantity(){
        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys("2");
    }
    public void clickOnUpdateCart(){
        driver.findElement(updateCart).click();
    }
    public void clickOnProceedToCheckout(){

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(checkout)));
        driver.findElement(checkout).click();

    }
    public void clickContinue(){
        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
    }
    public void clickConfirm(){
        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
    }

}