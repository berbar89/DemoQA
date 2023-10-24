package page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
@Log4j2
public class ElementPage {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='Web Tables']")
            WebElement buttonwebTables;
    @FindBy(xpath = "//div[@class='rt-resizable-header-content' and text()='Salary']")
            WebElement buttonSalary;
    By deleteButton = By.xpath("//div[@class='action-buttons']/span[@title='Delete']");

    By title= By.cssSelector(".main-header");

    public ElementPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public ElementPage navigateToWebTablesPage() {
        // Créez un objet JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // défiler vers le bas de la page
        //  spécifier la distance en pixels (par exemple, 500)
        js.executeScript("window.scrollBy(0, 500);");
        //cliquer sur web table
        log.info("Click on Web Tables button");
        buttonwebTables.click();

      return this;
       }
   public ElementPage ortBySalaryDescending(){
        // Créez un objet JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        log.info("Click on salary button");
        buttonSalary.click();

        // Attendre un court instant pour la mise à jour du tri
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      return this;
    }

    public ElementPage deleteLastRow() {
        List<WebElement> deleteButtons = driver.findElements(deleteButton);
        if (!deleteButtons.isEmpty()) {
            deleteButtons.get(deleteButtons.size() - 1).click();
        }

        return this;
        }

    }

