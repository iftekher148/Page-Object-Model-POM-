package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static utilities.DriverSetUp.getDriver;

// Find the element.... Ai class ar kaj element khuja.....
public class BasePage {

    //By type locator...
    public WebElement getElement(By locator){
       // waitForElementToBeVisible(locator);
        return getDriver().findElement(locator);
    }
    public void clickOnElement(By locator){
        //getDriver().findElement(locator).click(); // Aivabe likha jai. Not at problem
        //waitForElementToBeClickable(locator);
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String inputText){
        getElement(locator).clear();
        getElement(locator).sendKeys(inputText);
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }

    public boolean isElementVisible(By locator){
        try {
            return getElement(locator).isDisplayed();
        }catch (Exception e){
           return false;
        }

    }

//    public boolean isElementVisible(By locator){
//        return getElement(locator).isDisplayed();
//    }

    public void waitForElementToBeVisible(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public void waitForElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void selectWithVisibleText(By selectLocator, String visibleText){
        //getElement(selectLocator);
        Select select = new Select(getElement(selectLocator));
        select.selectByVisibleText(visibleText);
    }

    public void addScreenShort(String name){
        // Create a object "new Byte"
        //Casting "Driver to TakesScreenshot"
        //Get screenshort output as Byte
        //set it Allure attachment....
       Allure.addAttachment(name,new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
