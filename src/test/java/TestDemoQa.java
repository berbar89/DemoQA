
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;

public class TestDemoQa {
    WebDriver driver;

    private static final String URL= "https://demoqa.com/";
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        driver= new FirefoxDriver();
        driver.get(URL);
        // Créez un objet JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Faire défiler vers le bas de la page
        //  spécifier la distance en pixels (par exemple, 500)
        js.executeScript("window.scrollBy(0, 500);");
    }

    @Test
    public void testDemo(){
        HomePage hp=new HomePage(driver);

        hp.navigateToElementPage()
                .verifyOnElementsPage()
                .navigateToWebTablesPage()
                .ortBySalaryDescending()
                .deleteLastRow();


    }

   @AfterMethod
    public void Teardown(){
        //log.info("Test terminé");
        driver.quit();
    }

}
