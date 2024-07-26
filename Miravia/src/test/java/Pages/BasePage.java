package Pages;
 
// Importaciones necesarias
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BasePage {
    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus subclases
     */

    protected static WebDriver driver;

    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
    /* 
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el driver del navegador
    */
    static {
        WebDriverManager.chromedriver().setup();

        // Configure ChromeOptions
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
            
            // Initialize ChromeDriver with options
        driver = new ChromeDriver(chromeOptions);
        //driver.manage().window().maximize();
    }
 
    /*
     * Este es el constructor de BasePage que acepta un objeto WebDriver como argumento.
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }
 
    //Método estático para navegar a una URL.
    public static void navigateTo(String url) {
        driver.get(url);
    }

     //Método estático para cerrar la instancia del driver. 
     public static void closeBrowser() {
        driver.quit();
    }

    // Encuentra y devuelve un WebElement en la página utilizando un locator XPath, esperando a que esté presentente en el DOM
    private WebElement FindElement(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
    private WebElement FindElementbByLinkText(String LinkText){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(LinkText)));
    }
 
    public void clickElement(String locator){
        FindElement(locator).click();
    }

    public String textFromElement(String locator){
            return driver.findElement(By.xpath(locator)).getText();
        }

    public void write(String locator, String keysToSend){
        FindElement(locator).clear();
        FindElement(locator).sendKeys(keysToSend);
    }
    
    public void clickButton(String locator){
        //FindElementbByLinkText(LinkText).click();
        //driver.findElement(By.linkText(LinkText)).click();
        
        WebElement buttonElement = driver.findElement(By.xpath(locator));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", buttonElement);

    }
    public void goToLinkText(String LinkText){
        //FindElementbByLinkText(LinkText).click();
        //driver.findElement(By.linkText(LinkText)).click();
        
        WebElement element = driver.findElement(By.linkText(LinkText));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

    }

    public void selectFromDropdownByValue(String locator, String value){
        Select dropdown = new Select(FindElement(locator));
 
        dropdown.selectByValue(value);
    }
 
    public void selectFromDropdownByIndex(String locator, Integer index){
        Select dropdown = new Select(FindElement(locator));
 
        dropdown.selectByIndex(index);
    }
 
    public int dropdownSize(String locator){
        Select dropdown = new Select(FindElement(locator));
 
        List<WebElement> dropdownOptions = dropdown.getOptions();
 
        return dropdownOptions.size();
    }

    public List<String> getDropdownValues(String locator) {
        Select dropdown = new Select(FindElement(locator));
 
        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : dropdownOptions) {
            values.add(option.getText());
        }
 
        return values;
    }
 
}