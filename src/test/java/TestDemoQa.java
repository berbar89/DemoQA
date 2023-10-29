import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.WebTablesPage;

import java.awt.desktop.SystemEventListener;
import java.util.List;

@Log4j2
public class TestDemoQa {
    WebDriver driver;

    private static final String URL = "https://demoqa.com/";
    // Mémoriser l'état initial du tableau


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(URL);
        // Créez un objet JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Faire défiler vers le bas de la page
        //  spécifier la distance en pixels (par exemple, 500)
        js.executeScript("window.scrollBy(0, 500);");
    }

    @Test
    public void testDemo() {
        HomePage hp = new HomePage(driver);
        int tableSizeBeforeDeletion = hp.navigateToElementPage()
                .verifyOnElementsPage()
                .navigateToWebTablesPage()
                .ortBySalaryDescending()
                .getTableSize();

        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.deleteLastRow();

        int tableSizeAfterDeletion = webTablesPage.getTableSize();
        Assert.assertEquals(tableSizeBeforeDeletion - 1, tableSizeAfterDeletion);
        log.info("Verification of successful deletion.");

    }

    @AfterMethod
    public void Teardown() {
        //log.info("Test terminé");
        driver.quit();
    }

}
