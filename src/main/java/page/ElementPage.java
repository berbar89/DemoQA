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
    @FindBy(className = "main-header")
    WebElement pageTitle;
    //private By pageTitle = By.className("main-header");

    public ElementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ElementPage verifyOnElementsPage() {
        String expectedTitle = "Elements";
        String actualTitle = pageTitle.getText();
        if (!actualTitle.equals(expectedTitle)) {
            log.error("You are not on the Elements page.");
            throw new IllegalStateException("You are not on the Elements page.");
        } else
            log.info("You are on the Elements page.");

        return this;
    }

    public WebTablesPage navigateToWebTablesPage() {
        // Créez un objet JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // défiler vers le bas de la page
        //  spécifier la distance en pixels (par exemple, 500)
        js.executeScript("window.scrollBy(0, 500);");
        //cliquer sur web table
        log.info("Navigated to the WebTables page");
        buttonwebTables.click();
        return new WebTablesPage(driver);
    }


}

