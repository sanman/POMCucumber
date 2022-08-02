package com.qa.factory;

public class DriverFactory {
  
  public WebDriver driver;
  
  public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
  
  public void init_driver(String browser) {
    
    System.out.println("browser value is: " + browser);
    
    if(browser.equals("chrome")){
      WebdriverManager.chromedriver().setup();
      tlDriver.set(new ChromeDriver());
    }
    else if(browser.equals("firefox")){
      WebdriverManager.firefoxdriver().setup();
      tlDriver.set(new FirefoxDriver());
    }
    else if(browser.equals("safari")){
      tlDriver.set(new SafariDriver()); 
    }
    else {
      System.out.println("Please enter the correct browser value: " + browser)
    }
    
    getDriver().manage().deleteAllCookies();
    getDriver().manage().window().maximize();
    return getDriver();
  }
  
  public static webDriver getDriver() {
    return tlDriver.get();
  }

}
