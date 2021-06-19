package com.mao;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class BaseModel {

    public static String DRIVER_PATH = "D:\\java\\chromedriver.exe";
    public static ChromeDriver driver;

    public static void main(String[] args) {
        System.out.println(args[0]);
        initChromeDriver();
        driver.get("http://localhost:9528");
        WebElement source = driver.findElementByXPath("//*[@id=\"nodes\"]/li[1]");
        WebElement target = driver.findElementByXPath("//*[@id=\"canvas_1\"]");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target);

        driver.quit();
    }

    private static void initChromeDriver() {
        System.setProperty("webdriver.chrome.driver",DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }
}
