package page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@Log4j2
public class HomePage {
    WebDriver driver;
    public static final long wait_duration= 10000;
    //By elementID= By.xpath("//h5[text()='Elements']");
   @FindBy(xpath = "//h5[text()='Elements']")
    WebElement buttonElement;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }



    public ElementPage navigateToElementPage(){
        //WebDriverWait waitbest= new WebDriverWait(driver, Duration.ofSeconds(10));
       // WebElement liElement = waitbest.until(ExpectedConditions.visibilityOfElementLocated(elementID));
        log.info("Click on the Element button");
        buttonElement.click();
        return new ElementPage(driver);
    }


}
