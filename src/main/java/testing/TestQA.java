/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

/**
 *
 * @author luise.ardon
 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestQA {
   
   private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\luise.ardon\\Desktop\\chromedriver 117\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
    }

    @Test
    public void testDemoQAFlow() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait( driver, 10 );
        // 1. Módulo “Elements”
        driver.findElement(By.xpath("//h5[text()='Elements']")).click();
        // 1a. “Check Box”
        driver.findElement(By.xpath("//span[text()='Check Box']")).click();
        // 1b. Botón “+”
        driver.findElement(By.cssSelector(".rct-icon.rct-icon-expand-close")).click();
        // 1c. Seleccionar ExcelFile y WordFile
        driver.findElement(By.xpath("//span[text()='Documents']")).click();
        driver.findElement(By.xpath("//span[text()='Downloads']")).click();
        //driver.findElement( By.xpath("//span[text()='Word File.doc']")).click();

        // 2. “Dynamic Properties”
        driver.findElement(By.xpath("//span[text()='Dynamic Properties']")).click();
        // 2a. Esperar 5 segundo
        Thread.sleep(5000);
        // 2b. Click en el botón
        driver.findElement(By.id("enableAfter")).click();

        // 3. “Web Tables”
        driver.findElement(By.xpath("//span[text()='Web Tables']")).click();
        // 3a. Eliminar el primer elemento
        driver.findElement( By.id("delete-record-1") ).click();
        // 3b y 3c. Añadir un nuevo registro y llenar el formulario
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys("Juan");
        driver.findElement(By.id("lastName")).sendKeys("Perez");
        driver.findElement(By.id("userEmail")).sendKeys("test@test.bi.com.gt");
        driver.findElement(By.id("age")).sendKeys("30");
        driver.findElement(By.id("salary")).sendKeys("8000");
        driver.findElement(By.id("department")).sendKeys("Guatemala");
        driver.findElement(By.id("submit")).click();

        // 4. Módulo “Forms”
        driver.findElement(By.xpath("//span[text()='Forms']")).click();
        // 4a. Llenar el formulario
        driver.findElement(By.id("firstName")).sendKeys("Luis");
        driver.findElement(By.id("lastName")).sendKeys("Ardon");
        driver.findElement(By.id("userEmail")).sendKeys("test@test.bi.com.gt");
        driver.findElement(By.id("userNumber")).sendKeys("1234567890");
        driver.findElement(By.id("submit")).click();
        // 4c. Cerrar el resumen
        driver.findElement(By.id("closeLargeModal")).click();

        // 5. Módulo “Book Store Aplication”
        driver.findElement(By.xpath("//h5[text()='Book Store Application']")).click();
        // 5a. “Book Store”
        driver.findElement(By.xpath("//span[text()='Book Store']")).click();
        // 5b. Buscar el libro
        driver.findElement(By.id("searchBox")).sendKeys("Understanding ECMAScript 6");
        // 5c. Seleccionar el título
        driver.findElement(By.xpath("//span[text()='Understanding ECMAScript 6']")).click();
        // 5d. Seleccionar el link
        driver.findElement(By.linkText("Read More")).click();
        // 5e. Cerrar la página del link
        driver.navigate().back();
        // 5f. Regresar con el botón “Back to Store”
        driver.findElement(By.id("addNewRecordButton")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
