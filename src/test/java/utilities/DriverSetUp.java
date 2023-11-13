package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverSetUp {

    // Take  Browser from console key: "browser"
    // Or define default  def: "Chrome"
    private static String browserName = System.getProperty("browser","chrome");
    //private static String browserName = System.getProperty("browser"); // Without default browserName

    //static: This keyword makes the LOCAL_DRIVER variable shared across all instances of the class
    //final: The final keyword makes the LOCAL_DRIVER variable constant. Once it's assigned a value, it cannot be changed
    //In the context of parallel test execution, this ensures that each thread running a test has access to the same ThreadLocal instance.
    //If there are 3 test cases that take time 10s,4s,1s. After first test execution(10s) driver will quite.
    //So we need parallel test execution using "ThreadLocal"
    private static final ThreadLocal <WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

    //set value using setter method
    // Setter method to set the WebDriver instance for the current thread
    // set korar time get korar drkr nai..."void"
    public static void setDriver(WebDriver driver){
        DriverSetUp.LOCAL_DRIVER.set(driver);
    }

    //Getter method to retrieve the WebDriver instance for the current thread
    //"LOCAL_DRIVER" ar value return korbe
    //Encapsulation Technique: Internal Machanism Hide kore rakbe ..... sudu jototuk drkr show korbe
    public static WebDriver getDriver(){
        return LOCAL_DRIVER.get();
    }

    //This method will return WebDriver .... // String Type Name
    public static WebDriver createDriver(String browserName){
            //equalsIgnoreCase will ignore caseSensitive
        if(browserName.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        }
        else {
            throw new RuntimeException("Browser Not Found:" + browserName);
        }

    }

    // Run very first
    //When a method is synchronized, only one thread can execute it at a time.
    // This is often used to prevent concurrent access and potential data corruption in multi-threaded environments.
    //synchronized- je jeta call korbe seta pabe and seta quite korbe
    @BeforeMethod
   public static synchronized void setBrowser(){
        WebDriver driver = createDriver(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        setDriver(driver);
    }

    @AfterMethod
    public static synchronized void quiteBrowser(){
        getDriver().quit();
    }
}
