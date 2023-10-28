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
public class WebTablesPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='rt-resizable-header-content' and text()='Salary']")
    WebElement buttonSalary;

    By deleteButton = By.xpath("//div[@class='action-buttons']/span[@title='Delete']");
    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebTablesPage ortBySalaryDescending() {
        // Créez un objet JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        log.info("Sorted by salary in descending order.");
        buttonSalary.click();

        // Attendre un court instant pour la mise à jour du tri
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public WebTablesPage deleteLastRow() {
        List<WebElement> deleteButtons = driver.findElements(deleteButton);
        // Créez un objet JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        if (!deleteButtons.isEmpty()) {
            deleteButtons.get(deleteButtons.size() - 1).click();
            log.info("Deleted the last row.");
        }

        return this;
    }
}